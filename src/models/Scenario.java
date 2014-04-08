import java.util.*;

public class Scenario {

	private String name;
	private List<Site> sites;

	public Scenario (String name, List<Site> sites) {
		this.name = name;
		this.sites = sites;
	}

	public List<Site> getSites() {
		return sites;
	}

	public String getName() {
		return name;
	}

}
