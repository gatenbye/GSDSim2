public class Module {

	private String name;
	private double estimate;
	private String developmentMethod;

	public Module(String name, double estimate, String developmentMethod) {
		this.name = name;
		this.estimate = estimate;
		this.developmentMethod = developmentMethod;
	}

	public String getName() {
		return name;
	}

	public double getEstimate() {
		return estimate;
	}

	public String getDevelopmentMethod() {
		return developmentMethod;
	}
}
