public class Module {

	private String name;
	private int estimate;
	private String developmentMethod;

	public Module(String name, int estimate, String developmentMethod) {
		this.name = name;
		this.estimate = estimate;
		this.developmentMethod = developmentMethod;
	}

	public String getName() {
		return name;
	}

	public int getEstimate() {
		return estimate;
	}

	public String getDevelopmentMethod() {
		return developmentMethod;
	}
}
