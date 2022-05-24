public class Lc {
    public static int pos = 0;
    public static void rumpf() {
        for (int i=0; i<50; i++) {
            pos++;
            if (pos == 10) { pos= 0; System.out.println(i + " " + Thread.currentThread().getName()); }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t2 = new Thread(new Runnable() {
            @Override public void run() { rumpf(); }
        }, "t2");
        rumpf();
        t2.start();
        t2.join();
        System.out.println(pos);
    }
}