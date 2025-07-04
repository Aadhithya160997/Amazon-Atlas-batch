import java.util.LinkedList;

public class Day13Task12 {
    public static void main(String[] args) {
        LinkedList<String> friends = new LinkedList<>();
        friends.add("Vinoth");
        friends.add("Prasanth");
        friends.add("Dinesh");
        friends.add("Ajith");
        LinkedList<String> friendsClone = (LinkedList<String>) friends.clone();
        System.out.println("Original list");
        System.out.println(friends);

        System.out.println("Cloned list");
        System.out.println(friendsClone);
    }
}
