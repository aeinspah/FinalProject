package ProjectClasses;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JPanel;


public class IconPanel extends JPanel {
	private Image thumbnail1;
	private Image thumbnail2;
	private Image thumbnail3;
	MediaTracker tracker;
	public IconPanel() {
		this.setPreferredSize(new Dimension(200,600));
		setBackground(Color.CYAN);
		tracker = new MediaTracker(this);
		URL url = getClass().getResource("/Images/dogsymbol.gif");
		Image original = Toolkit.getDefaultToolkit().getImage(url);
		tracker.addImage(original, 1);
		URL url1 = getClass().getResource("/Images/helicoptersymbol.gif");
		Image original1 = Toolkit.getDefaultToolkit().getImage(url1);
		tracker.addImage(original1, 2);
		URL url2 = getClass().getResource("/Images/hikersymbol.gif");
		Image original2 = Toolkit.getDefaultToolkit().getImage(url2);
		tracker.addImage(original2, 3);
		try {
			tracker.waitForID(1);
			tracker.waitForID(2);
			tracker.waitForID(3);
		} catch (InterruptedException e) { 
			return; 
		}
		thumbnail1 = original.getScaledInstance(64, 64,  Image.SCALE_FAST);
		thumbnail2 = original1.getScaledInstance(64, 64,  Image.SCALE_FAST);
		thumbnail3 = original2.getScaledInstance(64, 64,  Image.SCALE_FAST);
	}
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(thumbnail1, 75, 100, 64, 64, null);
		g.drawImage(thumbnail2, 75, 200, 64, 64, null);
		g.drawImage(thumbnail3, 75, 300, 64, 64, null);
	}
}
