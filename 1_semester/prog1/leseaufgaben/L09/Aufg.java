import java.io.*;
import java.util.Scanner;
public class Aufg {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Scanner input = null;
        String name = null;
        do {
            System.out.print("Geben Sie einen Dateinamen an: ");
            name = console.nextLine() + ".txt";
            try {
                input = new Scanner(new File(name));
            } catch (FileNotFoundException e) {
                System.out.println("Diesen Dateinamen gibt es nicht");
            }
        } while(input == null);
        int number1 = 0; 
        int number2 = 0;
        int ergebnis = 0;
        while (input.hasNextLine()) {
            number1 = input.nextInt();
            number2 = input.nextInt();
            try {
                ergebnis = number1 / number2;
                System.out.println(number1 + " / " + number2 + " = " + ergebnis);
            } catch (ArithmeticException e) {
                System.out.println(number1 + " / " + number2 + ": Unerlaubte Division duch 0!");
            }
        }
        input.close();
        console.close();
    }
}