
public class Main {

	public static void main(String[] args) {
		NotebookType thinkPadT490 = new NotebookType("ThinkPad T490");
		
		ReplacementPartType gpu = new ReplacementPartType("gpu");
		ReplacementPartType cpu = new ReplacementPartType("cpu");
		ReplacementPartType charger = new ReplacementPartType("charger");
		
		thinkPadT490.addPartType(gpu);
		
		Notebook n1 = new Notebook("n1", thinkPadT490);
		
		ReplacementPart r1 = new ReplacementPart("r1", gpu);
		ReplacementPart r2 = new ReplacementPart("r2", cpu);
		ReplacementPart r3 = new ReplacementPart("r3", charger);
		
		n1.addReplacementPart(r1);
		n1.addReplacementPart(r2);
		n1.addReplacementPart(r3);
	}
}
