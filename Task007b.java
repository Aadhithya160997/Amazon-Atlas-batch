    import java.util.Scanner;

    class Task007b {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Id : ");
            String id = sc.nextLine();

            System.out.print("Pwd: ");
            String pwd = sc.nextLine();

            System.out.println("\nHi,");
            System.out.println("\tYour login id is " + id);

            String maskedPwd = "";
            for (int i = 0; i < pwd.length(); i++) {
                maskedPwd += "*";
            }

            System.out.println("And your pwd is " + maskedPwd);

            sc.close();
        }
    }

