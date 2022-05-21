import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LA2 {

    public static void main(String[] args) {
        ArrayList<Color> list = new ArrayList<>();
        list.add(Color.RED);
        list.add(Color.BLACK);
        list.add(new Color(2, 2, 2));
        list.add(new Color(1, 1, 1));
        list.add(Color.GRAY);
        
//        Comparator<Color> cmp = new Comparator<Color>() {
//            @Override public int compare(Color a, Color b) {
//                return Double.compare(Math.sqrt(cal(a)), cal(b));
//            }
//        };
        
        Comparator<Color> cmp = (a, b) -> Double.compare(cal(a), cal(b));
        
        System.out.println(list);
        Collections.sort(list, cmp);
        System.out.println(list);

        
    }
    
    public static double cal (Color a) {
        double rr = a.getRed()*a.getRed();
        double gg = a.getGreen()*a.getGreen();
        double bb = a.getBlue()*a.getBlue();
        return Math.sqrt(0.241*rr+0.691*gg+0.068*bb);
    }

}
