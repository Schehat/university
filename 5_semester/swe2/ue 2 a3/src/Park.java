
public class Park {	
	private Boden boden;
	private Pflanze pflanze;
	private Umrandung umrandung;
	
	private ParkGeneratorFactory parkGeneratorFactory;
	private AbstractParkGenerator parkGenerator;
	
	public Park() {}
	
	public void init(String type) throws Exception {
		parkGenerator = parkGeneratorFactory.createParkGenerator(type);
		boden = parkGenerator.createBoden();
		pflanze = parkGenerator.createPflanze();
		umrandung = parkGenerator.createUmrandung();
	}
}
