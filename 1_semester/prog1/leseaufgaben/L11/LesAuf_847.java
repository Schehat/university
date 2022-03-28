import java.util.HashMap;
public class LesAuf_847 {
    public static void main(String[] args) {
        HashMap<String, String> byName = new HashMap<String, String>();
        byName.put("James Bond", "007");
        byName.put("Chanel", "No. 5");
        byName.put("Notruf", "112");
        byName.put("Porsche", "911");
        System.out.println(byName);
        
        HashMap<String, String> byPhone = new HashMap<String, String>();
        for (String key : byName.keySet()) {
            byPhone.put(byName.get(key), key);
        }
        System.out.println(byPhone);
    }
}
