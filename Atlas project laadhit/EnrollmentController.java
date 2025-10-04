package com.example.enrollment.controller;

import com.example.enrollment.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enrollment")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/enroll")
    public String enroll(@RequestParam String studentId, @RequestParam String courseId) {
        return enrollmentService.enrollStudent(studentId, courseId);
    }

    @PostMapping("/drop")
    public String drop(@RequestParam String studentId, @RequestParam String courseId) {
        return enrollmentService.dropStudent(studentId, courseId);
    }
}
