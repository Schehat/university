package Util;

import java.util.ArrayList;

public class SE3_Util {

    public static int number = 500000000;
    public SE3_Util() {
    }

    public static ArrayList<Long> siebErastosthenes(long n) {
        try {
            if (n < 2) {
                throw new IllegalArgumentException("Die Zahl muss größer gleich 2 sein");
            }

            // bool Array isPrim sind alle Einträge true und werden später auf false gesetzt
            // kein prim
            boolean[] isPrim = new boolean[(int) (n + 1)];
            for (int i = 2; i <= n; i++) {
                isPrim[i] = true;
            }

            // Alle nicht Primzahlen markieren
            for (int i = 2; i * i <= n; i++) {
                if (isPrim[i]) {
                    // die Vielfachen von i werden auf false gesetzt
                    for (int j = i * i; j <= n; j += i) {
                        isPrim[j] = false;
                    }
                }
            }

            // Alle Primzahlen sammeln
            ArrayList<Long> res = new ArrayList<>();
            for (int i = 2; i <= n; i++) {
                if (isPrim[i]) {
                    res.add((long) i);
                }
            }

            return res;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        }
    }
}
