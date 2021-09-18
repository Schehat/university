import java.util.*;
public class A4 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("bitte eine Zahl eingeben: ");
        double d = console.nextDouble();
        String num = Double.toString(d);
        String[] spl = num.split("\\.");
        String pre = "";
        String post = "";
        if (spl[0].length() > 4) {
            pre = spl[0].substring(spl[0].length() - 4); 
        } else {
            pre = "0000".substring(0, 4-spl[0].length());
        }      
        if (spl[1].length() > 2 ) {
            post = spl[1].substring(0, 2);
        } else {
            post = "00".substring(0, 2-spl[1].length());
        }
        num = pre + "." + post;
        System.out.println(num);
    }
}