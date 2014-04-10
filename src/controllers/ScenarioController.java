import com.google.gson.*;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class ScenarioController {

	private final StartupController startupController;
	private ButtonGroup bG;
	private Scenarios scenarios;
	private JButton okButton;
	private ScenarioFrame scenarioFrame;

	public ScenarioController(final StartupController startupController) {
		
		this.startupController = startupController;
		loadScenarios();
		bG = new ButtonGroup();
		okButton = new JButton("Ok");
		okButton.addActionListener (new ActionListener() {
      			public void actionPerformed(ActionEvent e) {
				for (Enumeration<AbstractButton> buttons = bG.getElements(); buttons.hasMoreElements();) {
					AbstractButton button = buttons.nextElement();
					if (button.isSelected()) {
						for (Scenario s : scenarios.scenarios) {
							if (s.getName().equals(button.getText())) {
								startupController.setScenario(s);
							}
						}
					}
				}
				scenarioFrame.dispose();
				new SecondsPerDayController(startupController);
     			}        
		}); 
		scenarioFrame = new ScenarioFrame(scenarios, bG, okButton);

	}

	public StartupController getStartupController() {
		return startupController;
	}	

	public void loadScenarios() {

		try {
			BufferedReader br = new BufferedReader(new FileReader("src/gameFiles/scenarios.json"));
			Gson gson = new Gson();
			scenarios = gson.fromJson(br, Scenarios.class);
			br.close();
		} catch (JsonSyntaxException e) {
			System.err.println("File does not contain valid JSON");
			System.err.println("\t" + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error loading scenario " + e);
		}
	}
}
