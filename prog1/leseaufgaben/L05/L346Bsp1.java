import java.util.*;
public class L346Bsp1   {
    public static void main(String[] args)  {
        Scanner console = new Scanner(System.in);
        System.out.print("Wie ist Ihr Vorname? ");
        String name = console.next();
        System.out.print("Wie alt sind Sie? ");
        int alter = console.nextInt();
        System.out.print(name + " ist " + alter);
    }
}