import javax.swing.*;
import java.awt.*;
import java.util.*;

public class EndOfGameFrame extends JFrame {

	private Toolkit t;
	private Dimension d;
	private JPanel budgetPanel;
	private JPanel mainPanel;
	private JPanel modulePanel;
	private JPanel okPanel;
	private GridBagConstraints constraints;

	public EndOfGameFrame (double origMoney, double money, java.util.List<Module> modules, java.util.List<double[]> stepEstimates, java.util.List<double[]> origStepEstimates, JButton okButton, String[] stages) {

		t = Toolkit.getDefaultToolkit();
		d = t.getScreenSize();
		setSize((d.width / 4) * 3, (d.height / 4) * 3);
		setLocation((d.width - ((d.width / 4) * 3)) / 2, (d.height - ((d.height / 4) * 3)) / 2);
		setLayout(new BorderLayout());
		constraints = new GridBagConstraints();
		okButton.setText("Ok");
		budgetPanel = new JPanel();
		budgetPanel.add(new JLabel("Budget: " + origMoney));
		budgetPanel.add(new JLabel("Spent: " + money)); 
		mainPanel = new JPanel(new GridBagLayout());
		constraints.gridy = 0;
		mainPanel.add(budgetPanel, constraints);		
		for (int i = 0; i < stepEstimates.size(); i++) {
			modulePanel = new JPanel(new SpringLayout());
			constraints.gridy = (i * 2) + 1;
			mainPanel.add(new JLabel("Module: " + modules.get(i).getName()), constraints);
			for (int j = 0; j < 7; j++) {
				modulePanel.add(new JLabel("Stage: " + stages[j]));
				modulePanel.add(new JLabel("Expected: " + origStepEstimates.get(i)[j]));
				modulePanel.add(new JLabel("Actual: " + stepEstimates.get(i)[j]));
			}
			SpringUtilities.makeCompactGrid(modulePanel, 7, 3, 6, 6, 6, 6);	
			constraints.gridy = (i + 1) * 2;
			mainPanel.add(modulePanel, constraints);
		}
		okPanel = new JPanel();
		okPanel.setLayout(new BorderLayout());
		okPanel.add(okButton, BorderLayout.EAST);
		add(okPanel, BorderLayout.SOUTH);
		add(mainPanel, BorderLayout.CENTER);
		setVisible(true);		
	}

}
