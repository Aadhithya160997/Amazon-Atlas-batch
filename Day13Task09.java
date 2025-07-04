import java.util.LinkedList;

public class Day13Task09 {
    public static void main(String[] args) {
        LinkedList<String> friends = new LinkedList<>();

        // Adding elements
        friends.add("Vinoth");
        friends.add("Prasanth");
        friends.add("Dinesh");
        friends.add("Ajith");

        // 1. Display using get method in for loop
        System.out.println("Display using get method in for loop:");
        for(int i = 0; i < friends.size(); i++) {
            System.out.println(friends.get(i));
        }

        // 2. Display using for-each loop
        System.out.println("Original LinkedList using foreach:");
        friends.forEach(friend -> System.out.println(friend));

        System.out.println("\nAlternative way using method reference:");
        friends.forEach(System.out::println);
        }
    }

