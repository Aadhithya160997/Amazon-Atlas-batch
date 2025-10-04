package com.example.enrollment.model;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import lombok.Data;

@Data
@DynamoDbBean
public class Enrollment {
    private String enrollmentId;
    private String studentId;
    private String courseId;
    private String status; // ENROLLED or WAITLISTED

    @DynamoDbPartitionKey
    public String getEnrollmentId() {
        return enrollmentId;
    }
}
