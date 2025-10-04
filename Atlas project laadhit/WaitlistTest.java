import com.example.enrollment.dynamodb.WaitlistService;

public class WaitlistTest {
    public static void main(String[] args) {
        WaitlistService waitlistService = new WaitlistService();

        // Test Case 4: Handle seat drop when a student unenrolls from a course
        System.out.println("Test Case 4: Handle seat drop when a student unenrolls from a course");

        String courseId = "CSE101";  // The course for which the seat drop is simulated
        waitlistService.handleSeatDrop(courseId);  // Simulate a seat drop and handle it
    }
}









