import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SiteDetailsController {

	private JTextArea siteNameTA;
	private JTextArea numWorkersTA;
	private JTextArea timezoneTA;
	private JButton okButton;
	private SiteDetailsFrame siteDetailsFrame;
	private final CustomController customController;

	public SiteDetailsController(final CustomController customController) {
		
		this.customController = customController;
		siteNameTA = new JTextArea();
		numWorkersTA = new JTextArea();
		timezoneTA = new JTextArea();
		okButton = new JButton();
		okButton.addActionListener (new ActionListener() {
      			public void actionPerformed(ActionEvent e) {
				siteDetailsFrame.dispose();
				customController.addSite(siteNameTA.getText(), Integer.parseInt(numWorkersTA.getText()), Integer.parseInt(timezoneTA.getText()));
     			}        
		});
		siteDetailsFrame = new SiteDetailsFrame(siteNameTA, numWorkersTA, timezoneTA, okButton);

	}

}
