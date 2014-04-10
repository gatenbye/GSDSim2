import javax.swing.*;
import java.awt.*;
import org.openstreetmap.gui.jmapviewer.*;

public class InterventionFrame extends JFrame {

	Toolkit t;
	Dimension d;
	JPanel mainPanel;
	JPanel mainPanelCentered;
	JPanel okPanel;

	public InterventionFrame(JButton okButton, int locationx, int locationy, Site clickedSite, JButton schedule, JButton request, JButton completed, JButton conference, JButton visit) {

		t = Toolkit.getDefaultToolkit();
		d = t.getScreenSize();
		setSize(d.width / 2, d.height / 2);
		setLocation(locationx, locationy);
		setLayout(new BorderLayout());
		mainPanelCentered = new JPanel(new GridBagLayout());
		mainPanel = new JPanel(new SpringLayout());
		mainPanel.add(new JLabel("Site: " + clickedSite.getName()));
		mainPanel.add(new JLabel());
		mainPanel.add(new JLabel("Ask are you on schedule (Cost: 0 dev-days)", JLabel.TRAILING));
		mainPanel.add(schedule);
		mainPanel.add(new JLabel("Request status of module (Cost: .1 dev-days)", JLabel.TRAILING));
		mainPanel.add(request);
		mainPanel.add(new JLabel("Request completed tasks list (Cost: .5 dev-days)", JLabel.TRAILING));
		mainPanel.add(completed);
		mainPanel.add(new JLabel("Hold video conference (Cost: 2.0 dev-days)", JLabel.TRAILING));
		mainPanel.add(conference);
		mainPanel.add(new JLabel("Visit site (Cost: 7.0 dev-days)", JLabel.TRAILING));
		mainPanel.add(visit);
		SpringUtilities.makeCompactGrid(mainPanel, 6, 2, 6, 6, 6, 6);
		setVisible(true);
		okPanel = new JPanel();
		okPanel.setLayout(new BorderLayout());
		okPanel.add(okButton, BorderLayout.EAST);
		mainPanelCentered.add(mainPanel);
		add(mainPanelCentered, BorderLayout.CENTER);
		add(okPanel, BorderLayout.SOUTH);

	}

}
