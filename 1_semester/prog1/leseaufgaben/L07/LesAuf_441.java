import java.util.Scanner;
public class LesAuf_441 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int a = console.nextInt();
        int b = console.nextInt();
        int min = a<b? a : b; 
        System.out.println(min);
    }
}