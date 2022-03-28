import java.io.*;
import java.util.Scanner;
public class Aufd {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("names.txt"));
        int count = 0;
        String name = "";
        while (scanner.hasNext()) {
            name = scanner.next();
            if (Character.toLowerCase(name.charAt(0)) == 'x') {
                count++;
            }
        }
        scanner.close();
        System.out.println("Anzahl Namen mit X: " + count);
    }
}