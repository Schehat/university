import java.util.Comparator;

public abstract class AnteilAnlage implements Comparable<AnteilAnlage>, Comparator<AnteilAnlage> {
    private String isin;
    private double gesamtKosten;

    public AnteilAnlage(String isin) {
        this.isin= isin;
        gesamtKosten= 0.0;
    }

    @Override public int compareTo(AnteilAnlage other) {
        return this.getIsin().compareTo(other.getIsin());
    }

    public void addiereKosten(double kosten) {
        gesamtKosten += kosten;
    }
    public String getIsin() {
        return isin;
    }
    public double getGesamtKosten() {
        return gesamtKosten;
    }
    public double getGewinn(double aktuellerKurs) {
        return getMarktwert(aktuellerKurs) - getGesamtKosten();
    }
    public abstract double getMarktwert(double aktuellerKurs);
}
