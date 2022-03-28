
public class MeinProdukt extends Produkt {
    private int count = 0;
    
    public MeinProdukt() {
        super();
    }
    
    @Override public void setPreis(double preis) {
        super.setPreis(preis);
        count++;
    }
    
    public int getAnzahlPreiserhoehungen() {
        return count;
    }
}
