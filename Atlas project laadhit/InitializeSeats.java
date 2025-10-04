package com.example.enrollment.dynamodb;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.net.URI;
import java.util.Map;

public class InitializeSeats {

    private static final String COURSES_TABLE = "Courses"; // Courses table name

    public static void main(String[] args) {
        DynamoDbClient dynamoDb = DynamoDbClient.builder()
                .endpointOverride(URI.create("http://localhost:8000")) // DynamoDB Local
                .build();

        // Define the courseId and initial availableSeats value
        String[] courseIds = {"CSE101", "CSE102", "MATH201"};  // Example course IDs
        int initialSeats = 5;  // Initial seats available for each course

        for (String courseId : courseIds) {
            // Prepare the update request
            Map<String, AttributeValue> item = Map.of(
                    "courseId", AttributeValue.fromS(courseId),
                    "availableSeats", AttributeValue.fromN(String.valueOf(initialSeats))
            );

            UpdateItemRequest updateRequest = UpdateItemRequest.builder()
                    .tableName(COURSES_TABLE)
                    .key(Map.of("courseId", AttributeValue.fromS(courseId)))
                    .updateExpression("SET availableSeats = :availableSeats")
                    .expressionAttributeValues(Map.of(":availableSeats", AttributeValue.fromN(String.valueOf(initialSeats))))
                    .build();

            // Execute the update to add the availableSeats attribute
            dynamoDb.updateItem(updateRequest);
            System.out.println("Added/Updated availableSeats for course: " + courseId);
        }

        // Close the DynamoDb client
        dynamoDb.close();
    }
}

