import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Day11Task16 {
    public static void main(String[] args) {
        // Creating ArrayList to store numbers
        List<Integer> numbers = new ArrayList<>();
// int
        // Adding numbers to the list
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(55);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(90);

        // Displaying original numbers
        System.out.println("Original Numbers:");
        int size = numbers.size();
        System.out.println(size);


//        for (int i = 0; i <numbers.size() ; i++) {
//
//            System.out.println(numbers.get(i));
//        }
//        for(int i:numbers){
//            System.out.println(i);
//        }
//        numbers.forEach();
        numbers.forEach(a -> System.out.print((a + 4) + " "));


// Obtain an iterator for the ArrayList
        Iterator<Integer> iterator = numbers.iterator();

        // Iterate through the elements
        while (iterator.hasNext()) {
            int fruit = iterator.next();
            System.out.println(fruit);
//            boolean returnVal=method2(fruit,4);
//            System.out.println(returnVal);
//            if (returnVal){
//
//            }else{
//                System.out.println("Person less than 18 years");
//            }
//            method2(fruit,4);
        }


        // Filtering odd numbers using stream
        List<Integer> oddNumbers = numbers.stream()
                .filter(num -> num % 2 != 0)
                .collect(Collectors.toList());

        // Displaying odd numbers
        System.out.println("\n\nOdd Numbers:");
        oddNumbers.forEach(num -> System.out.print(num + " "));

        // Display count of odd numbers
        System.out.println("\n\nTotal odd numbers: " + oddNumbers.size());

        // Display which numbers are odd and which are even
        System.out.println("\nClassification of Numbers:");
        for (int num : numbers) {
            String type = (num % 2 != 0) ? "Odd" : "Even";
            System.out.println(num + " is " + type);
        }
    }

    public static boolean main(int a, int b) {
        int c = a + b;
        return c > 2;
    }
}



