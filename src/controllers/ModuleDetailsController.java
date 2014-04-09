import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ModuleDetailsController {

	private JTextArea moduleNameTA;
	private JTextArea numHoursTA;
	private JButton addModule;
	private JComboBox siteCombo;
	private JComboBox devMethodCombo;
	private JButton okButton;
	private ModuleDetailsFrame moduleDetailsFrame;
	private final CustomController customController;

	public ModuleDetailsController(final CustomController customController) {
		
		this.customController = customController;
		moduleNameTA = new JTextArea();
		numHoursTA = new JTextArea();
		siteCombo = new JComboBox();
		for(Site site : customController.getSites()) {
			siteCombo.addItem(site.getName());
		}
		devMethodCombo = new JComboBox();
		addModule = new JButton();
		addModule.addActionListener (new ActionListener() {
      			public void actionPerformed(ActionEvent e) {
				customController.addModule((String) siteCombo.getSelectedItem(), moduleNameTA.getText(), Double.parseDouble(numHoursTA.getText()), (String) devMethodCombo.getSelectedItem());
				moduleNameTA.setText("");
				numHoursTA.setText("");
     			}        
		});
		okButton = new JButton();
		okButton.addActionListener (new ActionListener() {
      			public void actionPerformed(ActionEvent e) {
				customController.getStartupController().setScenario(new Scenario("Custom Scenario", customController.getSites()));
				moduleDetailsFrame.dispose();
				new SecondsPerDayController(customController.getStartupController());
     			}        
		});
		moduleDetailsFrame = new ModuleDetailsFrame(moduleNameTA, numHoursTA, addModule, siteCombo, devMethodCombo, okButton);

	}

}
