import java.util.ArrayList;

public class Zahlentheorie {
    public ArrayList<Long> primZerlegung(long n) {
        try {
            if (n < 2)
                throw new IllegalArgumentException("Die Zahl muss größer gleich 2 sein");

            final long sqrtN = (long) Math.floor(Math.sqrt(n));
            ArrayList<Long> res = new ArrayList<>();

            // Wegen dem Sieb des Erastosthenes müssen wir nur bis sqrt(n) iterieren
            for (long i = 2; i <= sqrtN; i++) {
                while (n % i == 0) {
                    n = n / i;
                    res.add(i);
                }
            }
            return res;
        } catch(IllegalArgumentException e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        }
    }

    public ArrayList<Long> siebErastosthenes(long n) {
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
        } catch(IllegalArgumentException e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        }
    }



    public ArrayList<Long> ggT(long a, long b ) {
        try {
            if (a < 1 || b < 1) {
                throw new IllegalArgumentException("Die Zahlen müssen größer gleich 1 sein");
            }

            ArrayList<Long> res = new ArrayList<>();

            // Initialisierung
            long r0 = a;
            long r1 = b;
            long x0 = 1;
            long x1 = 0;
            long y0 = 0;
            long y1 = 1;

            /*
                - ro: ggT
                - x0: x
                - yo: y
                - Abbruchbedingung: r1 bzw. rn wenn der gleich 0 ist, dann ist der
                  der euklidische Algorithmus durch
             */
            while (r1 != 0) {
                // euklidische Algorithmus
                long q = r0 / r1;
                long r2 = r0 % r1;

                // zusätzlich der Erweiterung mti der Rekursion
                long x2 = x0 - q * x1;
                long y2 = y0 - q * y1;

                // update
                r0 = r1;
                r1 = r2;
                x0 = x1;
                x1 = x2;
                y0 = y1;
                y1 = y2;
            }

            res.add(r0);
            res.add(x0);
            res.add(y0);

            return res;
        } catch(IllegalArgumentException e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        }
    }

    // Formel: c = xa + yb und Bedingung ggT(a, b) | c
    public ArrayList<Long> diophant(long a, long b, long c) {
        try {
            if (a == 0 && b == 0) {
                if (c == 0)
                    throw new IllegalArgumentException("Es gibt unendlich viele Lösungen");
                else
                    throw new IllegalArgumentException("Es gibt keine Lösungen");
            }

            ArrayList<Long> ggt = ggT(Math.abs(a), Math.abs(b));

            // Bedingung ggT(a, b) | c nicht erfüllt
            if (c % ggt.get(0) != 0)
                throw new IllegalArgumentException("Es gibt keine ganzzahligen Lösungen");

            ArrayList<Long> res = new ArrayList<>();
            res.add(ggt.get(1));
            res.add(ggt.get(2));

            return res;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        }
    }
}
