class Customer {

    void accept() {
        System.out.println("accept Customer called");
    }

    void display() {
        System.out.println("display Customer called");
    }
}

// Test008 class
class Test008 {
    public static void main(String[] args) {
        Customer custom = new Customer();
        custom.accept();
        custom.display();
    }
}