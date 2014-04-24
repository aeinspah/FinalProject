package ProjectClasses;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.net.URL;

import javax.swing.JPanel;


public class ImagePanel extends JPanel {
	private Image thumbnail;
	private Image thumbnail1;
	private Image thumbnail2;
	private Image thumbnail3;
	Main main;
	MediaTracker tracker;
	public ImagePanel(Main m) {
		main = m;
		this.setPreferredSize(new Dimension(600,600));
		tracker = new MediaTracker(this);
		URL url = getClass().getResource("/Images/forestmap.jpg");
		Image original = Toolkit.getDefaultToolkit().getImage(url);
		URL url1 = getClass().getResource("/Images/dogsymbol.gif");
		Image original1 = Toolkit.getDefaultToolkit().getImage(url1);
		URL url2 = getClass().getResource("/Images/helicoptersymbol.gif");
		Image original2 = Toolkit.getDefaultToolkit().getImage(url2);
		URL url3 = getClass().getResource("/Images/hikersymbol.gif");
		Image original3 = Toolkit.getDefaultToolkit().getImage(url3);
		
		tracker.addImage(original, 0);
		tracker.addImage(original1, 1);
		tracker.addImage(original2, 2);
		tracker.addImage(original3, 3);
		try {
			tracker.waitForID(0);
			tracker.waitForID(1);
			tracker.waitForID(2);
			tracker.waitForID(3);
		} catch (InterruptedException e) { 
			return; 
		}
		thumbnail = original.getScaledInstance(600, 600,  Image.SCALE_FAST);
		thumbnail1 = original1.getScaledInstance(32, 32,  Image.SCALE_FAST);
		thumbnail2 = original2.getScaledInstance(32, 32,  Image.SCALE_FAST);
		thumbnail3 = original3.getScaledInstance(32, 32,  Image.SCALE_FAST);
		addMouseMotionListener(new MouseMotionHandler());
	}
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(thumbnail, 0, 0, 600, 600, this);
		for(SearchTeams t : main.teams) {
			t.draw(g);
			if(t.isDog())
				g.drawImage(thumbnail1, t.location.x-16, t.location.y-16, 32, 32, this);
			else if(t.isHeli())
				g.drawImage(thumbnail2, t.location.x-16, t.location.y-16, 32, 32, this);
			else if(t.isHiker())
				g.drawImage(thumbnail3, t.location.x-16, t.location.y-16, 32, 32, this);
		}
	}
	
	class MouseMotionHandler extends MouseMotionAdapter {
		public void mouseDragged(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			for(SearchTeams t : main.teams) {
				if(x < t.location.x+16 && x > t.location.x-16 && y < t.location.y+16 && y > t.location.y-16) {
					t.location = new Node(x,y);
					break;
				}
			}
			repaint();
		}
	}
}