import java.io.*;
import java.util.Scanner;
public class Auff {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Dateinamen angeben: ");
        String name = scanner.nextLine() + ".txt";
        PrintStream output = new PrintStream(new FileOutputStream(new File(name), true));
        System.out.print("Geben Sie Inhalt an: ");
        String text = scanner.nextLine();
        output.println(text);
        output.close();
        scanner.close();
    }
}
