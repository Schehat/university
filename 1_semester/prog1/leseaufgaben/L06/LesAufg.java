import java.util.Scanner;
public class LesAufg {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Bitte geben Sie ein Monat an: ");
        String monat = console.next();
        monat = monat.toLowerCase();
        switch (monat) {
        case "januar":
            System.out.println(monat + " besitzt 31 Tage");
            break;
        case "februar":
            System.out.println(monat + " besitzt 28 Tage");
            break;
        case "märz":
            System.out.println(monat + " besitzt 31 Tage");
            break;
        case "april":
            System.out.println(monat + " besitzt 30 Tage");
            break;
        case "Mai":
            System.out.println(monat + " besitzt 31 Tage");
            break;
        case "juni":
            System.out.println(monat + " besitzt 3 Tage");
            break;
        case "juli":
            System.out.println(monat + " besitzt 31 Tage");
            break;
        case "august":
            System.out.println(monat + " besitzt 31 Tage");
            break;
        case "september":
            System.out.println(monat + " besitzt 30 Tage");
            break;
        case "oktober":
            System.out.println(monat + " besitzt 31 Tage");
            break;
        case "november":
            System.out.println(monat + " besitzt 30 Tage");
            break;
        case "dezember":
            System.out.println(monat + " besitzt 31 Tage");
            break;
        }
    }
}