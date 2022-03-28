import java.util.*;
public class A1 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        TreeMap<String, ArrayList<Integer>> c= new TreeMap<>();
        int i = 0;
        while (i < 5) {
            System.out.print("Geben Sie ein Wort und eine Zahl ein: ");
            String wort= console.next();
            int zahl= console.nextInt();
            if (!c.containsKey(wort)) {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(zahl);
                c.put(wort, arr);
            } else {
                c.get(wort).add(zahl);
            }
            i++;
        }
        System.out.println(c);
    }
}