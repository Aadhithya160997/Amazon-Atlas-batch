public class Task004 {
    public static void main(String[] args) {
        int a = 2;
        int b = 5;

        System.out.println("Before swap");
        System.out.println("a=" + a + "b=" + b);

        //Swapping logic
        int temp = a;
        a = b;
        b = temp;

        System.out.println("After swap");
        System.out.println("a=" + a + " b=" + b);
    }
}
