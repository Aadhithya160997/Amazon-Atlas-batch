import java.util.ArrayList; // Import the ArrayList class

// Define a simple class to hold friend's first and last names
class Friend {
    String firstName;
    String lastName;

    // Constructor to initialize Friend objects
    public Friend(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Override toString() for easy printing of Friend objects
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

public class Day11Task13 {

    public static void main(String[] args) {
        // 1. Declare and initialize an ArrayList to store Friend objects.
        // The <Friend> specifies that this ArrayList will hold Friend objects.
        ArrayList<Friend> friends = new ArrayList<>();

        // 2. Add 5 friend names (first and last) to the ArrayList.
        System.out.println("Adding friends to the list...");
        friends.add(new Friend("Alice", "Smith"));
        friends.add(new Friend("Alice", "Johnson"));
        friends.add(new Friend("Charlie", "Brown"));
        friends.add(new Friend("Alice", "Miller"));
        friends.add(new Friend("Eve", "Davis"));
        System.out.println("Friends added successfully.");

        // 3. Print the contents of the ArrayList to verify.
        // Thanks to the overridden toString() in the Friend class, this will print nicely.
        System.out.println("\nHere are your friends in the list:");
        System.out.println(friends);

        // 4. Iterate through the ArrayList to print each name individually.
        System.out.println("\nIterating through the list:");
        for (Friend friend : friends) {
            System.out.println("- First Name: " + friend.firstName + ", Last Name: " + friend.lastName);
        }

        // Optional: Check the size of the ArrayList
        System.out.println("\nNumber of friends in the list: " + friends.size());
    }
}
