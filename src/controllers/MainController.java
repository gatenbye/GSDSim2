import java.awt.event.*;
import javax.swing.*;

public class MainController {
	
	private TimeController timeController;
	private StartupController startupController;
	private MapController mapController;
	private ProcessController processController;	

	public MainController() {
		
		startupController = new StartupController(this);
	
	}

	public void setupMainFrame() {

		mapController = new MapController(this);
		processController = new ProcessController(this);
		timeController = new TimeController(this);

	}

	public MapController getMapController() {

		return mapController;

	}

	public StartupController getStartupController() {

		return startupController;

	}

	public TimeController getTimeController() {
		return timeController;
	}

	public ProcessController getProcessController() {
		return processController;
	}

}
