package com.example.enrollment.repository;

import com.example.enrollment.model.Course;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CourseRepository {
    private final Map<String, Course> store = new HashMap<>();

    public Course findById(String id) {
        return store.get(id);
    }

    public void save(Course course) {
        store.put(course.getCourseId(), course);
    }
}

