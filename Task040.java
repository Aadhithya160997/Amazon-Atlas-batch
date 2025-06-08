public class Task040 {
    // Made inner classes static to be accessible from static main method
    static abstract class Gadgets {
        abstract void turnOn();
        abstract void turnOff();
    }

    static class TVRemote extends Gadgets {
        @Override
        void turnOn() {
            System.out.println("TV is turned ON.");
        }

        @Override
        void turnOff() {
            System.out.println("TV is turned OFF.");
        }
    }

    static class ACRemote extends Gadgets {
        @Override
        void turnOn() {
            System.out.println("AC is turned ON.");
        }

        @Override
        void turnOff() {
            System.out.println("AC is turned OFF.");
        }
    }

    static class FanRemote extends Gadgets {
        @Override
        void turnOn() {
            System.out.println("Fan is turned ON.");
        }

        @Override
        void turnOff() {
            System.out.println("Fan is turned OFF.");
        }
    }

    static class CoolerRemote extends Gadgets {
        @Override
        void turnOn() {
            System.out.println("Cooler is turned ON.");
        }

        @Override
        void turnOff() {
            System.out.println("Cooler is turned OFF.");
        }
    }

    // Moved main method directly into Task040
    public static void main(String[] args) {
        // Creating objects with different names
        Gadgets tvRemote = new TVRemote();
        Gadgets acRemote = new ACRemote();
        Gadgets fanRemote = new FanRemote();
        Gadgets coolerRemote = new CoolerRemote();

        // Operating TV Remote
        System.out.println("\nOperating TV Remote:");
        tvRemote.turnOn();
        tvRemote.turnOff();

        // Operating AC Remote
        System.out.println("\nOperating AC Remote:");
        acRemote.turnOn();
        acRemote.turnOff();

        // Operating Fan Remote
        System.out.println("\nOperating Fan Remote:");
        fanRemote.turnOn();
        fanRemote.turnOff();

        // Operating Cooler Remote
        System.out.println("\nOperating Cooler Remote:");
        coolerRemote.turnOn();
        coolerRemote.turnOff();
    }
}
