package ProjectClasses;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogBox extends JDialog{
	public JComboBox<String> box;
	public Main m;
	public int type;
	final Dog d = new Dog();
	final Helicopter h = new Helicopter();
	final Hiker h2 = new Hiker();
	public DialogBox(Main m, int type) {
		this.m = m;
		this.type = type;
		setTitle("Add new point");
		setSize(300,300);
		setLayout(new GridLayout(3,1));
		box = new JComboBox<String>();
		for(SearchTeams t : m.teams) {
			if(type == 1) {
				if(t.isDog()) {
					box.addItem(t.teamName);
				}
			} else if(type == 2) {
				if(t.isHeli()) {
					box.addItem(t.teamName);
				}
			} else if(type == 3) {
				if(t.isHiker()) {
					box.addItem(t.teamName);
				}
			}
		}
		box.addItem("New Team");
		JLabel label = new JLabel("Select a team to add a new point to: ");
		add(label);
		add(box);
		add(new okcancel(this));
	}
	public class okcancel extends JPanel {
		
		public okcancel(final DialogBox d) {
			JButton ok = new JButton("Submit");
			JButton cancel = new JButton("Cancel");
			add(ok);
			add(cancel);
			ok.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e)
			    {
			    	// Pushed OK
			    	if(((String)box.getSelectedItem()).equals("New Team")) {
			    		// Add a new team
			    		selectTeamName x = new selectTeamName(d.m, d.type);
				    	x.setVisible(true);
			    	} else {
			    		for(SearchTeams t : m.teams) {
			    			if(t.teamName.equals((String)box.getSelectedItem())) {
			    				Node temp = t.predictMovement();
			    				t.visitedLocations.add(t.location);
			    				if(!t.isDog())
			    					t.location = temp;
			    				else
			    					JOptionPane.showMessageDialog(null, "Move " + t.teamName +"'s Icon to the new location.");
			    				m.img.repaint();
			    			}
			    		}
			    	}
			    	d.setVisible(false);
			    }
			});
			cancel.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e)
			    {
			      d.setVisible(false);
			    }
			});
		}
	}
	public class selectTeamName extends JDialog {
		public selectTeamName(final Main m, final int type) {
			setSize(200,200);
			setTitle("Select Name");
			setLayout(new GridLayout(4,1));
			JLabel title = new JLabel();
			if(type == 1)
				title.setText("New Dog Team");
			else if(type == 2)
				title.setText("New Helicopter Team");
			else if(type == 3)
				title.setText("New Hiker Team");
			add(title);
			add(new JLabel("Team Name:"));
			final JTextField text = new JTextField(30);
			add(text);
			JButton ok = new JButton("Submit");
			
			ok.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e)
			    {
			    	if(text.getText().length() == 0) {
			    		JOptionPane.showMessageDialog(null, "Team name cannot be blank");
			    	} else {
			    		if(type == 1) {
			    			d.location = new Node(300,300);
			    			d.teamName = text.getText();
			    			m.teams.add(d);
			    		} else if(type == 2) {
			    			h.location = new Node(300,300);
			    			h.teamName = text.getText();
			    			m.teams.add(h);
			    		} else if(type == 3) {
			    			h2.location = new Node(300,300);
			    			h2.teamName = text.getText();
			    			m.teams.add(h2);
			    		}
			    		m.img.repaint();
			    		setVisible(false);
			    	}
			    }
			});
			add(ok);
		}
	}
}
