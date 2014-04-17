package ProjectClasses;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;

public class Helicopter extends SearchTeams {
	
	private double speed;
	private Image thumbnail1;
	
	public Helicopter( ) {
		super();
		visitedLocations = new ArrayList<Node>();
		URL url = getClass().getResource("/Images/helicoptersymbol.gif");
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
		highlightSearchedArea(g, 100);
		g.setColor(Color.BLUE);
		g.setFont(new Font("default", Font.BOLD, 16));
		int stringLen = (int)g.getFontMetrics().getStringBounds(teamName, g).getWidth();  
        int start = 50/2 - stringLen/2;  
        g.drawString(teamName, start + location.x -25, location.y-25);
		g.drawImage(thumbnail1, location.x-16, location.y-16, 32, 32, null);
	}
	
}
