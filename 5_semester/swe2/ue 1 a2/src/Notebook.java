import java.util.ArrayList;

public class Notebook {
	String name;
	ArrayList<ReplacementPart> replacementParts = new ArrayList<>();
	NotebookType type;
	
	public Notebook(String name, NotebookType type) {
		this.name = name;
		this.type = type;
	}
	
	public void addReplacementPart(ReplacementPart replacementPart) {
		if (this.getType().isAllowedToAddPart(replacementPart.getType())) {
			replacementParts.add(replacementPart);
			System.out.println("Replacement part was added successfully");
		} else {
			System.out.println("Replacement part can't be added");
		}
	}
	
	public void removeReplacementPart(ReplacementPart replacementPart) {
		this.replacementParts.remove(replacementPart);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<ReplacementPart> getReplacementPart() {
		return replacementParts;
	}

	public void setReplacementPart(ArrayList<ReplacementPart> replacementPart) {
		this.replacementParts = replacementPart;
	}

	public NotebookType getType() {
		return type;
	}

	public void setType(NotebookType type) {
		this.type = type;
	}
}
