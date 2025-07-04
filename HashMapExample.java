import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        // Creating HashMap
        HashMap<String, Integer> hm = new HashMap<>(10);
        System.out.println("Output:");
        Map<String, Integer> synchronizedMap = Collections.synchronizedMap(new HashMap<>(10));
        // Adding elements to HashMap
        synchronizedMap.put("Aadhithya", 101);
        synchronizedMap.put("Vignesh", 102);
        synchronizedMap.put("Prasanth", 103);
        synchronizedMap.put(null, 240);
        synchronizedMap.put(null, 250);
        synchronizedMap.put("Vinoth", 106);


        // Printing elements
        // Method 1: Using entrySet()
        synchronized (synchronizedMap) {
            System.out.println("Using entrySet:");
            for (Map.Entry<String, Integer> e : synchronizedMap.entrySet()) {
                System.out.println(e.getKey() + " " + e.getValue());
            }
        }
    }
}


