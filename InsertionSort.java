import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];  // Current element to be inserted
            int j = i - 1;     // Index of last element in sorted portion

            System.out.println("\nIteration " + i + ":");
            System.out.println("Current element to insert: " + key);

            // Move elements of arr[0..i-1] that are greater than key
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;

            System.out.println("Array after iteration: " + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get array size from user
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
        insertionSort(arr);

        // Display final sorted array
        System.out.println("\nFinal sorted array: " + Arrays.toString(arr));

        scanner.close();
    }
}

