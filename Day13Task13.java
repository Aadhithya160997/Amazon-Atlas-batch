import javax.xml.transform.Source;
import java.util.LinkedList;

public class Day13Task13 {
    public static void main(String[] args) {
        LinkedList<String> friends = new LinkedList<>();

        System.out.println("Adding elements using push: ");
        friends.push("Vinoth");
        System.out.println(friends);

        System.out.println("Adding elements using push: ");
        friends.push("Prasanth");
        System.out.println(friends);

        System.out.println("Adding elements using push: ");
        friends.push("Dinesh");
        System.out.println(friends);

        System.out.println("\n Current linked list ");
        System.out.println(friends);

        System.out.println("\nRemoving elements using pop():");
        System.out.println("Popped: " + friends.pop());
        System.out.println("After pop: " + friends);

        System.out.println("Popped: " + friends.pop());
        System.out.println("After pop: " + friends);
    }
}
