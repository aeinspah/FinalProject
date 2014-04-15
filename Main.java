import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class Main extends JFrame {
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Final Project");
		setSize(800, 600);
		JPanel img = new ImagePanel();
		add(img);
	}
	
	public class ImagePanel extends JPanel {
		private Image thumbnail;
		public ImagePanel() {
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
		public void paintComponent(Graphics g) {
		    int PADDING = 0;
		    g.drawImage(thumbnail, PADDING, PADDING, 600, 600, this);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	Main gui = new Main(); 
	    		gui.setVisible(true);
	        }  });

	}
	
}
