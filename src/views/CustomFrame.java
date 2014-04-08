import org.openstreetmap.gui.jmapviewer.*;
import javax.swing.*;
import java.awt.*;

public class CustomFrame extends JFrame {

	private Toolkit t;
	private Dimension d;
	private JPanel okPanel;

	public CustomFrame(JMapViewer map, JButton okButton) {
		
		t = Toolkit.getDefaultToolkit();
		d = t.getScreenSize();
		setLayout(new BorderLayout());
		setSize(d.width / 2, d.height / 2);
		setLocation((d.width - (d.width / 2)) / 2, (d.height - (d.height / 2)) / 2);
		okButton.setText("Ok");
		okPanel = new JPanel();
		okPanel.setLayout(new BorderLayout());
		okPanel.add(okButton, BorderLayout.EAST);
		add(map, BorderLayout.CENTER);
		add(okPanel, BorderLayout.SOUTH);
		setVisible(true);

	}

}
