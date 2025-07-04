import java.util.Stack;

public class EmptyStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Check if stack is empty before adding elements
        System.out.println("Is stack empty before pushing? " + stack.isEmpty());

        // Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Check if stack is empty after pushing elements
        System.out.println("Is stack empty after pushing? " + stack.isEmpty());

        System.out.println("Stack: " + stack);

        int poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement);
        System.out.println("Stack after pop: " + stack);

        int position = stack.search(20);
        System.out.println("The stack position is: " + position);

        // Pop all elements
        stack.pop();
        stack.pop();

        // Check if stack is empty after popping all elements
        System.out.println("Is stack empty after popping all? " + stack.isEmpty());
    }
}
