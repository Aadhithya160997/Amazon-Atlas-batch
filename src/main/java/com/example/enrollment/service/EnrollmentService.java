package com.example.enrollment.service;

import com.example.enrollment.model.Enrollment;
import com.example.enrollment.model.Student;
import com.example.enrollment.model.Course;
import com.example.enrollment.repository.EnrollmentRepository;
import com.example.enrollment.repository.StudentRepository;
import com.example.enrollment.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public String enrollStudent(String studentId, String courseId) {
        Student student = studentRepository.findById(studentId);
        Course course = courseRepository.findById(courseId);

        if (student == null || course == null) {
            return "Student or Course not found.";
        }

        // TODO: Add prerequisite check here if needed

        int enrolledCount = enrollmentRepository.countEnrolledInCourse(courseId);

        Enrollment enrollment = new Enrollment();
        enrollment.setEnrollmentId(studentId + "_" + courseId);
        enrollment.setStudentId(studentId);
        enrollment.setCourseId(courseId);

        if (enrolledCount < course.getMaxSeats()) {
            enrollment.setStatus("ENROLLED");
        } else {
            enrollment.setStatus("WAITLISTED");
        }

        enrollmentRepository.save(enrollment);
        return "Student " + studentId + " is " + enrollment.getStatus() + " for course " + courseId;
    }

    public String dropStudent(String studentId, String courseId) {
        String enrollmentId = studentId + "_" + courseId;
        Enrollment existing = enrollmentRepository.findById(enrollmentId);

        if (existing == null) {
            return "Enrollment not found.";
        }

        enrollmentRepository.delete(enrollmentId);

        // Promote waitlisted student if any
        Enrollment waitlisted = enrollmentRepository.findFirstWaitlisted(courseId);
        if (waitlisted != null) {
            waitlisted.setStatus("ENROLLED");
            enrollmentRepository.save(waitlisted);
            return "Dropped. Promoted waitlisted student: " + waitlisted.getStudentId();
        }

        return "Student dropped from course.";
    }
}

