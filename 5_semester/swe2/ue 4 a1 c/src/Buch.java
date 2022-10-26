
public class Buch {
	StratLeiheAus stratLeiheAus;
	
	public void setStratLeiheAus(StratLeiheAus stratLeiheAus) {
		this.stratLeiheAus = stratLeiheAus;
		
	}
	
	public int leiheAus() {
		return stratLeiheAus.leiheAus();
	}
	
	// some business logic...
	
}
