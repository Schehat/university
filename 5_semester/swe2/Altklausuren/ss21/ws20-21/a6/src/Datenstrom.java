public class Datenstrom {
    private Zustand zustand = new Close();

    public void close() {
        setZustand(zustand.close());
    }

    public void open() {
        setZustand(zustand.open());
    }

    public void setZustand(Zustand zustand) {
        this.zustand = zustand;
    }
}
