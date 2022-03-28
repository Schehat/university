import java.util.Scanner;
public class LesAuf_452 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bitte Jahre eingeben: ");
        int jahre = scanner.nextInt();
        System.out.println("Das sind " + alterInMonaten(jahre) + " Monate");
    }
    
    public static int alterInMonaten(int jahre) {
        if (jahre < 0) {
            throw new IllegalArgumentException("Jahre muss >= 0 sein");
        }
        else if (jahre > 100) {
            throw new IllegalArgumentException("Jahre muss < 100 sein");
        }
        return jahre*12;
    }
}