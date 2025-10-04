package com.example.enrollment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.example.enrollment")
public class EnrollmentSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(EnrollmentSystemApplication.class, args);
    }
}
