import org.openstreetmap.gui.jmapviewer.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MapController {

	private MapFrame mapFrame;
	private JMapViewer map;
	private final MainController mainController;
	private JLabel time;
	private JLabel money;
	private JButton pauseButton;
	private String timeString;

	public MapController(final MainController mainController) {

		this.mainController = mainController;
		map = new JMapViewer();
		time = new JLabel();
		money = new JLabel("Money: " + mainController.getStartupController().getPlayerMoney());
		pauseButton = new JButton();
		pauseButton.addActionListener (new ActionListener() {
      			public void actionPerformed(ActionEvent e) {
				if(mainController.getTimeController().getPaused() == false) {
					mainController.getTimeController().setPaused(true);
				} else {
					mainController.getTimeController().setPaused(false);
				}
			}
		});
		/*make left scrollable*/
		DefaultMapController mapController = new DefaultMapController(map);
		mapController.setMovementMouseButton(MouseEvent.BUTTON1);		
		for(Site site : mainController.getStartupController().getScenario().getSites()) {
			map.addMapMarker(new MapMarkerDot(site.getName(), site.getLocation()));
		}
		mapFrame = new MapFrame(map, time, money, pauseButton);

	}

	public JMapViewer getMap() {
		return map;
	}

	public void setTime(String timeString) {
		this.timeString = timeString;
		time.setText("Time: " + timeString);
	}

}
