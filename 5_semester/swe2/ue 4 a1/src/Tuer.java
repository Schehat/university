
public class Tuer {
	Zustand zustand;
	
	public Tuer() {
		setZustand(new Geschlossen());
	}
	
	public void setZustand(Zustand zustand) {
		this.zustand = zustand;
	}
	
	public void schliessen() {
		setZustand(zustand.schliessen());
	}
	
	public void oeffnen() {
		setZustand(zustand.oeffnen());
	}
	
	public void abschliessen() {
		setZustand(zustand.abschliessen());
	}
	
	public void aufschliessen() {
		setZustand(zustand.aufschliessen());
	}
}
