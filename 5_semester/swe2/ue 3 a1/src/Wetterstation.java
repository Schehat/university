
public class Wetterstation implements IWetterstation {
	double temperatur;
	
	public Wetterstation(double temperatur) {
		this.temperatur = temperatur;
	}
	
	public double getTemperatur() {
		return temperatur;
	}
}
