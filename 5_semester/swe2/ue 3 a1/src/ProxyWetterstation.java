
public class ProxyWetterstation implements IWetterstation{
	Wetterstation wetterstation;
	
	public ProxyWetterstation(double temperatur) {
		wetterstation = new Wetterstation(temperatur);
	}
	
	public double getTemperatur() {
		return (wetterstation.getTemperatur() - 32) * 5.0/9;
	}
}
