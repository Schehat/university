package ue10_a1;

public class KonkreteStrategie7 extends Strategie{
	public int berechneSteuer(int warenwert) {
		return (int) (warenwert * 0.07);
	}
}
