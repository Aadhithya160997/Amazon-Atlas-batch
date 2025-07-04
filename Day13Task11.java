import java.util.LinkedList;

public class Day13Task11 {
    public static void main(String[] args) {
        LinkedList<String> friends = new LinkedList<>();

        // Adding elements
        friends.add("Vinoth");
        friends.add("Prasanth");
        friends.add("Dinesh");
        friends.add("Ajith");
        System.out.println("\nDisplaying LinkedList:");
        for (String i : friends) {
            System.out.println(i);
        }
        String[] friendsArray = friends.toArray(new String[0]);
        System.out.println("\n Displaying after converting: ");
        for (String name : friendsArray) {
            System.out.println(name);
        }
    }
}
