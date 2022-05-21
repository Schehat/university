
public class Aa {
    int x, y;
    
    public Aa(String s) {
        String[] arr = s.split(",");
        x = Integer.parseInt(arr[0]);
        y = Integer.parseInt(arr[1]);
    }
}
