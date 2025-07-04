import java.util.ArrayList;

public class ArrayReversal {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        System.out.println("The Given Numbers are:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        reverseArray(numbers);

        System.out.println("The Reversed numbers are:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void reverseArray(ArrayList<Integer> arr) {
        int left = 0;
        int right = arr.size() - 1;
        while (left < right) {
            // Swap elements
            int temp = arr.get(left);
            arr.set(left, arr.get(right));
            arr.set(right, temp);
            left++;
            right--;
        }
    }
}