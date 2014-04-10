import javax.swing.*;
import java.awt.*;

public class DefaultCustomFrame extends JFrame {

	Toolkit t;
	Dimension d;

	public DefaultCustomFrame(JButton custom, JButton defaultB) {
		
		t = Toolkit.getDefaultToolkit();
		d = t.getScreenSize();
		setSize(d.width / 2, d.height / 2);
		setLocation((d.width - (d.width / 2)) / 2, (d.height - (d.height / 2)) / 2);
		setLayout(new GridLayout(1, 0));
		custom.setText("Custom Scenario");
		defaultB.setText("Default Scenario");
		custom.setPreferredSize(new Dimension(200, 100));
		defaultB.setPreferredSize(new Dimension(200, 100));
		add(custom);
		add(defaultB);
		setVisible(true);
		

	}
	
}
