package ProjectClasses;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;

public class Dog extends SearchTeams {
	
	private double speed;
	private Image thumbnail1;
	
	public Dog() {
		super();
		visitedLocations = new ArrayList<Node>();
	}
	
	public void updateLocation(Node node) {
		location = node;
	}
	
	public int getLocation() {
		return 0; 
	}
	
	
	@Override
	public void draw(Graphics g) {
		highlightSearchedArea(g, 20);
		g.setColor(Color.BLUE);
		g.setFont(new Font("default", Font.BOLD, 16));
		int stringLen = (int)g.getFontMetrics().getStringBounds(teamName, g).getWidth();  
        int start = 50/2 - stringLen/2;  
        g.drawString(teamName, start + location.x -25, location.y-25);
	}
	
	@Override
	public Boolean isDog() {
		return true;
	}
}

