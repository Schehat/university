public class Open implements Zustand {
    @Override
    public Zustand open() {
        System.out.println("Error. Datenstrom bereits geöffnet");
        return this;
    }

    @Override
    public Zustand close() {
        System.out.println("Datenstrom wird geschlossen");
        return new Close();
    }
}
