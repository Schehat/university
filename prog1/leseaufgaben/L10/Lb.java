import java.util.ArrayList;
public class Lb {
    public static void main(String[] args) {
        String s = "Monat/Tag/Jahr";
        String[] arrS = s.split("/");
        s = arrS[0];
        for (int i = 1; i < arrS.length; i++) {
            s = s + "." + arrS[i];
        }
    }
}

