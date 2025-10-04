package com.example.enrollment.model;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import lombok.Data;
import java.util.List;

@Data
@DynamoDbBean
public class Course {
    private String courseId;
    private String courseName;
    private int maxSeats;
    private List<String> prerequisites;

    @DynamoDbPartitionKey
    public String getCourseId() {
        return courseId;
    }
}
