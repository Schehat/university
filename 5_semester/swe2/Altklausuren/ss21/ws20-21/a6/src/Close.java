public class Close implements Zustand {
    public Zustand open() {
        System.out.println("Datenstrom wird geöffnet");
        return new Open();
    }

    @Override
    public Zustand close() {
        System.out.println("Error. Datenstrom bereits geschlossen");
        return this;
    }
}
