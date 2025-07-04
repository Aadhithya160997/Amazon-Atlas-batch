class Counter {
    private int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

    class Threaddemo extends Thread {
        Counter counter;

        Threaddemo(Counter counter) {
            this.counter = counter;
        }

        public void run() {
            for (int i = 0; i < 10; i++) {
                counter.increment();
            }
        }
    }

    public class Day10Task05 {
        public static void main(String[] args) {
            Counter counter = new Counter();
            Threaddemo t1 = new Threaddemo(counter);
            Threaddemo t2 = new Threaddemo(counter);

            t1.start();
            t2.start();

            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Final count: " + counter.getCount());
        }
    }

