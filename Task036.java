public class Task036 {
    static void add(int x, float y){
        System.out.println("x: " + x + ", y: " + y);
    }
    static void add(float x, int y){
        System.out.println("x: " + x + ", y: " + y);
    }
    public static void  main(String[] args){
        add(10.50f, 60);
        add(100, 80.80f);
    }

}
