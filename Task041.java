public class Task041 {
    import java.io.*;
    // Interface Declared
//Driver Code Ends
    interface testInterface {
        // public, static and final
        final int tax = 10;
        // public and abstract
        void display();
    }


    // Class implementing interface
    class TestClass implements testInterface {
        // Implementing the capabilities of
        // Interface
        public void display(){
            System.out.println("Myclass");
        }
    }
    class Myclass
//Driver Code Starts
    {
        public static void main(String[] args)
        {
            TestClass t = new TestClass();
            t.display();
            System.out.println(t.tax);
        }

    }
}

