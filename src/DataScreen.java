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
		
		for(int i = 0; i < teamLabelArray.size(); i++) {
			System.out.println(i);

			teamLabelArray.get(i).setVisible(true);
			System.out.println(teamLabelArray.get(i).getText());
			JLabel label2 = new JLabel("label");
			label2.setVisible(true);
			label2.setName("Name");
			label2.setLocation(100, 100);
			System.out.println("conten: " + panel.getComponentCount());
			panel.add(label2);
			System.out.println("conten: " + panel.getComponentCount());
			System.out.println("content: " + panel.getComponent(0).getName());
			panel.repaint();
		}
		
		this.repaint();
		
	}
}
