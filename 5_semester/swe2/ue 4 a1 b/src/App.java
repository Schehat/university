
public class App {

	public static void main(String[] args) {
		Buch normalBuch = new NormalBuch();
		Buch vorgemerktesBuch = new VermerktesBuch();
		Buch praesenzBuch = new PraesenzBuch();
		System.out.println("Normales Buch: " + normalBuch.leiheAus());
		System.out.println("Vorgemerktes Buch: " + vorgemerktesBuch.leiheAus());
		System.out.println("Präsenz Buch: " + praesenzBuch.leiheAus());
	}

}
