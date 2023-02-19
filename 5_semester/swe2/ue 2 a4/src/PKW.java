
public abstract class PKW {
	double preis;
	
	public PKW(double preis) {
		this.preis = preis;
	}
	
	public double getPreis() {
		return preis;
	}
	
	public String getBeschreibung() {
		return "Bestellets Fahrzeug: Ein Fahrzeug des Modell " + this;
	}
}
