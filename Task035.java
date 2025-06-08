public class Task035 {
    void add(char x, char y) {
        System.out.println("x: " + x + ", y: " + y);
    }

    void add(int x, int y) {
        System.out.println("x: " + x + ", y: " + y);
    }

    public static void main(String[] args) {
        Task035 task = new Task035();
        task.add('d', 'a');
        task.add(100, 100);
    }
}
