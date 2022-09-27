import java.util.ArrayList;

public class Composite extends Kapitel {
    private ArrayList<Kapitel> kapiteln = new ArrayList<>();

    public Composite() {
        super(0); // dummy wert
    }

    public void add(Kapitel k) {
        kapiteln.add(k);
    }

    public void remove(Kapitel k) {
        kapiteln.remove(k);
    }

    public int anzahlBilder() {
        int anzahlBilder = 0;
        for (Kapitel k : kapiteln) {
            anzahlBilder += k.anzahlBilder;
        }
        return anzahlBilder;
    }
}
