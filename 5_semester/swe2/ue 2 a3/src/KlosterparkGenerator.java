
public class KlosterparkGenerator implements AbstractParkGenerator {
	@Override public Boden createBoden() {
		return new Steinplatte();
	}
	
	@Override public Pflanze createPflanze() {
		return new Kraut();
	}
	
	@Override public Umrandung createUmrandung() {
		return new Steinmauer();
	}
}
