import java.util.Scanner;
public class LesAuf_725 {
    public static void main(String[] args) {
        String[] array= {"77", "28", "12", "43", "57"};
        Scanner scanner = new Scanner(String.join(" ", array));
        int sum = 0;
        while (scanner.hasNextInt()) {
            sum += scanner.nextInt();
        }
        System.out.println(sum);
    }
}