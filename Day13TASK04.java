class Node<T> {
    T data;
    Node<T> next;

    // Constructor
    public Node(T value) {
        this.data = value;
        this.next = null;
    }
}

class LinkedList<T> {
    private Node<T> head;

    // Constructor
    public LinkedList() {
        this.head = null;
    }

    // Insert a node at the end of the list
    public void insertAtEnd(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Delete a node with specific value
    public void deleteByValue(T value) {
        if (head == null) {
            return;
        }

        if (head.data == value) {
            head = head.next;
            return;
        }

        Node<T> temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // Display the linked list
    public void display() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

// Main class
public class Day13TASK04 {
    public static void main(String[] args) {
        LinkedList<Integer> intList = new LinkedList<>();
        intList.insertAtEnd(10);
        intList.insertAtEnd(20);
        intList.insertAtEnd(30);
        System.out.print("Integer List: ");
        intList.display();

        LinkedList<String> stringList = new LinkedList<>();
        stringList.insertAtEnd("Hello");
        stringList.insertAtEnd("World");
        stringList.insertAtEnd("Java");
        System.out.print("String List: ");
        stringList.display();

        // Double LinkedList
        LinkedList<Double> doubleList = new LinkedList<>();
        doubleList.insertAtEnd(1.1);
        doubleList.insertAtEnd(2.2);
        doubleList.insertAtEnd(3.3);
        System.out.print("Double List: ");
        doubleList.display();

        // Custom Object LinkedList
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

        LinkedList<Person> personList = new LinkedList<>();
        personList.insertAtEnd(new Person("Alice", 25));
        personList.insertAtEnd(new Person("Bob", 30));
        personList.insertAtEnd(new Person("Charlie", 35));
        System.out.print("Person List: ");
        personList.display();
    }
}


