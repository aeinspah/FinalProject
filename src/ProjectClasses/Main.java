package ProjectClasses;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class Main extends JFrame {
	
	public ArrayList<SearchTeams> teams;
	ImagePanel img;
	public Main() {
		teams = new ArrayList<SearchTeams>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Final Project");
		//setLayout(new GridLayout(1,2));
		setSize(800, 600);
		img = new ImagePanel(this);
		img.setSize(600,600);
		add(img, BorderLayout.WEST);
		IconPanel icons = new IconPanel();
		icons.setSize(200,600);
		add(icons, BorderLayout.EAST);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	Main gui = new Main(); 
	    		gui.setVisible(true);
	    		Hiker h = new Hiker();
	    		h.updateLocation(new Node(350,400));
	    		h.visitedLocations.add(new Node(150,50));
	    		h.visitedLocations.add(new Node(350,50));
	    		h.visitedLocations.add(new Node(400,250));
	    		h.teamName = "Hiker 1";
	    		Helicopter h2 = new Helicopter();
	    		h2.updateLocation(new Node(500,500));
	    		h2.visitedLocations.add(new Node(100,100));
	    		h2.visitedLocations.add(new Node(100,300));
	    		h2.visitedLocations.add(new Node(100,500));
	    		h2.visitedLocations.add(new Node(300,500));
	    		h2.teamName = "Heli 1";
	    		Dog d = new Dog();
	    		d.updateLocation(new Node(550,100));
	    		d.visitedLocations.add(new Node(400,450));
	    		d.visitedLocations.add(new Node(450,400));
	    		d.visitedLocations.add(new Node(550,300));
	    		d.visitedLocations.add(new Node(480,200));
	    		d.teamName = "Dog 1";
	    		gui.teams.add(h);
	    		gui.teams.add(h2);
	    		gui.teams.add(d);
	    		gui.img.repaint();
	        } 
	    });
	}
	
}
