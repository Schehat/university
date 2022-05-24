package ue10_a1;

public class KonkreteStrategie19 extends Strategie{
	public int berechneSteuer(int warenwert) {
		return (int) (warenwert * 0.19);
	}
}
