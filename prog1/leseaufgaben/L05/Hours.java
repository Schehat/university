import java.util.*;
public class Hours {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int hours1 = processEmployee(console, 1);
        int hours2 = processEmployee(console, 2);
        int total = hours1 + hours2;
        System.out.println("Gesamtstunden fuer beide: " + total);
    }
    
    public static int processEmployee(Scanner console, int nummer) {
        System.out.print("Angestellter " + nummer + ":  Wie viele Tage? ");
        int days = console.nextInt();
        
        int totalHours = 0;
        for (int i = 1; i <= days; i++) {
            System.out.print("Stunden? ");
            int hours = console.nextInt();
            totalHours += Math.min(hours, 8);
        }
        
        System.out.println("Gesamtstunden fuer Angestellter " + nummer + ": " + totalHours);
        System.out.println();
        return totalHours;
    }
}