import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DefaultCustomController {

	private JButton custom;
	private JButton defaultB;
	private DefaultCustomFrame defaultCustomFrame;
	private final StartupController startupController;	

	public DefaultCustomController(final StartupController startupController) {

		this.startupController = startupController;
		custom = new JButton();
		defaultB = new JButton();
		custom.addActionListener(new ActionListener() {
      			public void actionPerformed(ActionEvent e) {
				new CustomController(startupController);
				defaultCustomFrame.dispose();
			}
		});
		defaultB.addActionListener(new ActionListener() {
      			public void actionPerformed(ActionEvent e) {
				new ScenarioController(startupController);
				defaultCustomFrame.dispose();
			}
		});
		defaultCustomFrame = new DefaultCustomFrame(custom, defaultB); 

	}

}
