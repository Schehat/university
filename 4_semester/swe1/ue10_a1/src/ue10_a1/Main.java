package ue10_a1;

public class Main {
	public static void main(String[] args) {
		StrategieKontext strategieKontext = new StrategieKontext(); 
		strategieKontext.setStrategie(new KonkreteStrategie7());
		
		int laptopWarenwert = 500;
		int steuer = strategieKontext.berechneSteuer(laptopWarenwert);
		System.out.println(steuer);
		
		strategieKontext.setStrategie(new KonkreteStrategie19());
		steuer = strategieKontext.berechneSteuer(laptopWarenwert);
		System.out.println(steuer);
		
		strategieKontext.setStrategie(new KonkreteStrategie25());
		steuer = strategieKontext.berechneSteuer(laptopWarenwert);
		System.out.println(steuer);		
	}
}
