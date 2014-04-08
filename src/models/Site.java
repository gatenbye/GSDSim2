import java.util.*;
import org.openstreetmap.gui.jmapviewer.*;

public class Site {

	private String name;
	private double[] location;
	private int timezone;
	private int workers;
	private List<Module> modules;

	public Site(String name, Coordinate location, int timezone, int workers) {
		this.name = name;
		this.location = new double[]{location.getLat(), location.getLon()};
		this.timezone = timezone;
		this.workers = workers;
		modules = new ArrayList<Module>();
	}

	public void addModule(Module module) {
		modules.add(module);
	}

	public String getName() {
		return name;
	}

	public Coordinate getLocation() {
		return new Coordinate(location[0], location[1]);
	}

	public int getTimezone() {
		return timezone;
	}

	public int getNumWorkers() {
		return workers;
	}

	public List<Module> getModules() {
		return modules;
	}

}
