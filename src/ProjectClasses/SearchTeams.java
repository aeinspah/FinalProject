package ProjectClasses;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MediaTracker;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.Vector;

public abstract class SearchTeams {

	public Vector nodes;
	public String teamName;
	public Node location;
	public ArrayList<Node> visitedLocations;

	public void highlightSearchedArea(Graphics g, int radius) {
		Graphics2D g2 = (Graphics2D)g.create();
		if(visitedLocations.size() > 1) {
			for(int i = 0; i < visitedLocations.size()-1; i++) {
				Node p1 = visitedLocations.get(i);
				Node p2 = visitedLocations.get(i+1);
				drawBetweenPts(g2, p1, p2, radius);
			}
		}
		if(visitedLocations.size() >= 1) {
			Node p1 = visitedLocations.get(visitedLocations.size()-1);
			Node p2 = location;
			drawBetweenPts(g2, p1, p2, radius);
		}
		g2.dispose();
	}
	
	public void drawBetweenPts(Graphics2D g2, Node p1, Node p2, int radius) {
		double angle = Math.atan2(p1.y - p2.y, p1.x - p2.x);
        double width = Math.sqrt(  ( (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y)));
        g2.setColor(Color.RED);
		g2.setComposite(AlphaComposite.SrcOver.derive(0.3f));
        g2.translate(p2.x, p2.y);
        g2.rotate(angle);
        g2.fillRect(0, -radius/2, (int)width, radius);
        
        g2.fillArc(-radius/2, -radius/2, radius, radius, 90, 180);
        
        g2.fillArc((int)width -radius/2, -radius/2, radius, radius, -90, 180);
        g2.rotate(-angle);
        g2.translate(-p2.x, -p2.y);
		
        g2.setColor(Color.BLUE);
		g2.setComposite(AlphaComposite.SrcOver.derive(1f));
		g2.fillOval(p1.x-5, p1.y-5, 10, 10);
		g2.fillOval(p2.x-5, p2.y-5, 10, 10);
		g2.setColor(Color.RED);
		g2.setComposite(AlphaComposite.SrcOver.derive(0.3f));
	}
	
	public Boolean isHeli() {
		return false;
	}
	
	public Boolean isHiker() {
		return false;
	}
	
	public Boolean isDog() {
		return false;
	}
	
	public Node predictMovement() {
		Node p2 = visitedLocations.get(visitedLocations.size()-1);
		Node p1 = location;
		System.out.println(p1 + ", " + p2);
		double dist = Math.sqrt(  ( (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y)));
		double angle = Math.atan2(p1.y - p2.y, p1.x - p2.x);
		
		System.out.println("Dist = " + dist + ", angle = " + angle);
		
		Node p3 = new Node(p1.x + (int)(dist * Math.cos(angle)), p1.y + (int)(dist * Math.sin(angle)));
		System.out.println(p3);
		return p3;
	}

	public abstract void draw(Graphics g);

}
