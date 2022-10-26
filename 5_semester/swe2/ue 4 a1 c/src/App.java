
public class App {

	public static void main(String[] args) {
		Buch buch = new Buch();
		
		buch.setStratLeiheAus(new NormalLeiheAus());
		System.out.println("Normale Ausleihe: " + buch.leiheAus());
		
		buch.setStratLeiheAus(new VorgemerktLeiheAus());
		System.out.println("Vorgemerkte Ausleihe: " + buch.leiheAus());
		
		buch.setStratLeiheAus(new PraesenzLeiheAus());
		System.out.println("Präsenz Ausleihe: " + buch.leiheAus());
	}
}
