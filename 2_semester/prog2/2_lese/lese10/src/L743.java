import java.util.Scanner;
public class L743 {
    private static Scanner console= new Scanner(System.in);
    public static long einlesen() {
        System.out.print("Ihre Zahl? ");
        return Long.parseLong(console.nextLine());
    }
    public static void warteAufAbbruch() {
        System.out.println("Zum Abbrechen <ENTER> ...");
        console.nextLine();

    }
    public static void rechne(long n) {
        try {
            System.out.println(isPrime(n));
        } catch(InterruptedException e) {
            System.out.println("erfolgreich abgebrochen");
        }
    }
    public static void main(String[] args) {
        final long n= einlesen();
        Thread t= new Thread() {
            @Override public void run() {
                rechne(n);
            }
        };
        t.start();
        warteAufAbbruch();
        if (t.isAlive()) {
            t.interrupt();
        }
    }
    public static boolean isPrime(long n) throws InterruptedException {
        return n>=2 && countFactors(n)==2;
    }
    public static int countFactors(long n) throws InterruptedException {
        int cnt= 2;
        for (long i=2; i<=n/2; i++) {
            if (Thread.currentThread().interrupted()) {
                throw new InterruptedException();
            }
            if (n % i == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
