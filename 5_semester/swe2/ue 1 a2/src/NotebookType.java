import java.util.ArrayList;

public class NotebookType {
	String name;
	ArrayList<ReplacementPartType> replacementPartTypes = new ArrayList<>();
	
	public NotebookType(String name) {
		this.name = name;
	}
	
	public boolean isAllowedToAddPart(ReplacementPartType replacementPartType) {
		return replacementPartTypes.contains(replacementPartType);
	}
	
	public void addPartType(ReplacementPartType replacementPartType) {
		replacementPartTypes.add(replacementPartType);
	}
	
	public void removePartType(ReplacementPartType replacementPartType) {
		replacementPartTypes.remove(replacementPartType);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<ReplacementPartType> getReplacementPartTypes() {
		return replacementPartTypes;
	}

	public void setReplacementPartTypes(ArrayList<ReplacementPartType> replacementPartTypes) {
		this.replacementPartTypes = replacementPartTypes;
	}
}
