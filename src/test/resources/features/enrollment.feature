Feature: Student Course Enrollment

  Scenario: Student successfully enrolls when seats are available
    Given the course "CSE101" has 1 available seat
    When student "student123" tries to enroll in "CSE101"
    Then student "student123" should be enrolled in "CSE101"

  Scenario: Student is added to the waitlist when no seats are available
    Given the course "CSE101" has 0 available seats
    When student "student124" tries to enroll in "CSE101"
    Then student "student124" should be added to the waitlist for "CSE101"

  Scenario: Student is moved from waitlist to enrolled when a seat becomes available
    Given the course "CSE101" has 0 available seats
    And student "student124" is on the waitlist for "CSE101"
    When a student drops the course "CSE101"
    Then student "student124" should be moved from the waitlist to enrolled in "CSE101"
    And the available seats for "CSE101" should be incremented by 1
