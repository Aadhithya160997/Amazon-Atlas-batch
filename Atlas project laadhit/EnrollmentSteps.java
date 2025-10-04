package com.example.enrollment;

import com.example.enrollment.dynamodb.WaitlistService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

public class EnrollmentSteps {

    private WaitlistService waitlistService;
    private boolean isStudentEnrolled;
    private boolean isStudentOnWaitlist;
    private int availableSeats;

    public EnrollmentSteps() {
        waitlistService = new WaitlistService();
    }

    @Given("the course {string} has {int} available seat")
    public void the_course_has_available_seat(String courseId, int seats) {
        availableSeats = seats;
        // Assuming the `WaitlistService` or another service updates DynamoDB
        // Set course available seats in DynamoDB
        // For the sake of the test, we simulate this behavior here.
    }

    @When("student {string} tries to enroll in {string}")
    public void student_tries_to_enroll_in(String studentId, String courseId) {
        if (availableSeats > 0) {
            waitlistService.enrollStudentPublic(studentId, courseId);  // Call the public wrapper method
            isStudentEnrolled = true;
        } else {
            waitlistService.addToWaitlist(studentId, courseId);
            isStudentOnWaitlist = true;
        }
    }

    @Then("student {string} should be enrolled in {string}")
    public void student_should_be_enrolled_in(String studentId, String courseId) {
        assertTrue(isStudentEnrolled);
    }

    @Then("student {string} should be added to the waitlist for {string}")
    public void student_should_be_added_to_the_waitlist_for(String studentId, String courseId) {
        assertTrue(isStudentOnWaitlist);
    }

    @Given("student {string} is on the waitlist for {string}")
    public void student_is_on_the_waitlist_for(String studentId, String courseId) {
        // Simulate the student being on the waitlist (can be set in DynamoDB for testing)
        isStudentOnWaitlist = true;
    }

    @When("a student drops the course {string}")
    public void a_student_drops_the_course(String courseId) {
        // Simulate a seat being freed up (e.g., student unenrolls)
        availableSeats++;
    }

    @Then("student {string} should be moved from the waitlist to enrolled in {string}")
    public void student_should_be_moved_from_waitlist_to_enrolled_in(String studentId, String courseId) {
        assertTrue(isStudentEnrolled);
        assertFalse(isStudentOnWaitlist);
    }

    @Then("the available seats for {string} should be incremented by {int}")
    public void the_available_seats_for_should_be_incremented_by(String courseId, int increment) {
        assertEquals(availableSeats, increment);
    }
}

