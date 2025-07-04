// Node class remains the same
class Node<T> {
    T data;
    Node<T> next;

    public Node(T value) {
        this.data = value;
        this.next = null;
    }
}

class LinkedList<T> {
    private Node<T> head;
    private int size; // Added to track size of list

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Add element at the end of the list with error handling
    public void addLast(T value) {
        try {
            if (value == null) {
                throw new IllegalArgumentException("Cannot add null value to the list");
            }

            Node<T> newNode = new Node<>(value);

            if (head == null) {
                head = newNode;
                System.out.println("Added first element: " + value);
            } else {
                Node<T> temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
                System.out.println("Added element at end: " + value);
            }
            size++;
        } catch (Exception e) {
            System.out.println("Error adding element: " + e.getMessage());
        }
    }

    // Remove node from a specific position with improved error handling
    public void removeAt(int position) {
        try {
            if (head == null) {
                throw new IllegalStateException("List is empty. Nothing to remove.");
            }

            if (position < 0 || position >= size) {
                throw new IndexOutOfBoundsException("Invalid position: " + position + ". Valid range: 0 to " + (size - 1));
            }

            if (position == 0) {
                System.out.println("Removed element: " + head.data);
                head = head.next;
                size--;
                return;
            }

            Node<T> temp = head;
            Node<T> prev = null;
            int count = 0;

            while (count < position) {
                prev = temp;
                temp = temp.next;
                count++;
            }

            prev.next = temp.next;
            System.out.println("Removed element at position " + position + ": " + temp.data);
            size--;

        } catch (Exception e) {
            System.out.println("Error removing element: " + e.getMessage());
        }
    }

    // Display all elements with additional information
    public void displayList() {
        try {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }

            System.out.println("\nElements in the list (Size: " + size + "):");
            Node<T> temp = head;
            int position = 0;
            while (temp != null) {
                System.out.print("[" + position + "]" + temp.data);
                if (temp.next != null) {
                    System.out.print(" -> ");
                }
                temp = temp.next;
                position++;
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("Error displaying list: " + e.getMessage());
        }
    }

    // Added method to get size of list
    public int getSize() {
        return size;
    }
}

// Person class moved outside main for better organization
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + "(" + age + ")";
    }
}

public class DAy13task05 {
    public static void main(String[] args) {
        try {
            // Testing with Integer List
            testIntegerList();

            // Testing with String List
            testStringList();

            // Testing with Person List
            testPersonList();

            // Testing error cases
            testErrorCases();

        } catch (Exception e) {
            System.out.println("Main error: " + e.getMessage());
        }
    }

    private static void testIntegerList() {
        System.out.println("\n=== Testing Integer List ===");
        LinkedList<Integer> intList = new LinkedList<>();

        intList.addLast(10);
        intList.addLast(20);
        intList.addLast(30);
        intList.addLast(40);

        intList.displayList();
        intList.removeAt(2);
        intList.displayList();
    }

    private static void testStringList() {
        System.out.println("\n=== Testing String List ===");
        LinkedList<String> stringList = new LinkedList<>();

        stringList.addLast("Hello");
        stringList.addLast("World");
        stringList.addLast("Java");

        stringList.displayList();
        stringList.removeAt(1);
        stringList.displayList();
    }

    private static void testPersonList() {
        System.out.println("\n=== Testing Person List ===");
        LinkedList<Person> personList = new LinkedList<>();

        personList.addLast(new Person("Alice", 25));
        personList.addLast(new Person("Bob", 30));
        personList.addLast(new Person("Charlie", 35));

        personList.displayList();
        personList.removeAt(1);
        personList.displayList();
    }

    private static void testErrorCases() {
        System.out.println("\n=== Testing Error Cases ===");
        LinkedList<Integer> errorList = new LinkedList<>();

        // Test removing from empty list
        errorList.removeAt(0);

        // Test adding null
        errorList.addLast(null);

        // Test invalid position
        errorList.addLast(1);
        errorList.removeAt(5);
    }
}
