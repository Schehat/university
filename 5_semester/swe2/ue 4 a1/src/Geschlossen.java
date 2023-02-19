
public class Geschlossen implements Zustand {
	
	@Override public Zustand schliessen() {
		System.out.println("Die Tür ist bereits geschlossen");
		return this;
	}
	
	@Override public Zustand oeffnen() {
		System.out.println("Die Tür wird geöffnet");
		return new Offen();
	}
	
	@Override public Zustand abschliessen() {
		System.out.println("Die Tür wird abgeschlossen");
		return new Abgeschlossen();
	}
	
	@Override public Zustand aufschliessen() {
		System.out.println("Die Tür ist abgeschlossen und kann "
				+ "deshalb nicht aufgeschlossen werden");
		return this;
	}
}
