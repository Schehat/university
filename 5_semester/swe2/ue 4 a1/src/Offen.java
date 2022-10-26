
public class Offen implements Zustand {
	
	@Override public Zustand schliessen() {
		System.out.println("Die Tür wird geschlossen");
		return new Geschlossen();
	}
	
	@Override public Zustand oeffnen() {
		System.out.println("Die Tür ist bereits geöffnet");
		return this;
	}
	
	@Override public Zustand abschliessen() {
		System.out.println("Die Tür ist geöffnet und kann "
				+ "deshalb nicht abgeschlossen werden");
		return this;
	}
	
	@Override public Zustand aufschliessen() {
		System.out.println("Die Tür ist geöffnet und kann "
				+ "deshalb nicht aufgeschlossen werden");
		return this;
	}
}
