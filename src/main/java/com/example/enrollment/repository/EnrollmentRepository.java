package com.example.enrollment.repository;

import com.example.enrollment.model.Enrollment;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EnrollmentRepository {

    private final Map<String, Enrollment> store = new HashMap<>();

    public void save(Enrollment enrollment) {
        store.put(enrollment.getEnrollmentId(), enrollment);
    }

    public Enrollment findById(String enrollmentId) {
        return store.get(enrollmentId);
    }

    public void delete(String enrollmentId) {
        store.remove(enrollmentId);
    }

    public int countEnrolledInCourse(String courseId) {
        return (int) store.values().stream()
                .filter(e -> e.getCourseId().equals(courseId) && e.getStatus().equals("ENROLLED"))
                .count();
    }

    public Enrollment findFirstWaitlisted(String courseId) {
        return store.values().stream()
                .filter(e -> e.getCourseId().equals(courseId) && e.getStatus().equals("WAITLISTED"))
                .findFirst()
                .orElse(null);
    }
}

