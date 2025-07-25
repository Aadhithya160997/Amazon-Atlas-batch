import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // Set min to location 0
        for (int min = 0; min < n-1; min++) {
            System.out.println("\nIteration " + (min+1) + ":");
            System.out.println("Current min position: " + min);

            // Search min element in the array
            int minIndex = min;
            for (int j = min + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the values at location min
            if (minIndex != min) {
                System.out.println("Swapping " + arr[min] + " with " + arr[minIndex]);
                int temp = arr[min];
                arr[min] = arr[minIndex];
                arr[minIndex] = temp;
            } else {
                System.out.println("No swap needed");
            }

            // Show array after each iteration
            System.out.println("Array after iteration: " + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get array size
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Create and populate array
        int[] arr = new int[size];
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Display original array
        System.out.println("\nOriginal array: " + Arrays.toString(arr));

        // Sort array and show steps
        selectionSort(arr);

        // Display final sorted array
        System.out.println("\nFinal sorted array: " + Arrays.toString(arr));

        scanner.close();
    }
}
