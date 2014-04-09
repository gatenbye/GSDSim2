import com.google.gson.*;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class StartupController {

	private int secondsPerDay;
	private double developerCost;
	private int developerProductivity;
	private int playerMoney;	
	private boolean pause;
	private Scenario scenario;
	private JSlider slider;
	private final MainController mainController;
	private DefaultCustomController defaultCustomController;

	public StartupController (final MainController mainController) {
		this.mainController = mainController;
		defaultCustomController = new DefaultCustomController(this);
	}

	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}

	public void setSecondsPerDay(int spd) {
		secondsPerDay = spd;
	}

	public void setDeveloperCost(double cost) {
		developerCost = cost;
	}

	public void setDeveloperProductivity(int productivity) {
		developerProductivity = productivity;
	}

	public void setPlayerMoney(int money) {
		playerMoney = money;
	}

	public void setPause(boolean val) {
		pause = val;
	}

	public Scenario getScenario() {
		return scenario;
	}

	public int getSecondsPerDay() {
		return secondsPerDay;
	}	

	public double getDeveloperCost() {
		return developerCost;
	}

	public int getDeveloperProductivity() {
		return developerProductivity;
	}

	public int getPlayerMoney() {
		return playerMoney;
	}

	public MainController getMainController() {
		return mainController;
	}

	public boolean getPause() {
		return pause;
	}

}

