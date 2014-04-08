import org.openstreetmap.gui.jmapviewer.*;
import javax.swing.*;
import java.awt.*;

public class MapFrame extends JFrame {

	JLayeredPane pane;
	Toolkit t;
	Dimension d;
	JPanel mapPanel;

	public MapFrame(JMapViewer map, JLabel time, JLabel money, JButton pause) {
		super();
		t = Toolkit.getDefaultToolkit();
		d = t.getScreenSize();
		setSize(d.width, d.height);
		pane = getLayeredPane();
		pause.setText("Pause");
		pause.setBounds(d.width - 100, 5, 95, 45);
		time.setBounds(d.width - 100, 55, 95, 25);
		money.setBounds(d.width - 100, 80, 95, 25);
		pane.add(time, new Integer(2));
		pane.add(money, new Integer(2));
		pane.add(pause, new Integer(2));
		map.setBounds(0, 0, d.width, d.height);
		pane.add(map, new Integer(1));
		setVisible(true);
	}

}