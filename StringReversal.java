import java.sql.Statement;

public class StringReversal {
    public static void main(String[] args) {
        String original = "Hello, World";
        System.out.println("Original String: " + original);
        System.out.println("Reverse String: " + reverseUsingStringBuilder(original));
        System.out.println("Reverse String: " + reverseUsingCharArray(original));


    }
    public static String reverseUsingStringBuilder(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    public static String reverseUsingCharArray(String str) {
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length -1;

        while (left<right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            left++;
            right--;
        }
        return new String(charArray);
    }
}
