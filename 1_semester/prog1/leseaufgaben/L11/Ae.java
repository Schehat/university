import java.util.Scanner;
public class Ae {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Gebe 2 Zahlen ein: ");
        int a = console.nextInt();
        int b = console.nextInt();
        System.out.println("Rest von " + a + " / " + b + ": " + rest(a, b));
    }
    
    public static int rest(int a, int b) {
        if (a < b) {
            return a;
        }
        return rest(a - b, b);
    }
}
