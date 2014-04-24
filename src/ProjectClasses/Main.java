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
		setSize(800, 625);
		img = new ImagePanel(this);
		img.setSize(600,600);
		add(img, BorderLayout.WEST);
		IconPanel icons = new IconPanel(this);
		icons.setSize(200,600);
		add(icons, BorderLayout.EAST);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	Main gui = new Main(); 
	    		gui.setVisible(true);
	    		gui.img.repaint();
	        } 
	    });
	}
	
}
