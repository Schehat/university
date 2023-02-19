
public class App {

	public static void main(String[] args) {
		IWetterstation wetterstation = new ProxyWetterstation(10);
		System.out.println("Wetterstation: " + wetterstation.getTemperatur());
	}

}
