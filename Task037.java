public class Task037 {
    static class Employee {
        private int pwd;
        protected int salary;
        public int empid;

        // Constructor (not void)
        Employee() {
            // Constructor code here
        }
    }
}
    class Hr extends Task037.Employee {
        Hr() {
            // Can't access private pwd
            // super.pwd = 1254;    // This won't work as pwd is private
            super.salary = 50000;
            super.empid = 10001;
        }

        void displayInfo() {
            // Can't access private pwd
            System.out.println("Salary: " + salary);
            System.out.println("EmpID: " + empid);
        }
    }

    class Driver {
        public static void main(String[] args) {
            // Create an HR object
            Hr hrObj = new Hr();

            // Access variables based on their access modifiers
            // hrObj.pwd = 1254;    // Can't access - private
            hrObj.salary = 50000;    // Can access - protected
            hrObj.empid = 10001;     // Can access - public

            // Display information
            hrObj.displayInfo();
        }
    }

