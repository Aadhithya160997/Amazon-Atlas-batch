import java.util.stream.Stream;

public class Day11Task19 {
    public static void main(String[] args) {
        // Creating a stream of 20 numbers and skipping first 15
        System.out.println("Numbers after skipping first 15:");
        Stream
                .iterate(1, n -> n + 1)
                .limit(20)
                .skip(15)
                .forEach(System.out::println);

        // Alternative way with showing what numbers were skipped
        System.out.println("\nDetailed view of numbers:");
        Stream
                .iterate(1, n -> n + 1)
                .limit(20)
                .peek(n -> {
                    if(n <= 15) {
                        System.out.println("Skipping: " + n);
                    }
                })
                .skip(15)
                .forEach(n -> System.out.println("Printing: " + n));

        // Using separate streams to show both skipped and printed numbers
        System.out.println("\nShowing all numbers and which are skipped/printed:");
        Stream<Integer> allNumbers = Stream
                .iterate(1, n -> n + 1)
                .limit(20);

        // First 15 numbers (skipped)
        System.out.println("Skipped numbers:");
        Stream
                .iterate(1, n -> n + 1)
                .limit(15)
                .forEach(System.out::println);

        // Numbers after skip
        System.out.println("\nPrinted numbers:");
        Stream
                .iterate(1, n -> n + 1)
                .limit(20)
                .skip(15)
                .forEach(System.out::println);
    }
}
