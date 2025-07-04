class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Constructor
    public LinkedList() {
        this.head = null;
    }

    // Add node at the end
    public void append(int data) {
        Node newNode = new Node(data);

        // If list is empty, make new node as head
        if (head == null) {
            head = newNode;
            return;
        }

        // Traverse to last node and add new node
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Iterative traversal
    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Recursive traversal
    public void traverseRecursive(Node node) {
        if (node == null) {
            System.out.println("null");
            return;
        }
        System.out.print(node.data + " -> ");
        traverseRecursive(node.next);
    }
}

public class Day14Task1 {
    public static void main(String[] args) {
        // Create a new LinkedList
        LinkedList list = new LinkedList();

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
        list.traverseRecursive(list.head);
    }
}
