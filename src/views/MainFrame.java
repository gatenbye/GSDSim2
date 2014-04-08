import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

	private Map map;

	public MainFrame() {
		
		/*set size to screensize */
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension d = t.getScreenSize();
		setSize(d.width, d.height);

	}

	public void setMap(Map map) {
		this.map = map;
		add(map);
	}

	public void setVisible() {
		setVisible(true);
	}

}
