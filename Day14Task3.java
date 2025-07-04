class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    Node head;

    // Constructor
    public CircularLinkedList() {
        this.head = null;
    }

    // Add node at the end
    public void append(int data) {
        Node newNode = new Node(data);

        // If list is empty
        if (head == null) {
            head = newNode;
            newNode.next = head;  // Point to itself to make it circular
            return;
        }

        // Find the last node
        Node current = head;
        while (current.next != head) {
            current = current.next;
        }

        // Add new node and make it circular
        current.next = newNode;
        newNode.next = head;
    }

    // Iterative traversal
    public void traverse() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("head"); // Shows it points back to head
    }

    // Recursive traversal
    public void traverseRecursive(Node node, Node first) {
        if (node == null) {
            System.out.println("List is empty");
            return;
        }

        if (node.next == first) {
            System.out.print(node.data + " -> head");
            System.out.println();
            return;
        }

        System.out.print(node.data + " -> ");
        traverseRecursive(node.next, first);
    }
}

public class Day14Task3 {
    public static void main(String[] args) {
        // Create a new CircularLinkedList
        CircularLinkedList list = new CircularLinkedList();

        // Add elements
        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);
        list.append(50);

        // Iterative traversal
        System.out.println("Iterative Traversal:");
        list.traverse();

        // Recursive traversal
        System.out.println("\nRecursive Traversal:");
        list.traverseRecursive(list.head, list.head);
    }
}

