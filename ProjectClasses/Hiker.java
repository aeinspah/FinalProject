package ProjectClasses;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.URL;

public class Hiker extends SearchTeams {
	
	private double speed;
	private Image thumbnail1;
	
	public Hiker() {
		super();
		URL url = getClass().getResource("/Images/hikersymbol.gif");
		Image original = Toolkit.getDefaultToolkit().getImage(url);
		thumbnail1 = original.getScaledInstance(32, 32,  Image.SCALE_FAST);
	}
	
	public void updateLocation(Node node) {
		location = node;
	}
	
	public int getLocation() {
		return 0; 
	}
	
	public void predictMovement() {
		// call updateLovation
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(thumbnail1, location.getX()-16, location.getY()-16, 32, 32, null);
		highlightSearchedArea(g);
	}	
	
}
