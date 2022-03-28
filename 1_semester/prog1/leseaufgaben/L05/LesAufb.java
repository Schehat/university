import java.util.*;
public class LesAufb {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Bitte geben Sie ein Wort ein: ");
        String wort = console.next();
        System.out.print("Bitte geben Sie einen Index des Wortes ein: ");
        int i = console.nextInt();
        System.out.print("Der Index " + i + " des Wortes " + wort + " ist: " + wort.charAt(i));
    }
}