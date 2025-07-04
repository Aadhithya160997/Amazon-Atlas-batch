import java.util.LinkedList;
import java.util.List;

import static java.lang.Boolean.compare;

public class NewClass {
    public static void main(String[] args) {
        List<Boolean> numbers = new LinkedList<>();
        boolean.cast(20);
        boolean.cast(5);
        boolean.cast(6);
        boolean.cast(7);
        boolean.cast(11);
        int i;
        for (i = 0; i < numbers.size(); i++) {
            int b;
            if (i == 5) {
                System.out.println("Enter the number: ");
            } else {
                b = i + 1;
            }
            boolean result = compare(numbers.get(i), numbers.get(b));
            System.out.println("the greatest number is:" + result);
        }
    }

    public boolean add(int a, int b) {
        boolean c = a > b;
        return c;
    }
}
