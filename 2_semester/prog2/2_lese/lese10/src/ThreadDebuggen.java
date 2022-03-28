
public class ThreadDebuggen {
    public static Zaehler z = new Zaehler(); // startet bei 0

    public static void main(String[] args) {
        Thread.currentThread().setName("Hauptthread");
        Thread t2= new Thread(new Runnable() {
            @Override public void run() {
                for (int i=0; i<1000; i++) {
                    System.out.print('0');
                }
            }
        }, "Zweiter Thread");
        t2.start();
        for (int i=0; i<1000; i++) {
            System.out.print('#');
        }
    }
    public static void print(char c) {
        System.out.print(c);
        z.incr();
        if (z.get() % 100 == 0) System.out.println();
    }
}

class Zaehler {
    private long wert;
    public void incr() {
        wert++;
    }
    public long get() {
        return wert;
    }
}
