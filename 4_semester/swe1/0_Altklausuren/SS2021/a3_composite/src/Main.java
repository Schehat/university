public class Main {
    public static void main(String[] args) {
        Kapitel t = new Text(0);
        Bild b1 = new Bild(1);
        Bild b2 = new Bild(2);

        Kapitel composite = new Composite();
        composite.add(t);
        composite.add(b1);
        composite.add(b2);
        System.out.println(composite.anzahlBilder());
    }
}