import java.util.*;

public class ProcessController {
	
	private final MainController mainController;
	private List<Module> modules;
	private List<double[]> origStepEstimates;
	private List<double[]> stepEstimates;
	private List<double[]> workDonePerSection;
	private List<Double> meetings;
	private double origMoney;
	private double money;
	private double developerCost;
	private double developerProductivity;
	private double workLeftToDo;
	private double workPoints;
	private String[] stages;
	private Scenario s;
	private Random randomGen;
	private int startOfWorkingDay;
	private int endOfWorkingDay;
	private long time;

	public ProcessController(final MainController mainController) {
		
		this.mainController = mainController;
		startOfWorkingDay = 9;
		endOfWorkingDay = 18;
		stages = new String[7];
		stages[0] = "Design"; stages[1] = "Implementation"; stages[2] = "Unit Test"; stages[3] = "Integration";
		stages[4] = "System Test"; stages[5] = "Deployment"; stages[6] = "Acceptance Test";
		randomGen = new Random();
		workDonePerSection = new ArrayList<double[]>();
		modules = new ArrayList<Module>();
		stepEstimates = new ArrayList<double[]>();
		origStepEstimates = new ArrayList<double[]>();
		s = mainController.getStartupController().getScenario();
		developerCost = mainController.getStartupController().getDeveloperCost();
		developerProductivity = mainController.getStartupController().getDeveloperProductivity();
		money = mainController.getStartupController().getPlayerMoney();
		origMoney = mainController.getStartupController().getPlayerMoney();
		meetings = new ArrayList<Double>();
		for(Site site : s.getSites()) {
			meetings.add(new Double(0));
			for(Module module : site.getModules()) {
				modules.add(module);
				origStepEstimates.add(new double[7]);
				stepEstimates.add(new double[7]);
				workDonePerSection.add(new double[7]);
			}
		}
		processModules();
		printSchedule();

	}

	public void hourlyUpdate(long time) {

		int i;

		if(isComplete()) {
			new EndOfGameController(this);
			mainController.getTimeController().setPaused(true);
		}
		System.out.println("Performing hourly update.");
		for(Site site : s.getSites()) {
			workPoints = site.getNumWorkers() * developerProductivity;
			if(((site.getTimezone() + time) % 24 >= startOfWorkingDay) && ((site.getTimezone() + time) % 24 <= endOfWorkingDay)) {
				if(meetings.get(s.getSites().indexOf(site)) > 0) {
					meetings.set(s.getSites().indexOf(site),meetings.get(s.getSites().indexOf(site)) - 1);
					continue;
				}
				money -= site.getNumWorkers() * developerCost;
				if(money < 0) {
					new LostGameController(mainController);
					mainController.getTimeController().setPaused(true);
				}
				mainController.getMapController().setMoney(money);
				System.out.println("Performing work at site: " + site.getName());				
				for(int mI = 0; mI < site.getModules().size(); mI++) {
					i = modules.indexOf(site.getModules().get(mI));
					System.out.println("    Performing work on module: " + modules.get(i).getName());
					for(int j = 0; j < 7; j++) {
						workLeftToDo = stepEstimates.get(i)[j] - workDonePerSection.get(i)[j];
						if(workLeftToDo != 0) {
							if(workLeftToDo <= workPoints) {
								workDonePerSection.get(i)[j] = stepEstimates.get(i)[j]; 
								workPoints -= workLeftToDo;
								System.out.println("        Performed " + workLeftToDo + " hours on " + stages[j]);
							} else {
								workDonePerSection.get(i)[j] += workPoints;
								System.out.println("        Performed " + workPoints + " hours on " + stages[j]);
								break;
							}
						}
					}
				}
			} else {
				System.out.println("Site: " + site.getName() + " is currently closed");
			}
		}

	}

	public boolean isComplete() {

		for(int i = 0; i < modules.size(); i++) {
			for(int j = 0; j < 7; j++) {
				if(stepEstimates.get(i)[j] != workDonePerSection.get(i)[j]) {
					return false;
				}
			}
		}
		return true;

	}

	public void processModules() {

		int i;

		for(Site site : s.getSites()) {
			for(int mI = 0; mI < site.getModules().size(); mI++) {
				i = modules.indexOf(site.getModules().get(mI));
				System.out.println(""+i+" " +modules.size()+" " +origStepEstimates.size()+" " +stepEstimates.size());
				for(int j = 0; j < 7; j++) {
					if(j == 2) {
						origStepEstimates.get(i)[j] = modules.get(i).getEstimate() * .1;
					} else {
						origStepEstimates.get(i)[j] = modules.get(i).getEstimate() * .15;
					}
					if(randomGen.nextInt(2) == 1) {
						stepEstimates.get(i)[j] = origStepEstimates.get(i)[j] * (1 + (((float)randomGen.nextInt(26)) / 100));
					} else {
						stepEstimates.get(i)[j] = origStepEstimates.get(i)[j] * (1 - (((float)randomGen.nextInt(26)) / 100));
					}
				}
			}
		}

	}

	public void printSchedule() {

		int i;

		System.out.println("Nominal Schedule: ");
		for(Site site : s.getSites()) {
			System.out.println("Site: " + site.getName());
			for(int mI = 0; mI < site.getModules().size(); mI++) {
				i = modules.indexOf(site.getModules().get(mI));
				System.out.println("	Module: " + modules.get(i).getName());
				for (int j = 0; j < 7; j++) {
					System.out.println("        Stage: " + stages[j]);
					System.out.println("             original estimate: " + origStepEstimates.get(i)[j]);
					System.out.println("             randomized estimate: " + stepEstimates.get(i)[j]);
				}
				System.out.println();
			}
			System.out.println();
		}
	}

	public List<double[]> getStepEstimates() {
		return stepEstimates;
	}

	public List<double[]> getOrigStepEstimates() {
		return origStepEstimates;
	}

	public double getMoney() {
		return money;
	}

	public double getOrigMoney() {
		return getMainController().getStartupController().getPlayerMoney();
	}

	public MainController getMainController() {
		return mainController;
	}

	public String[] getStages() {
		return stages;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void addMeeting(Site sitea, double meetingTime) {
		for(int i = 0; i < s.getSites().size(); i++) {
			if(s.getSites().get(i).getName().equals(sitea.getName())) {
				meetings.set(i, meetings.get(i) + meetingTime); 
			}
		}
	}

}
