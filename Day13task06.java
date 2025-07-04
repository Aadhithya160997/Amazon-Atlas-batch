import java.util.LinkedList;
public class Day13task06 {
    public static void main(String[] args) {
        LinkedList<String> friends = new LinkedList<>();
        friends.add("Vinoth");
        friends.add("Prasanth");
        friends.add("Dinesh");
        friends.add("Ajith");
        System.out.println("First element is :" + friends.getFirst());
        System.out.println("Last element is: " + friends.getLast());
        for (String i : friends) {
            System.out.println(i);
        }
        friends.set(0,"Vignesh");
        System.out.println("\n List after updating: ");
        System.out.println("\nThe fist updated element of the list: " + friends.getFirst());
        System.out.println("\nAll elements");
        for (String i : friends) {
            System.out.println(i);
        }
        friends.removeFirst();
        System.out.println("\n After removing first element :");
        for (String i : friends) {
            System.out.println(i);
        }
        friends.removeLast();
        System.out.println("\n After removing last element :");
        for (String i : friends) {
            System.out.println(i);
        }

    }
}
