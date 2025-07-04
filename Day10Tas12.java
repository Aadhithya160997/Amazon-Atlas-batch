import java.util.stream.*;
class Day10tas12{
    public static void main(String[] args) {
        Stream<String>stream = Stream.of("Hello", "my" , "name" , "is" , "Aadhithya");
        stream.forEach(System.out::println);
    }
}
