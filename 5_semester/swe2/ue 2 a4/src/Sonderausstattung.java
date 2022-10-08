
public abstract class Sonderausstattung extends PKW {
	private PKW pkw;
	
	public Sonderausstattung(PKW pkw, double preis) {
		super(preis);
		this.pkw = pkw;
	}
	
	@Override public double getPreis() {
		return pkw.getPreis() + preis;
	}
	
	@Override public String getBeschreibung() {
		return pkw.getBeschreibung() + " und eine " + this;
	}
}
