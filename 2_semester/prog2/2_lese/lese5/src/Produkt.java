public class Produkt {
    private double preis;
    boolean init = false;
    
    public Produkt(double preis) {
        setPreis(preis);
    }
    
    public Produkt() {
        
    }
    
    public void setPreis(double preis) { 
        if (preis <= this.preis && init) { 
            throw new IllegalArgumentException("Nur Erhöhungen erlaubt!"); 
        }
        this.preis= preis;
        init = true;
    }
    
    public double getPreis() { 
        return preis; 
    }
}