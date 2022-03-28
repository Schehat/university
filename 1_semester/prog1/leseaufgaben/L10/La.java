import java.util.ArrayList;
public class La {
    public static void main(String[] args) {
        ArrayList<Double> numbers = new ArrayList<Double>();
        for (double i = 0; i < 10; i++) {
            numbers.add(i);
        }
        for (int i = 0; i < numbers.size(); i++ ) {
            if ((i+1) % 3 == 0) {
                numbers.set(i, numbers.get(i-1));
            }
        }
    }
}

