public abstract class Kapitel {
    public int anzahlBilder;

    public Kapitel(int anzahlBilder) {
        this.anzahlBilder = anzahlBilder;
    }

    abstract public int anzahlBilder();

    public void add(Kapitel k) {
    }

    public void remove(Kapitel k) {
    }
}
