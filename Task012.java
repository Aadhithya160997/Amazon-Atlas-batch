import java.util.Scanner;

class Task012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Correct credentials
        String correctId = "Aadhithya";
        String correctPwd = "Aadhiy";

        boolean loginSuccess = false;
        int attempts = 3;  // Number of attempts allowed

        while(attempts > 0 && !loginSuccess) {
            System.out.println("\nAttempts remaining: " + attempts);

            // Get user input
            System.out.print("Enter Login ID: ");
            String userId = sc.nextLine();

            System.out.print("Enter Password: ");
            String userPwd = sc.nextLine();

            // Check credentials
            if(userId.equals(correctId) && userPwd.equals(correctPwd)) {
                System.out.println("Login Successful!");
                loginSuccess = true;
            } else {
                System.out.println("Invalid Login or Password!");
                attempts--;
            }
        }

        if(!loginSuccess) {
            System.out.println("\nAccount locked! Too many failed attempts!");
        }

        sc.close();
    }
}