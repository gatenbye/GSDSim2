import javax.swing.*;
import java.awt.*;
import org.openstreetmap.gui.jmapviewer.*;
import java.awt.event.*;

public class InterventionController {

	private InterventionFrame interventionFrame;
	private final MapController mapController;
	private Site site;	
	private JButton schedule;
	private JButton request;
	private JButton completed;
	private JButton conference;
	private JButton visit;
	private JButton okButton;

	public InterventionController(final MapController mapController) {

		this.mapController = mapController;
		site = mapController.getClickedSite();
		okButton = new JButton("Ok");
		okButton.addActionListener (new ActionListener() {
      			public void actionPerformed(ActionEvent e) {
				interventionFrame.dispose();
     			}        
		});
		schedule = new JButton("Send email");
		schedule.addActionListener (new ActionListener() {
      			public void actionPerformed(ActionEvent e) {
				mapController.getMainController().getProcessController().addMeeting(site, 0.1);
			}
		});
		request = new JButton("Send email");
		request.addActionListener (new ActionListener() {
      			public void actionPerformed(ActionEvent e) {
				mapController.getMainController().getProcessController().addMeeting(site, 0.5);
			}
		});
		completed = new JButton("Send email");
		completed.addActionListener (new ActionListener() {
      			public void actionPerformed(ActionEvent e) {
				mapController.getMainController().getProcessController().addMeeting(site, 1);
			}
		});
		conference = new JButton("Start conference");
		conference.addActionListener (new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
				mapController.getMainController().getProcessController().addMeeting(site, 2);
			}
		});
		visit = new JButton("Visit site");
		visit.addActionListener (new ActionListener() {
      			public void actionPerformed(ActionEvent e) {
				mapController.getMainController().getProcessController().addMeeting(site, 7);
			}
		});
		interventionFrame = new InterventionFrame(okButton, mapController.getCenterX(), mapController.getCenterY(), site, schedule, request, completed, conference, visit);

	}

}
