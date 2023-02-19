
public class Buch {
	private enum BUCHTYP {normal, vorgemerkt, Pr�senz};
	private BUCHTYP buchtyp = BUCHTYP.normal;
	
	public int leiheAus() throws Exception {
		if (buchtyp == BUCHTYP.normal) {
			return 28;
		} else if (buchtyp == BUCHTYP.vorgemerkt) {
			return 14;
		} else if (buchtyp == BUCHTYP.Pr�senz) {
			return 1;
		}
		throw new Exception("Buchtyp unbekannt");
	}
}
