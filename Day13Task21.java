class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class CircularLinkedList {
    Node head;

    // Add node at the end
    public void add(int data) {
        Node newNode = new Node(data);

        // If list is empty
        if (head == null) {
            head = newNode;
            newNode.next = head;  // Point to itself for circular nature
            return;
        }

        // Find last node
        Node last = head;
        while (last.next != head) {
            last = last.next;
        }

        // Add new node
        last.next = newNode;
        newNode.next = head;  // Make it circular
    }

    // Traverse and display elements
    public void traverse() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        System.out.print("Circular List: ");
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println(" (back to " + head.data + ")");
    }

    // Count nodes in circular list
    public int countNodes() {
        if (head == null) return 0;

        int count = 1;
        Node current = head.next;
        while (current != head) {
            count++;
            current = current.next;
        }
        return count;
    }
}

public class Day13Task21 {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        // Adding elements
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        // Traverse and display
        list.traverse();

        // Display count of nodes
        System.out.println("Number of nodes: " + list.countNodes());
    }
}
