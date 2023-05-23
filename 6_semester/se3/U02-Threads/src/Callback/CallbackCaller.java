package Callback;
import Util.SE3_Util;

import java.util.ArrayList;

public class CallbackCaller extends Thread {
    CallbackClient client;

    public CallbackCaller(CallbackClient client) {
        this.client = client;
        // ruft intern run() auf, der einen neuen Thread erzeugt
        this.start();
    }

    public void run() {
        // "teure" Operation
        ArrayList<Long> primZahlen = SE3_Util.siebErastosthenes(SE3_Util.number);

        // Aufgabe erledigt. Das Ergebnis dem Client übergeben
        client.callback("Anzahl der Primzahlen bis " + SE3_Util.number + ": " + primZahlen.size());
    }
}
