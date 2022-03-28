
public class ThreadPausieren {
    public static Zaehler z = new Zaehler(); // startet bei 0
    
    public static void main(String[] args) {
        Thread.currentThread().setName("Hauptthread");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    print('0');
                    if (Thread.interrupted()) break;
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        break; // wie einen normalen Abbruch behandeln
                    }
                }
            }
        }, "Zweiter Thread");
        t2.start();
        for (int i = 0; i < 1000; i++) {
            print('#');
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // sollte nicht vorkommen, da den Hauptthread ja niemand abbricht.
            }
            if (i == 99) t2.interrupt();
        }
    }
    
    public static void print(char c) {
        System.out.print(c);
        z.incr();
        if (z.get() % 100 == 0) System.out.println();
    }
}