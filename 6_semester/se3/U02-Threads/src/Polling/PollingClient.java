package Polling;

public class PollingClient extends Thread {

    private int increment = 0;
    private int maxTime = 3;
    private int minTime = 1;
    PollingCaller caller;

    public PollingClient() {
        caller = new PollingCaller();

        while (!caller.isDone()) {
            try {
                Thread.sleep(1000 * (int) ((Math.random() * (maxTime - minTime)) + minTime));
                System.out.println(++increment);
            } catch (InterruptedException e) {
                System.out.println(e.getStackTrace());
            }
        }
        System.out.println(caller.request());
    }
}
