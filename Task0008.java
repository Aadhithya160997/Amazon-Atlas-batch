class Task0008 extends Exception { // exception is a predefined class – parent class for MyException
        public Task0008(String m) {
            super(m); // calling the parent class constructor with parameters
        }
    }

    // A Class that uses the above MyException
  class setText {
        public static void main(String args[]) {
            try {

                // Throw an object of user-defined exception
                throw new Task0008("This is a custom exception");
            } catch (Task0008 ex) {
                System.out.println("Caught");
                System.out.println(ex.getMessage());
            }
        }
    }

