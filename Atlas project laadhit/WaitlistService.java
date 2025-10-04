package com.example.enrollment.dynamodb;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import software.amazon.awssdk.regions.Region;

import java.net.URI;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class WaitlistService {

    private final DynamoDbClient dynamoDb;
    private static final String COURSES_TABLE = "Courses";
    private static final String WAITLIST_TABLE = "Waitlist";

    public WaitlistService() {
        this.dynamoDb = DynamoDbClient.builder()
                .region(Region.US_EAST_1)
                .endpointOverride(URI.create("http://localhost:8000")) // DynamoDB Local
                .build();
    }

    public void attemptEnrollment(String studentId, String courseId) {
        int availableSeats = getAvailableSeats(courseId);

        if (availableSeats > 0) {
            enrollStudent(studentId, courseId);
        } else {
            addToWaitlist(studentId, courseId);
        }
    }

    private int getAvailableSeats(String courseId) {
        GetItemRequest getRequest = GetItemRequest.builder()
                .tableName(COURSES_TABLE)
                .key(Map.of("courseId", AttributeValue.fromS(courseId)))
                .build();

        GetItemResponse response = dynamoDb.getItem(getRequest);

        if (response.hasItem()) {
            String seats = response.item().get("availableSeats").n();
            return Integer.parseInt(seats);
        } else {
            System.out.println("Course not found: " + courseId);
            return -1;
        }
    }

    public void enrollStudent(String studentId, String courseId) {
        UpdateItemRequest updateRequest = UpdateItemRequest.builder()
                .tableName(COURSES_TABLE)
                .key(Map.of("courseId", AttributeValue.fromS(courseId)))
                .updateExpression("SET availableSeats = availableSeats - :dec")
                .expressionAttributeValues(Map.of(":dec", AttributeValue.fromN("1")))
                .build();

        dynamoDb.updateItem(updateRequest);
        System.out.println("✅ Student " + studentId + " enrolled in course " + courseId);
    }

    public void enrollStudentPublic(String studentId, String courseId) {
        enrollStudent(studentId, courseId);  // Call the private method internally
    }
    // Adding students to the waitlist (FIFO - First In, First Out)
    public void addToWaitlist(String studentId, String courseId) {
        // Store the student in the DynamoDB Waitlist table
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("courseId", AttributeValue.fromS(courseId));
        item.put("timestamp", AttributeValue.fromS(Instant.now().toString())); // FIFO order by timestamp
        item.put("studentId", AttributeValue.fromS(studentId));
        item.put("status", AttributeValue.fromS("WAITLISTED"));
        item.put("notificationStatus", AttributeValue.fromS("PENDING"));

        PutItemRequest putRequest = PutItemRequest.builder()
                .tableName(WAITLIST_TABLE)
                .item(item)
                .build();

        dynamoDb.putItem(putRequest);
        System.out.println("🕒 Student " + studentId + " added to waitlist for course " + courseId);
    }
    // Move students from waitlist to enrolled when a seat becomes available
    public void processAvailableSeat(String courseId) {
        // Step 1: Query the first student on the waitlist (FIFO - based on timestamp)
        QueryRequest queryRequest = QueryRequest.builder()
                .tableName(WAITLIST_TABLE)
                .keyConditionExpression("courseId = :courseId")
                .expressionAttributeValues(Map.of(":courseId", AttributeValue.fromS(courseId)))
                .scanIndexForward(true)  // Ensure FIFO order (ascending timestamp)
                .limit(1)  // Only retrieve the first student
                .build();

        QueryResponse response = dynamoDb.query(queryRequest);
        if (!response.items().isEmpty()) {
            // Step 2: Get the first student from the waitlist
            Map<String, AttributeValue> waitlistedStudent = response.items().get(0);
            String studentId = waitlistedStudent.get("studentId").s();
            String timestamp = waitlistedStudent.get("timestamp").s();

            // Step 3: Check if the 'status' attribute exists in the item
            if (!waitlistedStudent.containsKey("status")) {
                System.out.println("ℹ️ 'status' attribute not found for student: " + studentId);
                // You may want to update the waitlist entry to ensure the 'status' attribute exists
                // Update the 'status' attribute for this student (optional step)
                updateStatusForStudent(studentId, courseId, timestamp);
            }

            // Step 4: Update the student's status in the waitlist to ENROLLED
            Map<String, AttributeValue> key = Map.of(
                    "courseId", AttributeValue.fromS(courseId),
                    "timestamp", AttributeValue.fromS(timestamp)
            );

            // Use Expression Attribute Names to avoid using reserved word "status"
            Map<String, String> expressionAttributeNames = new HashMap<>();
            expressionAttributeNames.put("#status", "status");  // Rename 'status' to #status

            // UpdateItemRequest with Expression Attribute Names to avoid reserved keyword conflict
            UpdateItemRequest updateRequest = UpdateItemRequest.builder()
                    .tableName(WAITLIST_TABLE)
                    .key(key)
                    .updateExpression("SET #status = :enrolled, notificationStatus = :notified")
                    .expressionAttributeNames(expressionAttributeNames)
                    .expressionAttributeValues(Map.of(
                            ":enrolled", AttributeValue.fromS("ENROLLED"),
                            ":notified", AttributeValue.fromS("NOTIFIED")
                    ))
                    .build();

            dynamoDb.updateItem(updateRequest);
            decrementSeat(courseId); // Decrease available seats for the course

            // Step 5: Delete the student from the Waitlist table after they are moved to enrolled
            deleteWaitlistEntry(courseId, timestamp);  // Delete the student's entry from the waitlist

            System.out.println("🎉 Seat available! Student " + studentId + " moved from WAITLISTED → ENROLLED.");
        } else {
            System.out.println("ℹ️ No students on waitlist for course: " + courseId);
        }
    }

    // Helper method to ensure the 'status' attribute exists for a student
    private void updateStatusForStudent(String studentId, String courseId, String timestamp) {
        // Update the status attribute to a default value (WAITLISTED) if it's missing
        Map<String, AttributeValue> key = Map.of(
                "courseId", AttributeValue.fromS(courseId),
                "timestamp", AttributeValue.fromS(timestamp)
        );

        UpdateItemRequest updateRequest = UpdateItemRequest.builder()
                .tableName(WAITLIST_TABLE)
                .key(key)
                .updateExpression("SET status = :status")
                .expressionAttributeValues(Map.of(":status", AttributeValue.fromS("WAITLISTED")))
                .build();

        dynamoDb.updateItem(updateRequest);
        System.out.println("✅ 'status' field added to waitlist for student: " + studentId);
    }

    // Helper method to delete the student's entry from the Waitlist after they are enrolled
    private void deleteWaitlistEntry(String courseId, String timestamp) {
        Map<String, AttributeValue> key = Map.of(
                "courseId", AttributeValue.fromS(courseId),
                "timestamp", AttributeValue.fromS(timestamp)
        );

        DeleteItemRequest deleteRequest = DeleteItemRequest.builder()
                .tableName(WAITLIST_TABLE)
                .key(key)
                .build();

        dynamoDb.deleteItem(deleteRequest);
        System.out.println("✅ Deleted waitlist entry for student in course " + courseId);
    }

    // Decrement the seat count when a student is moved from the waitlist to enrolled
    private void decrementSeat(String courseId) {
        UpdateItemRequest update = UpdateItemRequest.builder()
                .tableName(COURSES_TABLE)
                .key(Map.of("courseId", AttributeValue.fromS(courseId)))
                .updateExpression("SET availableSeats = availableSeats - :dec")
                .expressionAttributeValues(Map.of(":dec", AttributeValue.fromN("1")))
                .build();

        dynamoDb.updateItem(update);
    }

    // Handle seat drop when a student unenrolls from the course
    public void handleSeatDrop(String courseId) {
        // Step 1: Increase availableSeats when a student drops a course
        UpdateItemRequest updateSeats = UpdateItemRequest.builder()
                .tableName(COURSES_TABLE)
                .key(Map.of("courseId", AttributeValue.fromS(courseId)))
                .updateExpression("SET availableSeats = availableSeats + :inc")
                .expressionAttributeValues(Map.of(":inc", AttributeValue.fromN("1"))) // Increase seats by 1
                .build();

        dynamoDb.updateItem(updateSeats);
        System.out.println("✅ Seat freed up for course " + courseId);

        // Step 2: Check if a student is on the waitlist and move them to enrolled
        processAvailableSeat(courseId);  // Move the first student on the waitlist to enrolled
    }

}
