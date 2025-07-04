class Node {
    String data;
    Node prev;
    Node next;

    Node(String data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;

    // Add element at the end
    public void add(String data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
        } else {
            Node last = head;
            while(last.next != null) {
                last = last.next;
            }
            last.next = newNode;
            newNode.prev = last;
        }
    }

    // Display forward
    public void displayForward() {
        Node current = head;
        System.out.print("Forward: ");
        while(current != null) {
            System.out.print(current.data);
            if(current.next != null) {
                System.out.print(" <-> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    // Display backward
    public void displayBackward() {
        Node last = head;
        while(last != null && last.next != null) {
            last = last.next;
        }

        System.out.print("Backward: ");
        while(last != null) {
            System.out.print(last.data);
            if(last.prev != null) {
                System.out.print(" <-> ");
            }
            last = last.prev;
        }
        System.out.println();
    }
}

public class Day13Task16 {
    public static void main(String[] args) {
        DoublyLinkedList friends = new DoublyLinkedList();

        // Adding elements
        friends.add("Vinoth");
        friends.add("Prasanth");
        friends.add("Dinesh");
        friends.add("Ajith");

        // Display the list in both directions
        System.out.println("Doubly Linked List:");
        friends.displayForward();
        friends.displayBackward();
    }
}
