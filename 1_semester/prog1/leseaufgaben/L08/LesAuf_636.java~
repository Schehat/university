import java.io.*;
import java.util.*;
public class LesAuf_636 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("numbers.txt"));
        input.useLocale(new Locale("en", "US"));
        double sum = 0.0;
        double next = 0.0;
        while (input.hasNext()) {
            if (input.hasNextDouble()) {
                next = input.nextDouble();
            }
            else {
                input.next();
                next = 0;
            }
            
            if (next != 0) {
                System.out.println("number = " + next);
                sum += next;
            }
        }
        input.close();
        System.out.println("Sum = " + sum);
    }
}