import java.util.ArrayList;

public class Day11Task12 {
    public static void main(String[] args) {
        ArrayList<String> friends = new ArrayList<>();
        System.out.println("Adding friends to the list...");
        friends.add("Alice");
        friends.add("Bob");
        friends.add("Charlie");
        friends.add("Diana");
        friends.add("Eve");
        System.out.println("Friends added successfully.");
        System.out.println("\nHere are your friends in the list:");
        System.out.println(friends);
        System.out.println("\nIterating through the list:");
        for (String friendName : friends) {
            System.out.println("- " + friendName);
            System.out.println("\nNumber of friends in the list: " + friends.size());
        }
    }
}
