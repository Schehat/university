public class Oeffnen implements Zustand {
    @Override
    public Zustand oeffnen() {
        System.out.println("Fenster ist bereits geöffnet");
        return this;
    }

    @Override
    public Zustand schließen() {
        System.out.println("Fenster wird geschlossen");
        return new Schließen();
    }
}
