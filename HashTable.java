import java.util.Map;
import java.util.Hashtable;

public class HashTable {
    public static void main(String[] args) {
        Hashtable<String, Integer> ht = new Hashtable<>();
        ht.put ("Aadhithya", 101);
        ht.put("Vignesh", 102);
        ht.put("Prasanth" , 103);
        for(Map.Entry<String, Integer>e : ht.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());
    }

}
