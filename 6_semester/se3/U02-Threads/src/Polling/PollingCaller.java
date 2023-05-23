package Polling;
import Util.SE3_Util;

import java.util.ArrayList;

public class PollingCaller extends Thread {
    ArrayList<Long> primZahlen;
    boolean done = false;

    public PollingCaller() {
        this.start();
    }

    public void run() {
        primZahlen = SE3_Util.siebErastosthenes(SE3_Util.number);
        done = true;
    }

    public boolean isDone() {
        return done;
    }

    public String request() {
        String result = "Anzahl der Primzahlen bis " + SE3_Util.number + ": " + primZahlen.size();
        return result;
    }
}
