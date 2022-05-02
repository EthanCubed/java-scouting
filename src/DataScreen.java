import java.awt.BasicStroke;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;

public class DataScreen extends JFrame{
	
	private ArrayList<JLabel> teamLabelArray = new ArrayList<JLabel>();
	private JLabel[] labelArr = new JLabel[20];
	private JPanel panel;
	
	private JLabel label;
	public DataScreen() {
		this.setTitle("Data Tab");

		this.setLayout(null);
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.setVisible(true);
		panel.setLayout(null);

		panel.setSize(500, 500);
		
		this.add(panel);
		
		this.setVisible(true);
		
		
		this.repaint();
		
	}
	
	
	public void addTeam(Team team) {
		
		System.out.println("size: " + Main.teams.size());
		
		for(int i = 0; i < Main.teams.size(); i++) {
			
			if(Main.teams.get(i).equals(team) && Main.teams.size() > 0) {
				System.out.println(Main.teams.get(i).getNumber());
				System.out.println(team.getNumber());
				return;
			}
			
		}
		
		System.out.println("Teamnum: " + team.getNumber());
		teamLabelArray.add(new JLabel(team.toDataTab()));
		
		
		System.out.println(team.toDataTab());
		//label.setText(team.toDataTab());
		addTeamArrayToFrame();
		
	}
	
	private void addTeamArrayToFrame() {
		
		panel.removeAll();
		
		for(int i = 0; i < teamLabelArray.size(); i++) {
			
			teamLabelArray.get(i).setVisible(true);
			teamLabelArray.get(i).setSize(300, 10);
			teamLabelArray.get(i).setLocation(5, 5 + ( i * 20 ));
			
			panel.add(teamLabelArray.get(i));
			
			panel.repaint();
			
		}
		
		this.repaint();
		
	}
}
