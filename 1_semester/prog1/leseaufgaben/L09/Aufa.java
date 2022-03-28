import java.util.Scanner;
public class Aufa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int input = 0;
        
        while (true) {
            System.out.print("Bitte Zahl eingeben (verlasse mit -1): ");
            input = scanner.nextInt();
            if (input == -1) {
                break;
            }
            if (input % 5 == 0) {
                sum += input;
            }
        }
        System.out.println("Summe: " + sum);
    }
}   