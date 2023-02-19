
public class ParkGeneratorFactory {
	public AbstractParkGenerator createParkGenerator(String type) throws Exception {
		if (type.equals("Klosterpark")) {
			return new KlosterparkGenerator();
		} else if (type.equals("Stadtpark")) {
			return new StadtparkGenerator();
		}
		throw new Exception("no correct generator type given");
	}
}
