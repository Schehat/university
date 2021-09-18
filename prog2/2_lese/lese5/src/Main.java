
public class Main {

    public static void main(String[] args) {
        //a)
        B b = new B(3);
        System.out.println(b.getX());
        
        //b)
        MeinProdukt m = new MeinProdukt();
        m.setPreis(5);
        m.setPreis(10);
        m.setPreis(15);
        
        System.out.println(m.getAnzahlPreiserhoehungen());
        
        //c) => throws
        Produkt p= new Produkt(0.0);
        System.out.println(p.getPreis());
        p.setPreis(0.0);
    }

}
