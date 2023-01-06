public class Schließen implements Zustand {
    @Override
    public Zustand oeffnen() {
        System.out.println("Fenster wird geöffnet");
        return new Oeffnen();
    }

    @Override
    public Zustand schließen() {
        System.out.println("Fenster ist bereits geschlossen");
        return this;
    }
}
