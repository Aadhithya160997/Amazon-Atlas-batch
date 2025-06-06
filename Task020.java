public class Task020 {
         public static void main(String[] args) {
            String name = "JOHN";
            char[] nameArray = name.toCharArray();

            // Print array
            System.out.println("Name array elements:");
            for(int i = 0; i < nameArray.length; i++) {
                System.out.println("Position " + i + ": " + nameArray[i]);
            }
        }
    }

