package Callback;

public class CallbackClient extends Thread {
    private int increment = 0;
    private int maxTime = 3;
    private int minTime = 1;
    private boolean stop = false;

    public CallbackClient() {
        new CallbackCaller(this);

        // Laufe solange bis Caller sich meldet
        while(!stop) {
            try {
                Thread.sleep(1000 * (int) ((Math.random() * (maxTime - minTime)) + minTime));
                System.out.println(++increment);
            } catch (InterruptedException e) {
                System.out.println(e.getStackTrace());
            }
        }
    }

    public void callback(String result) {
        System.out.println(result);
        stop = true;
    }
}
