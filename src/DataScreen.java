import java.awt.BasicStroke;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;

public class DataScreen extends JFrame{
	
	private ArrayList<JLabel> teamLabelArray = new ArrayList<JLabel>();
	private JLabel[] labelArr = new JLabel[20];
	private JPanel panel;
	private JFrame frame;
	
	private JLabel label;
	public DataScreen() {
		frame = new JFrame("Data Tab");
		frame.setTitle("Data Tab");

		frame.setLayout(null);
		frame.setSize(800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.setVisible(true);
		panel.setLayout(null);

		panel.setSize(500, 500);
		
		frame.add(panel);
		
		frame.setVisible(true);
		
		
		frame.repaint();
		
	}
	
	
	public void addTeam(Team team) {
		
		System.out.println(Main.teams.size());
		
		for(int i = 0; i < Main.teams.size(); i++) {
			
			if(Main.teams.get(i).equals(team)) {
				System.out.println(Main.teams.get(i).getNumber());
				System.out.println(team.getNumber());
				//return;
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
			panel.add(teamLabelArray.get(i));
			
			panel.repaint();
		}
		
		frame.repaint();
		
	}
}
