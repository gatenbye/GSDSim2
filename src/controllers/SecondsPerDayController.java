import com.google.gson.*;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class SecondsPerDayController {

	private JSlider slider;
	private SecondsPerDay spd;
	private JTextArea developerCost;
	private JTextArea developerProductivity;
	private JTextArea playerMoney;
	private JComboBox pauseEnabled;
	private JButton okButton;
	private final StartupController startupController;
	private SecondsPerDayFrame secondsPerDayFrame;

	public SecondsPerDayController(final StartupController startupController) {

		this.startupController = startupController;
		loadSecondsPerDay();
		slider = new JSlider(JSlider.HORIZONTAL, spd.minSecondsPerDay, spd.maxSecondsPerDay, (spd.maxSecondsPerDay - spd.minSecondsPerDay) / 2);
		developerCost = new JTextArea();
		developerProductivity = new JTextArea();
		playerMoney = new JTextArea();
		pauseEnabled = new JComboBox();
		pauseEnabled.addItem("True");
		pauseEnabled.addItem("False");
		okButton = new JButton("Ok");
		okButton.addActionListener (new ActionListener() {
      			public void actionPerformed(ActionEvent e) {
				startupController.setSecondsPerDay(slider.getValue());
				startupController.setDeveloperCost(Double.parseDouble(developerCost.getText()));
				startupController.setDeveloperProductivity(Integer.parseInt(developerProductivity.getText()));
				startupController.setPlayerMoney(Integer.parseInt(playerMoney.getText()));
				if (((String)pauseEnabled.getSelectedItem()).equals("True")) {
					startupController.setPause(true);
				} else {
					startupController.setPause(false);
				}
				secondsPerDayFrame.dispose();
				startupController.getMainController().setupMainFrame();
     			}        
		});
		secondsPerDayFrame = new SecondsPerDayFrame(slider, developerCost, developerProductivity, playerMoney, pauseEnabled, okButton);

	}		

	public void loadSecondsPerDay() {

		try {
			BufferedReader br = new BufferedReader(new FileReader("src/gameFiles/secondsPerDay.json"));
			Gson gson = new Gson();
			spd = gson.fromJson(br, SecondsPerDay.class);
			br.close();
		} catch (JsonSyntaxException e) {
			System.err.println("File does not contain valid JSON");
			System.err.println("\t" + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error loading scenario " + e);
		}

	}

}
