import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class EndOfGameController {

	private JButton okButton;
	private EndOfGameFrame endFrame;
	private final ProcessController processController;
	private double origMoney;
	private double money;
	private java.util.List<double[]> origStepEstimates;
	private java.util.List<double[]> stepEstimates;
	private java.util.List<Module> modules;
	private String[] stages;

	public EndOfGameController(final ProcessController processController) {
		this.processController = processController;
		origMoney = processController.getOrigMoney();
		money = processController.getMoney();
		stepEstimates = processController.getStepEstimates();
		origStepEstimates = processController.getOrigStepEstimates();
		stages = processController.getStages();
		modules = processController.getModules();
		okButton = new JButton();
		okButton.addActionListener (new ActionListener() {
      			public void actionPerformed(ActionEvent e) {
				processController.getMainController().getMapController().getMapFrame().dispose();
				endFrame.dispose();
				System.exit(0);
			}
		});		
		endFrame = new EndOfGameFrame(origMoney, money, modules, stepEstimates, origStepEstimates, okButton, stages);
	}
}
