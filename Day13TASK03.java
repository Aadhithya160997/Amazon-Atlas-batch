class Node {
    int data;
    Node next;

    // Constructor
    public Node(int value) {
        this.data = value;
        this.next = null;
    }
}

class LinkedList {
    private Node head;

    // Constructor
    public LinkedList() {
        this.head = null;
    }

    // Insert a node at the end of the list
    public void insertAtEnd(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Delete a node with specific value
    public void deleteByValue(int value) {
        if (head == null) {
            return;
        }

        if (head.data == value) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // Display the linked list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

// Main class
public class Day13TASK03 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Insert some elements
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        System.out.print("Linked List: ");
        list.display();

        // Delete 20
        list.deleteByValue(20);

        System.out.print("After Deleting 20: ");
        list.display();
    }
}
