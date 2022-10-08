
public class Klimaanlage extends Sonderausstattung {
	public Klimaanlage(PKW pkw, double preis) {
		super(pkw, preis);
	}
	
	@Override public String toString() {
		return "Klimaanlage";
	}
}
