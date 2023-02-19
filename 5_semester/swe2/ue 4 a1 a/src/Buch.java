
public class Buch {
	private enum BUCHTYP {normal, vorgemerkt, Präsenz};
	private BUCHTYP buchtyp = BUCHTYP.normal;
	
	public int leiheAus() throws Exception {
		if (buchtyp == BUCHTYP.normal) {
			return 28;
		} else if (buchtyp == BUCHTYP.vorgemerkt) {
			return 14;
		} else if (buchtyp == BUCHTYP.Präsenz) {
			return 1;
		}
		throw new Exception("Buchtyp unbekannt");
	}
}
