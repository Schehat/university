
public class ReplacementPart {
	String name;
	ReplacementPartType replacementPartType;
	
	public ReplacementPart(String name, ReplacementPartType replacementPartType) {
		this.name = name;
		this.replacementPartType = replacementPartType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ReplacementPartType getType() {
		return replacementPartType;
	}

	public void setType(ReplacementPartType replacementPartType) {
		this.replacementPartType = replacementPartType;
	}
}
