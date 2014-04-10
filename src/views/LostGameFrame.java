import javax.swing.*;
import java.awt.*;

public class LostGameFrame extends JFrame {

	Toolkit t;
	Dimension d;
	JPanel okPanel;
	JPanel mainPanel;

	public LostGameFrame(JButton okButton) {

		t = Toolkit.getDefaultToolkit();
		d = t.getScreenSize();
		setSize(d.width / 2, d.height / 2);
		setLocation((d.width - (d.width / 2)) / 2, (d.height - (d.height / 2)) / 2);
		setLayout(new BorderLayout());
		mainPanel = new JPanel(new GridBagLayout());
		mainPanel.add(new JLabel("You ran out of money!"));
		okPanel = new JPanel();
		okPanel.setLayout(new BorderLayout());
		okPanel.add(okButton, BorderLayout.EAST);
		add(mainPanel, BorderLayout.CENTER);
		add(okPanel, BorderLayout.SOUTH);
		setVisible(true);

	}

}
