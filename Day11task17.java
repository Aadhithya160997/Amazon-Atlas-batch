import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day11task17 {
    public static void main(String[] args) {
        // Creating ArrayList to store numbers
        List<Integer> numbers = new ArrayList<>();

        // Adding numbers with duplicates to the list
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(4);
        numbers.add(5);
        numbers.add(5);
        numbers.add(6);
        numbers.add(6);

        // Displaying original list with duplicates
        System.out.println("Original List with Duplicates:");
        numbers.forEach(num -> System.out.print(num + " "));

        // Removing duplicates using stream
        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        // Displaying list after removing duplicates
        System.out.println("\n\nList after removing duplicates:");
        uniqueNumbers.forEach(num -> System.out.print(num + " "));

        // Display counts
        System.out.println("\n\nOriginal list size: " + numbers.size());
        System.out.println("List size after removing duplicates: " + uniqueNumbers.size());

        // Display frequency of each number in original list
        System.out.println("\nFrequency of each number in original list:");
        uniqueNumbers.forEach(num -> {
            long frequency = numbers.stream().filter(n -> n == num).count();
            System.out.println(num + " appears " + frequency + " time(s)");
        });
    }
}
