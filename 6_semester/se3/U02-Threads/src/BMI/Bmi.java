package BMI;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Bmi extends Thread {

    private boolean stop = false;
    private int increment = 0;
    private double gewicht = 92;
    private double größe = 1.96;

    public Bmi() {
        this.start();
    }

    public void run() {
        //als Lambda-Ausdruck um leere Klassen zu sparen.
        //Berechnung des Bmi.
        CompletableFuture<Double> futureCalcBmi = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 * (int) ((Math.random() * (10 - 3)) + 3));
                System.out.println("Bmi berechnet...");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return (Double) gewicht / (größe * größe);
        });

        //thenApply als Callback-Verfahren genutzt.
        //Einstufung des Bmi in unter-/ normal-/ übergewichtig.
        CompletableFuture<String> futureCategorize = futureCalcBmi.thenApply(bmi -> {
            try {
                Thread.sleep(1000 * (int) ((Math.random() * (10 - 3)) + 3));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            String result;
            if (bmi < 18.5) {
                result = "untergewichtig";
            } else if (bmi > 25) {
                result = "übergewichtig";
            } else {
                result = "normalgewichtig";
            }

            System.out.println("Bmi kategorisiert...");
            stop = true;
            return result;
        });

        //Inkremente des Clients auf die Console schreiben.
        while (!stop) {
            try {
                Thread.sleep(1000);
                System.out.println(++increment);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        //Blocking polling des letzten futures für die Endausgabe.
        try {
            System.out.println("Die Person " + gewicht + "kg, " + größe + "m hat " + futureCategorize.get() + ".");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }


}

