package ue09_a2;

public class Main {

	public static void main(String[] args) {
		Gericht zucker = new Zutat("Zucker", 100);
		Gericht cola = new Getraenke("Cola", 200);
		
		System.out.println(zucker.getKalorien());
		System.out.println(cola.getKalorien());
		
		Gericht t = new Teilgericht();
		t.addGericht(zucker);
		t.addGericht(cola);
		
		System.out.println(t.getKalorien());
		
		Gericht t2 = new Teilgericht();
		Gericht salat = new Zutat("Salat", 50);
		t2.addGericht(t);
		t2.addGericht(salat);
	
		System.out.println(t2.getKalorien());
	}
}
