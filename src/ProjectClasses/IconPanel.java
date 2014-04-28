package ProjectClasses;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;


public class IconPanel extends JPanel {
	private Image thumbnail1;
	private Image thumbnail2;
	private Image thumbnail3;
	private JButton but1;
	private JButton but2;
	private JButton but3;
	MediaTracker tracker;
	public Main m;
	public IconPanel(Main m2) {
		m = m2;
		this.setPreferredSize(new Dimension(200,600));
		tracker = new MediaTracker(this);
		URL url = getClass().getResource("/Images/dogsymbol.gif");
		Image original = Toolkit.getDefaultToolkit().getImage(url);
		tracker.addImage(original, 1);
		URL url1 = getClass().getResource("/Images/helicoptersymbol.gif");
		Image original1 = Toolkit.getDefaultToolkit().getImage(url1);
		tracker.addImage(original1, 2);
		URL url2 = getClass().getResource("/Images/hikersymbol.gif");
		Image original2 = Toolkit.getDefaultToolkit().getImage(url2);
		tracker.addImage(original2, 3);
		try {
			tracker.waitForID(1);
			tracker.waitForID(2);
			tracker.waitForID(3);
		} catch (InterruptedException e) { 
			return; 
		}
		thumbnail1 = original.getScaledInstance(64, 64,  Image.SCALE_FAST);
		thumbnail2 = original1.getScaledInstance(64, 64,  Image.SCALE_FAST);
		thumbnail3 = original2.getScaledInstance(64, 64,  Image.SCALE_FAST);
		
		ImageIcon img1 = new ImageIcon(thumbnail1);
		ImageIcon img2 = new ImageIcon(thumbnail2);
		ImageIcon img3 = new ImageIcon(thumbnail3);
		
		but1 = new JButton();
		but2 = new JButton();
		but3 = new JButton();

		but1.setIcon(img1);
		but2.setIcon(img2);
		but3.setIcon(img3);
		
		add(but1);
		add(but2);
		add(but3);
		
		but1.addMouseListener(new Listen());
		but2.addMouseListener(new Listen());
		but3.addMouseListener(new Listen());
	}
	
	public class Listen implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			if(arg0.getSource() == but1) {
				// dog button
				DialogBox b = new DialogBox(m, 1);
				b.setVisible(true);
			} else if (arg0.getSource() == but2) {
				//helicopter button
				DialogBox b = new DialogBox(m, 2);
				b.setVisible(true);
			} else {
				// Hiker button
				DialogBox b = new DialogBox(m, 3);
				b.setVisible(true);
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {}

		@Override
		public void mouseExited(MouseEvent arg0) {}

		@Override
		public void mousePressed(MouseEvent arg0) {}

		@Override
		public void mouseReleased(MouseEvent arg0) {}
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		//g.drawImage(thumbnail1, 75, 100, 64, 64, null);
		//g.drawImage(thumbnail2, 75, 200, 64, 64, null);
		//g.drawImage(thumbnail3, 75, 300, 64, 64, null);
	}
}
