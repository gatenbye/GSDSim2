import javax.swing.*;
import java.awt.*;

public class SecondsPerDayFrame extends JFrame {

	Toolkit t;
	Dimension d;
	JPanel okPanel;
	JPanel mainPanel;

	public SecondsPerDayFrame(JSlider slider, JTextArea developerCostTA, JTextArea developerProductivityTA, JTextArea playerMoneyTA, JComboBox pauseEnabled, JButton okButton) {
		
		t = Toolkit.getDefaultToolkit();
		d = t.getScreenSize();
		setSize(d.width / 2, d.height / 2);
		setLocation((d.width - (d.width / 2)) / 2, (d.height - (d.height / 2)) / 2);
		setLayout(new BorderLayout());
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(20);
		slider.setPaintTicks(true);  
		slider.setPaintLabels(true);
		mainPanel = new JPanel(new SpringLayout());
		mainPanel = new JPanel(new SpringLayout());
		mainPanel.add(new JLabel("Seconds Per Day: ", JLabel.TRAILING));
		mainPanel.add(slider);
		mainPanel.add(new JLabel("Developer Cost: ", JLabel.TRAILING));
		mainPanel.add(developerCostTA);
		mainPanel.add(new JLabel("Developer Productivity: ", JLabel.TRAILING));
		mainPanel.add(developerProductivityTA);
		mainPanel.add(new JLabel("Player's Money: ", JLabel.TRAILING));
		mainPanel.add(playerMoneyTA);
		mainPanel.add(new JLabel("Pause Enabled: ", JLabel.TRAILING));
		mainPanel.add(pauseEnabled);
		SpringUtilities.makeCompactGrid(mainPanel, 5, 2, 6, 6, 6, (d.height - (d.height / 2)) / 8);
		okPanel = new JPanel();
		okPanel.setLayout(new BorderLayout());
		okPanel.add(okButton, BorderLayout.EAST);
		add(mainPanel, BorderLayout.CENTER);
		add(okPanel, BorderLayout.SOUTH);
		setVisible(true);

	}
	
}
