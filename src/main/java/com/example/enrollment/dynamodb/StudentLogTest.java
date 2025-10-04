package com.example.enrollment.dynamodb;
public class StudentLogTest {
    public static void main(String[] args) {
        StudentLogService logService = new StudentLogService();

        // Test logging in a student
        logService.logStudentLogin("student123");

        // Test retrieving login logs for the student
        logService.getLoginLogs("student123");
    }
}
