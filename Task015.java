public class Task015 {
        public static void main(String[] args) {
            // Method 1: String Literal
            String str1 = "Java Strings ";

            // Method 2: Using new keyword and existing string
            String str2 = new String(str1);

            // Method 3: Using new keyword with direct string
            String str3 = new String("are easy to learn ");

            // Method 4: Creating string from char array
            char ch[] = {'S', 't', 'r', 'i', 'n', 'g'};
            String str4 = new String(ch);

            // Printing all strings
            System.out.println(str1 + "\n" + str2 + "\n" + str3 + "\n" + str4);
        }
    }
