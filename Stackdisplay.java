import java.util.Stack;

public class Stackdisplay {
        public static void main(String[] args) {
            Stack<Integer> stack = new Stack<>();
            stack.push(10);
            stack.push(20);
            stack.push(30);
                     System.out.println("Stack: " + stack);
            int poppedElement = stack.pop();
            System.out.println("Popped element: " + poppedElement);
            System.out.println("Stack after pop: " + stack);
            int position = stack.search(20);
            System.out.println("The stack position is :" + position);
        }
    }
