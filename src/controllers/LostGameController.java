import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LostGameController {

	private final MainController mainController;
	private JButton okButton;
	private LostGameFrame lostGameFrame;

	public LostGameController (final MainController mainController) {

		this.mainController = mainController;
		okButton = new JButton("Ok");
		okButton.addActionListener (new ActionListener() {
      			public void actionPerformed(ActionEvent e) {
				lostGameFrame.dispose();
				mainController.getMapController().getMapFrame().dispose();
				System.exit(0);
     			}        
		});
		lostGameFrame = new LostGameFrame(okButton);

	}

}
