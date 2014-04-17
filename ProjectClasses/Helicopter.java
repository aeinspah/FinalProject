package ProjectClasses;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.URL;

public class Helicopter extends SearchTeams {
	
	private double speed;
	private Image thumbnail1;
	
	public Helicopter( ) {
		super();
	}
	
	public void updateLocation(Node node) {
		
	}
	
	public int getLocation() {
		return 0; 
	}
	
	public void predictMovement() {
		// call updateLovation
	}
	
	@Override
	public void draw(Graphics g, MediaTracker tracker) {
		URL url = getClass().getResource("/Images/helicoptersymbol.gif");
		Image original = Toolkit.getDefaultToolkit().getImage(url);
		tracker.addImage(original, 1);
		try {
			tracker.waitForID(1);
			tracker.waitForID(2);
			tracker.waitForID(3);
		} catch (InterruptedException e) { 
			return; 
		}
		thumbnail1 = original.getScaledInstance(16, 16,  Image.SCALE_FAST);
		g.drawImage(thumbnail1, location.getX()-8, location.getY()-8, 16, 16, null);
	}
	
}
