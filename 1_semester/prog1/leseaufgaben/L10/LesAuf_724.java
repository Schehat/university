import java.util.Scanner;
import java.util.Arrays;
public class LesAuf_724 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Geben Sie 2 Wörter an: ");
        String s1 = console.next();
        String s2 = console.next();
        System.out.println("Die beiden Wörter sind gleich?: " + areAnagrams(s1, s2));
    }

    public static String areAnagrams(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        char[] arrS1 = s1.toCharArray();
        char[] arrS2 = s2.toCharArray();
        Arrays.sort(arrS1);
        Arrays.sort(arrS2);
        if (arrS1.length != arrS2.length) {
            return "Nein";
        }
        for (int i = 0; i < arrS1.length; i++) {
            if (arrS1[i] != arrS2[i]) {
                return "Nein";
            }
        }
        return "Ja";
    }
}