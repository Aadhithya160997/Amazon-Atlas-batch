import java.util.Stack;

public class PeekElement {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Display original stack
        System.out.println("Stack: " + stack);

        // Peek the top element
        int peekedElement = stack.peek();
        System.out.println("Peeked element (top element): " + peekedElement);
        System.out.println("Stack after peek: " + stack); // Stack remains unchanged

        // Pop operation
        int poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement);
        System.out.println("Stack after pop: " + stack);

        // Search operation
        int position = stack.search(20);
        System.out.println("The stack position is: " + position);
    }
}

