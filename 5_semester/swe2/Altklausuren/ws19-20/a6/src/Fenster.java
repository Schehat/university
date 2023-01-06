public class Fenster {
    Zustand zustand = new Schließen();

    public void oeffnen() {
        setZustand(zustand.oeffnen());
    }

    public void schließen() {
        setZustand(zustand.schließen());
    }

    public void setZustand(Zustand zustand) {
        this.zustand = zustand;
    }
}
