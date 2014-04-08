import org.openstreetmap.gui.jmapviewer.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.Spring;
import java.awt.*;

public class SiteDetailsFrame extends JFrame {

	private Toolkit t;
	private Dimension d;
	private JPanel okPanel;
	private JPanel taPanel;

	public SiteDetailsFrame(JTextArea siteNameTA, JTextArea numWorkersTA, JTextArea timezoneTA, JButton okButton) {
		
		t = Toolkit.getDefaultToolkit();
		d = t.getScreenSize();
		setLayout(new BorderLayout());
		setSize(d.width / 2, d.height / 2);
		setLocation((d.width - (d.width / 2)) / 2, (d.height - (d.height / 2)) / 2);
		okButton.setText("Ok");
		taPanel = new JPanel(new SpringLayout());
		taPanel.add(new JLabel("Site name: ", JLabel.TRAILING));
		taPanel.add(siteNameTA);
		taPanel.add(new JLabel("Number of workers: ", JLabel.TRAILING));
		taPanel.add(numWorkersTA);
		taPanel.add(new JLabel("Timezone difference: ", JLabel.TRAILING));
		taPanel.add(timezoneTA);
		SpringUtilities.makeCompactGrid(taPanel, 3, 2, 6, 6, 6, 6);
		okPanel = new JPanel();
		okPanel.setLayout(new BorderLayout());
		okPanel.add(okButton, BorderLayout.EAST);
		add(taPanel, BorderLayout.CENTER);
		add(okPanel, BorderLayout.SOUTH);
		setVisible(true);

	}    

}
