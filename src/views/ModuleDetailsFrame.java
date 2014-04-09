import org.openstreetmap.gui.jmapviewer.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.Spring;
import java.awt.*;

public class ModuleDetailsFrame extends JFrame {

	private Toolkit t;
	private Dimension d;
	private JPanel okPanel;
	private JPanel taPanel;
	private JPanel layoutPanel;
	private JComboBox combo;

	public ModuleDetailsFrame(JTextArea moduleNameTA, JTextArea numHoursTA, JButton addModule, JComboBox siteCombo, JComboBox devMethodCombo, JButton okButton) {
		
		t = Toolkit.getDefaultToolkit();
		d = t.getScreenSize();
		setLayout(new BorderLayout());
		setSize(d.width / 2, d.height / 2);
		setLocation((d.width - (d.width / 2)) / 2, (d.height - (d.height / 2)) / 2);
		okButton.setText("Ok");
		addModule.setText("Add Module");		
		devMethodCombo.addItem("Waterfall");
		devMethodCombo.addItem("Agile");
		taPanel = new JPanel(new SpringLayout());
		taPanel.add(new JLabel("Site: ", JLabel.TRAILING));
		taPanel.add(siteCombo);
		taPanel.add(new JLabel("Module name: ", JLabel.TRAILING));
		taPanel.add(moduleNameTA);
		taPanel.add(new JLabel("Number of hours: ", JLabel.TRAILING));
		taPanel.add(numHoursTA);	
		taPanel.add(new JLabel("Development method: ", JLabel.TRAILING));
		taPanel.add(devMethodCombo);
		SpringUtilities.makeCompactGrid(taPanel, 4, 2, 6, 6, 6, (d.height - (d.height / 2)) / 4);
		layoutPanel = new JPanel();
		layoutPanel.setLayout(new GridLayout(0, 1));
		layoutPanel.add(addModule);
		layoutPanel.add(okButton);
		okPanel = new JPanel();
		okPanel.setLayout(new BorderLayout());
		okPanel.add(layoutPanel, BorderLayout.EAST);
		add(taPanel, BorderLayout.CENTER);
		add(okPanel, BorderLayout.SOUTH);
		setVisible(true);

	}    

}
