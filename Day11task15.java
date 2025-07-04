import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day11task15 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        numbers.add(2);
        numbers.add(4);
        numbers.add(6);
        numbers.add(8);
        numbers.add(10);

        System.out.println("Original Numbers:");
        numbers.forEach(num -> System.out.print(num + " "));

        List<Integer> squareOfNums = numbers.stream()
                .map(num -> num * num)
                .collect(Collectors.toList());

        System.out.println("\n\nSquares of Numbers:");
        squareOfNums.forEach(square -> System.out.print(square + " "));

        System.out.println("\n\nNumbers and their Squares:");
        for(int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i) + " " + squareOfNums.get(i));
        }
    }
}
