
public class App {

	public static void main(String[] args) {
		Tuer tuer = new Tuer();  // initial state is geschlossen
		tuer.schliessen();
		tuer.aufschliessen();
		tuer.abschliessen();
		tuer.aufschliessen();
	}
}
