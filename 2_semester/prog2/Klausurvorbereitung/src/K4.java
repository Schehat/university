
public class K4 {

    public static void main(String[] args) {
        final Thread main = Thread.currentThread();
        final Thread t2 = new Thread(() -> {
            System.out.println("Zweiter Thread");
            try {
                main.join();
            } catch (InterruptedException e) {     
            }
        });
        t2.start();
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            
        }
        
        Thread t3 = new Thread() {
            @Override public void run() {
                System.out.println("Dritter Thread");
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    
                }
                System.out.println("Fertig");
            }
        };
        t3.start();
    }

}
