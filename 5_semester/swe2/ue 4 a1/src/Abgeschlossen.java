
public class Abgeschlossen implements Zustand {
	
	@Override public Zustand schliessen() {
		System.out.println("Die T�r ist abgeschlossen und kann "
				+ "deshalb nicht geschlossen werden");
		return this;
	}
	
	@Override public Zustand oeffnen() {
		System.out.println("Die T�r ist abgeschlossen und kann deshalb "
				+ "nicht ge�ffnet werden");
		return this;
	}
	
	@Override public Zustand abschliessen() {
		System.out.println("Die T�r ist bereits abgeschlossen");
		return this;
	}
	
	@Override public Zustand aufschliessen() {
		System.out.println("Die T�r wird aufgeschlossen");
		return new Geschlossen();
	}
}
