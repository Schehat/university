
public class Geschlossen implements Zustand {
	
	@Override public Zustand schliessen() {
		System.out.println("Die T�r ist bereits geschlossen");
		return this;
	}
	
	@Override public Zustand oeffnen() {
		System.out.println("Die T�r wird ge�ffnet");
		return new Offen();
	}
	
	@Override public Zustand abschliessen() {
		System.out.println("Die T�r wird abgeschlossen");
		return new Abgeschlossen();
	}
	
	@Override public Zustand aufschliessen() {
		System.out.println("Die T�r ist abgeschlossen und kann "
				+ "deshalb nicht aufgeschlossen werden");
		return this;
	}
}
