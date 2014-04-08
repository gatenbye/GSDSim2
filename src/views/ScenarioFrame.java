import javax.swing.*;
import java.awt.*;

public class ScenarioFrame extends JFrame {

	private Toolkit t;
	private Dimension d;
	private JPanel scenarioPanel;
	private JPanel scenariosPanel;
	private JRadioButton rB;
	private JPanel okPanel;

	public ScenarioFrame(Scenarios scenarios, ButtonGroup bG, JButton okButton) {
		
		t = Toolkit.getDefaultToolkit();
		d = t.getScreenSize();
		setLayout(new BorderLayout());
		setSize(d.width / 2, d.height / 2);
		setLocation((d.width - (d.width / 2)) / 2, (d.height - (d.height / 2)) / 2);
		scenariosPanel = new JPanel();
		scenariosPanel.setLayout(new GridLayout(0, scenarios.scenarios.size()));
		for (Scenario s : scenarios.scenarios) {
			scenarioPanel = new JPanel();
			scenarioPanel.setLayout(new BoxLayout(scenarioPanel,BoxLayout.Y_AXIS));
			rB = new JRadioButton(s.getName());
			bG.add(rB);
			scenarioPanel.add(rB);
			for (Site site : s.getSites()) {
				scenarioPanel.add(new JLabel("    Site: " + site.getName()));
				scenarioPanel.add(new JLabel("        Workers: " + site.getNumWorkers()));
				scenarioPanel.add(new JLabel("        Timezone: " + site.getTimezone()));
				scenarioPanel.add(new JLabel("        Modules: "));
				for (Module module : site.getModules()) {
					scenarioPanel.add(new JLabel("            Name: " + module.getName()));
					scenarioPanel.add(new JLabel("            Hours: " +module.getEstimate()));
				}
			}
			scenariosPanel.add(scenarioPanel);
		}
		okPanel = new JPanel();
		okPanel.setLayout(new BorderLayout());
		okPanel.add(okButton, BorderLayout.EAST);
		add(new JLabel(), BorderLayout.WEST);
		add(new JLabel(), BorderLayout.EAST);
		add(scenariosPanel, BorderLayout.CENTER);
		add(okPanel, BorderLayout.SOUTH);
		setVisible(true);

	}

}
