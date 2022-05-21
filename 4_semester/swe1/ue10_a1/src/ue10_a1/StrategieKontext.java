package ue10_a1;

public class StrategieKontext {
	Strategie strategie;
	
	public void setStrategie(Strategie strategie) {
		this.strategie = strategie;
	}
	
	public int berechneSteuer(int warenwert) {
		return strategie.berechneSteuer(warenwert);
	}
}
