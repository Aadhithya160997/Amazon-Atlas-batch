import java.util.ArrayList;
import java.util.List;

public class ClassImplementsInterface {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(12);
        numbers.add(15);
        numbers.add(17);
        numbers.add(18);
        numbers.add(11);
        numbers.add(10);


        for (int i = 0; i < numbers.size(); i++) {
            int b;
            if (i == 5) {
                b = 0;
            } else {
                b = i + 1;
            }
            int result = add(numbers.get(i), numbers.get(b));
            System.out.println(result);
        }

        int result = add(numbers.get(1), numbers.get(0));
        System.out.println(result);
        int result2 = add(numbers.get(3), numbers.get(4), numbers.get(5));
        System.out.println(result2);

    }

    public static int add(int a, int b) {
        int c = a + b;
        return c;
    }

    public static int add(int a, int b, int c) {
        int d = a + b + c;
        return d;
    }

}
