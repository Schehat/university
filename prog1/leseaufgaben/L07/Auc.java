import java.util.Random;
public class Auc {
    public static void main(String[] args) {
        Random rand = new Random();
        int n = 1;
        for (int i = 0; i < 100; i++) {
            int x = rand.nextInt(10);
            if (x <= 5) {
                n++;
            }
            else if (x >= 6 && x < 9) {
                n--;
            }
        }
        System.out.println(n);   
    }
}