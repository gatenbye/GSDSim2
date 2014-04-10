import org.openstreetmap.gui.jmapviewer.*;
import org.openstreetmap.gui.jmapviewer.interfaces.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MapController {

	private MapFrame mapFrame;
	private JMapViewer map;
	private final MainController mainController;
	private JLabel time;
	private JLabel money;
	private JButton pauseButton;
	private String timeString;
	private int X;
	private int Y;
	private int centerX;
	private int centerY;
	private double radCircle;
	private Site clickedSite;
	private Coordinate markerCoord;
	private Point markerPoint;
	private MapController thisP;

	public MapController(final MainController mainController) {

		this.mainController = mainController;
		thisP = this;
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
		DefaultMapController mapController = new DefaultMapController(map){
								@Override
								public void mouseClicked(MouseEvent e) {		
									Point p = e.getPoint();
    									X = p.x+3;
    									Y = p.y+3;
    									java.util.List<MapMarker> ar = map.getMapMarkerList();
    									Iterator<MapMarker> i = ar.iterator();
    									while (i.hasNext()) {
										MapMarkerDot mapMarker = (MapMarkerDot) i.next();
										markerCoord = mapMarker.getCoordinate();
										markerPoint = map.getMapPosition(mapMarker.getLat(), mapMarker.getLon());
										
										centerX = markerPoint.x;
										centerY = markerPoint.y;
										radCircle = Math.sqrt( (((centerX-X)*(centerX-X)) + (centerY-Y)*(centerY-Y)));
										if (radCircle < 8){
											for(Site site : mainController.getStartupController().getScenario().getSites()) {
												if ((Double.compare(site.getLocation().getLat(), markerCoord.getLat()) == 0) && (Double.compare(site.getLocation().getLon(), markerCoord.getLon()) == 0)) {
													clickedSite = site;
													new InterventionController(thisP);
												}
											}
											
										}
									}
								}
							};;
		mapController.setMovementMouseButton(MouseEvent.BUTTON1);		
		for(Site site : mainController.getStartupController().getScenario().getSites()) {
			map.addMapMarker(new MapMarkerDot(site.getName(), site.getLocation()));
		}
		mapFrame = new MapFrame(map, time, money, pauseButton);

	}

	public MapFrame getMapFrame() {
		return mapFrame;
	}

	public void setTime(String timeString) {
		time.setText("Time: " + timeString);
	}

	public void setMoney(double money) {
		this.money.setText("Money: " + Double.valueOf(money).toString());
	}

	public int getCenterX() {
		return centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public Site getClickedSite() {
		return clickedSite;
	}
	
	public MainController getMainController() {
		return mainController;
	}

}
