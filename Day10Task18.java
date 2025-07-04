class Test extends Thread {
    public void run() {
        System.out.println("thread started: ");
    }
    public void run1() {
        System.out.println("thread ended: ");
    }
}
    public class Day10Task18{
        public static void main(String[] args) {
            Test t1 = new Test();
            Thread th1 = new Thread();
            th1.start();
            t1.run();
        }
    }
