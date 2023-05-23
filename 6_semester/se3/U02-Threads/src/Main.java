import BMI.Bmi;
import Callback.CallbackClient;
import Polling.PollingClient;

public class Main {
    public static void main(String[] args) {
        if(args.length == 1) {
            if (args[0].equals("0")) {
                System.out.println("Callback:");
                new CallbackClient();
            }
            if (args[0].equals("1")) {
                System.out.println("Polling:");
                new PollingClient();
            }
            if (args[0].equals("2")) {
                System.out.println("Futures:");
                new Bmi();
            }
        }else {
            System.out.println("Callback:");
            new CallbackClient();
            System.out.println("Polling:");
            new PollingClient();
            System.out.println("Futures:");
            new Bmi();
        }

    }
}