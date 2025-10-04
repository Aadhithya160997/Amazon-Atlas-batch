package com.example.enrollment.dynamodb;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.net.URI;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class StudentLogService {
    private final DynamoDbClient dynamoDb;

    public StudentLogService() {
        this.dynamoDb = DynamoDbClient.builder()
                .region(software.amazon.awssdk.regions.Region.US_EAST_1)  // Choose your AWS region
                .endpointOverride(URI.create("http://localhost:8000"))  // Local DynamoDB endpoint
                .build();
    }

    // Log student login event
    public void logStudentLogin(String studentId) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("studentId", AttributeValue.fromS(studentId));
        item.put("timestamp", AttributeValue.fromS(Instant.now().toString())); // Current time
        item.put("action", AttributeValue.fromS("LOGIN"));

        PutItemRequest request = PutItemRequest.builder()
                .tableName("StudentLogsV3")  // Your DynamoDB table name
                .item(item)
                .build();

        dynamoDb.putItem(request);
        System.out.println("Login log inserted for student: " + studentId);
    }

    // Query student login logs
    public void getLoginLogs(String studentId) {
        QueryRequest request = QueryRequest.builder()
                .tableName("StudentLogsV3")  // Your DynamoDB table name
                .keyConditionExpression("studentId = :id")
                .expressionAttributeValues(Map.of(":id", AttributeValue.fromS(studentId)))
                .build();

        QueryResponse response = dynamoDb.query(request);
        response.items().forEach(item -> {
            System.out.println("Timestamp: " + item.get("timestamp").s());
            System.out.println("Action: " + item.get("action").s());
        });
    }
    public void getLogsByAction(String action) {
        QueryRequest request = QueryRequest.builder()
                .tableName("StudentLogsV3")
                .keyConditionExpression("action = :action")
                .expressionAttributeValues(Map.of(":action", AttributeValue.fromS(action)))
                .build();

        QueryResponse response = dynamoDb.query(request);
        response.items().forEach(item -> {
            System.out.println("StudentId: " + item.get("studentId").s());
            System.out.println("Timestamp: " + item.get("timestamp").s());
            System.out.println("Action: " + item.get("action").s());
        });
    }
}

