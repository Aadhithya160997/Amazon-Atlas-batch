package com.example.enrollment.repository;

import com.example.enrollment.model.Student;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {
    private final Map<String, Student> store = new HashMap<>();

    public Student findById(String id) {
        return store.get(id);
    }

    public void save(Student student) {
        store.put(student.getStudentId(), student);
    }
}

