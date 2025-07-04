public class Day11Task10 {
    public static void main(String[] args) {
        String original = "Hello world";
        String reversed = new StringBuilder(original).reverse().toString();

        System.out.println("Original String: " + original);
        System.out.println("Reversed String: " + reversed);
    }

}
