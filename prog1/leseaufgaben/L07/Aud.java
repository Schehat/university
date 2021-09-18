import java.util.Scanner;
public class Aud {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ihr neues Passwort: ");
        String password = scanner.next();
        int n = 1;
        while (password.length() <= 8) {
            System.out.print("Bitte ein längeres Passwort eingeben (mind. 8 Zeichen)");
            n++;
            
            System.out.print("Ihr neues Passwort: ");
            password = scanner.next();
        }
        System.out.println("Sie haben " + n + " Versuche gebraucht");
        boolean a = 13 != 12 ^ 12 != 11;
        System.out.println(a);
    }
}