import java.util.Arrays;
import java.util.LinkedList;

public class Day13task10 {
    public static void main(String[] args) {
        LinkedList<String> friends = new LinkedList<>();

        // Adding elements
        friends.add("Vinoth");
        friends.add("Prasanth");
        friends.add("Dinesh");
        friends.add("Ajith");

        System.out.println("Method 1 - using to string");
        System.out.println(friends);

        System.out.println("\n Method 2 print directly ");
        System.out.println(friends.toString());

        System.out.println("\n method 3 Join string: ");
        System.out.println(String.join(", ", friends));

        System.out.println("\n displaying individual");
        System.out.println("First: " + friends.getFirst());
        System.out.println("First: " + friends.get(1));
        System.out.println("First: " + friends.get(2));
        System.out.println("First: " + friends.getLast());

    }
}
