package com.example.enrollment.model;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import lombok.Data;

@Data
@DynamoDbBean
public class Student {
    private String studentId;
    private String name;
    private String email;

    @DynamoDbPartitionKey
    public String getStudentId() {
        return studentId;
    }
}

