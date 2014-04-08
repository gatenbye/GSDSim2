import org.openstreetmap.gui.jmapviewer.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomController {

	private JMapViewer map;
	private final StartupController startupController;
	private JButton okButton;
	private CustomFrame customFrame;
	private SiteDetailsController siteDetailsController;
	private CustomController thisP;
	private Point clickPosition;
	private java.util.List<Site> sites;

	public CustomController(final StartupController startupController) {
		this.startupController = startupController;
		map = new JMapViewer();
		sites = new ArrayList<Site>();
		thisP = this;
		/*make left scrollable*/
		DefaultMapController mapController = 	new DefaultMapController(map){
								@Override
								public void mouseClicked(MouseEvent e) {		
									siteDetailsController = new SiteDetailsController(thisP);
									clickPosition = e.getPoint();
								}
							};
		mapController.setMovementMouseButton(MouseEvent.BUTTON1);
		okButton = new JButton("Ok");
		okButton.addActionListener (new ActionListener() {
      			public void actionPerformed(ActionEvent e) {
				customFrame.dispose();
				new ModuleDetailsController(thisP);
     			}        
		});
		customFrame = new CustomFrame(map, okButton);

	}

	public void addSite(String name, int numWorkers, int timezone) {
		map.addMapMarker(new MapMarkerDot(name, map.getPosition(clickPosition)));
		sites.add(new Site(name, map.getPosition(clickPosition), numWorkers, timezone));
	}

	public void addModule(String siteName, String moduleName, int estimate, String devMethod) {
		for (Site site : sites) {
			if (site.getName().equals(siteName)) {
				site.addModule(new Module(moduleName, estimate, devMethod));
			}
		}
	}

	public java.util.List<Site> getSites() {
		return sites;
	}

	public StartupController getStartupController() {
		return startupController;
	}

}
