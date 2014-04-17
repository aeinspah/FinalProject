package ProjectClasses;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JPanel;


public class ImagePanel extends JPanel {
	private Image thumbnail;
	public ImagePanel() {
		this.setPreferredSize(new Dimension(600,600));
		MediaTracker tracker = new MediaTracker(this);
		URL url = getClass().getResource("/Images/forestmap.jpg");
		Image original = Toolkit.getDefaultToolkit().getImage(url);
		tracker.addImage(original, 0);
		try {
			tracker.waitForID(0);
		} catch (InterruptedException e) { 
			return; 
		}
		thumbnail = original.getScaledInstance(600, 600,  Image.SCALE_FAST);
	}
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(thumbnail, 0, 0, 600, 600, this);
	}
}