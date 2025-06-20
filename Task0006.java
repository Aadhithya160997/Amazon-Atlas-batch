public class Task0006 {
            public static void main(String args[]) {
                int c = 0;
            try {
                int a[] = new int[2];
               System.out.println("Access element three :" + a[0]);
                try {
                    int b = 10;
                    c = 20/b;
                }catch(Exception e) {
                    System.out.println("Exception thrown: " + e);
                }
                System.out.println("Access element three :" + a[1]);
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Exception thrown: " + e);
            }finally {
                System.out.println("Out of the block");
                System.out.println("Average of the number: " + c);
            }
        }
    }

