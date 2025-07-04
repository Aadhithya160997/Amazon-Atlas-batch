import java.util.stream.Stream;

public class Day11Atsk18 {
    public static void main(String[] args) {
        // Creating a stream that iterates from 1, incrementing by 1, limited to 20 numbers
        Stream<Integer> nums = Stream
                .iterate(1, n -> n + 1)
                .limit(20);

        System.out.println("First 10 numbers from the stream:");
        nums
                .limit(10)
                .forEach(System.out::println);

        // Creating another stream because the first one is consumed
        System.out.println("\nFirst 10 numbers with their squares:");
        Stream
                .iterate(1, n -> n + 1)
                .limit(20)
                .limit(10)
                .forEach(n -> System.out.println(n + " -> " + (n * n)));

        // Alternative way using peek to show all 20 numbers but print only first 10
        System.out.println("\nProcessing 20 numbers but showing only first 10:");
        Stream
                .iterate(1, n -> n + 1)
                .limit(20)
                .peek(n -> {
                    if(n <= 10) {
                        System.out.println("Processing: " + n);
                    }
                })
                .count();
    }
}


