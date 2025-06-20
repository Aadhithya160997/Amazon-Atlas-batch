public class Task0004 {
    public static void main(String[] args) {
        try{
            int[] myNumbers = {1,2,3};
            System.out.println("2nd element: " + myNumbers[1]);
            System.out.println("3rd element: " + myNumbers[2]);
        } catch (Exception e) {
            System.out.println("Something went wrong");
        } finally {
            System.out.println("I'm from finally block");
        }
    }
}
