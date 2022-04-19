import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class InputScreen extends JFrame implements ActionListener{
	
	ArrayList<Team> teams;
	
	JLabel teamNumL;
	JTextField teamNumT;
	
	JLabel matchNumL;
	JTextField matchNumT;
	
	JLabel autoL;
	
	JLabel aHighAttemptsL;
	JTextField aHighAttemptsT;
	
	JLabel aHighMadeL;
	JTextField aHighMadeT;
	
	JLabel aLowAttemptsL;
	JTextField aLowAttemptsT;
	
	JLabel aLowMadeL;
	JTextField aLowMadeT;
	
	JLabel taxiL;
	JCheckBox taxiC;
	
	JButton autoCalcB;
	JLabel autoPointsL;
	
	JLabel teleL;
	
	JLabel tHighAttemptsL;
	JTextField tHighAttemptsT;
	
	JLabel tHighMadeL;
	JTextField tHighMadeT;
	
	JLabel tLowAttemptsL;
	JTextField tLowAttemptsT;
	
	JLabel tLowMadeL;
	JTextField tLowMadeT;
	
	JLabel climbL;
	JLabel noClimbL;
	JLabel lowClimbL;
	JLabel midClimbL;
	JLabel highClimbL;
	JLabel traversalClimbL;
	
	JCheckBox noClimbC;
	JCheckBox lowClimbC;
	JCheckBox midClimbC;
	JCheckBox highClimbC;
	JCheckBox traversalClimbC;
	
	JButton teleCalcB;
	JLabel telePointsL;
	JLabel climbPointsL;
	JLabel totalTelePointsL;
	JLabel totalAllPointsL;
	
	JButton calcAllB;
	JButton clearDataB;
	JButton formatDataB;
	JLabel dataDisplayL;
	JLabel dataL;
	
	private int autoPoints = 0;
	private int telePoints = 0;
	private int climbPoints = 0;
	private int totalTelePoints = 0;
	private int totalOverallPoints = 0;
	private int teamNum = 0;
	
	private boolean formatted = false;
	
	public InputScreen(ArrayList<Team> teams) {
		
		this.teams = teams;
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(null);
		
		initFunctions();
		
		initAutonomous();
		
		initTeleop();
		
		this.repaint();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		teamNum = Integer.valueOf(teamNumT.getText());
		
		if(e.getSource().equals(autoCalcB)) {
			
			autoCalc();
			
		}else if(e.getSource().equals(teleCalcB)) {
			
			teleCalc();
			
		}else if(e.getSource().equals(formatDataB)){
			
			formatData();
			
		}else if(e.getSource().equals(calcAllB)) {
			
			calcAll();
			
		}else if(e.getSource().equals(clearDataB)) {
			
			clearData();
			
		}
		
	}
	
	private void initFunctions() { 
		
		teamNumL = new JLabel("Team Number:");
		teamNumT = new JTextField("0");
		
		initObj(teamNumL, 270, 25, 125, 25);
		initObj(teamNumT, 360, 25, 70, 25);
		
		matchNumL = new JLabel("Match Number: ");
		matchNumT = new JTextField("0");
		
		initObj(matchNumL, 10, 25, 125, 25);
		initObj(matchNumT, 110, 25, 70, 25);
		
		calcAllB = new JButton("Calculate All");
		clearDataB = new JButton("Clear Data");
		formatDataB = new JButton("Format Data");
		
		dataDisplayL = new JLabel("Current Data: ");
		dataL = new JLabel();
		
		initObj(calcAllB, 500, 25, 150, 25);
		initObj(clearDataB, 500, 75, 150, 25);
		initObj(formatDataB, 500, 125, 150, 25);
		
		calcAllB.addActionListener(this);
		clearDataB.addActionListener(this);
		formatDataB.addActionListener(this);
		
		initObj(dataDisplayL, 500, 150, 150, 25);
		initObj(dataL, 500, 150, 300, 300);
		
	}

	private void initAutonomous(){
		autoL = new JLabel("Auto Period");
		
		initObj(autoL, 70, 65, 100, 25);
		
		
		aHighAttemptsL = new JLabel("Attempts High: ");
		aHighAttemptsT = new JTextField("0");
		
		initObj(aHighAttemptsL, 10, 100, 100, 25);
		initObj(aHighAttemptsT, 110, 100, 100, 25);
		
		aHighMadeL = new JLabel("Made High: ");
		aHighMadeT = new JTextField("0");
		
		initObj(aHighMadeL, 10, 135, 100, 25);
		initObj(aHighMadeT, 110, 135, 100, 25);
		
		
		aLowAttemptsL = new JLabel("Attempts Low: ");
		aLowAttemptsT = new JTextField("0");
		
		initObj(aLowAttemptsL, 10, 185, 100, 25);
		initObj(aLowAttemptsT, 110, 185, 100, 25);
		
		aLowMadeL = new JLabel("Made Low: ");
		aLowMadeT = new JTextField("0");
		
		initObj(aLowMadeL, 10, 220, 100, 25);
		initObj(aLowMadeT, 110, 220, 100, 25);
		
		taxiL = new JLabel("Taxi: ");
		taxiC = new JCheckBox();
		
		initObj(taxiL, 10, 270, 100, 25);
		initObj(taxiC, 110, 270, 25, 25);
		
		autoCalcB = new JButton("Calculate Auto Points");
		autoPointsL = new JLabel("Auto Points: " + autoPoints);
		
		initObj(autoCalcB, 40, 320, 170, 25);
		initObj(autoPointsL, 70, 345, 100, 25);
		
		autoCalcB.addActionListener(this);
		
	}
	
	private void initTeleop() {
		
		teleL = new JLabel("Teleop Period");

		initObj(teleL, 330, 65, 100, 25);
		
		
		tHighAttemptsL = new JLabel("Attempts High: ");
		tHighAttemptsT = new JTextField("0");
		
		initObj(tHighAttemptsL, 270, 100, 100, 25);
		initObj(tHighAttemptsT, 370, 100, 100, 25);
		
		tHighMadeL = new JLabel("Made High: ");
		tHighMadeT = new JTextField("0");
		
		initObj(tHighMadeL, 270, 135, 100, 25);
		initObj(tHighMadeT, 370, 135, 100, 25);
		
		
		tLowAttemptsL = new JLabel("Attempts Low: ");
		tLowAttemptsT = new JTextField("0");
		
		initObj(tLowAttemptsL, 270, 185, 100, 25);
		initObj(tLowAttemptsT, 370, 185, 100, 25);
		
		tLowMadeL = new JLabel("Made Low: ");
		tLowMadeT = new JTextField("0");
		
		initObj(tLowMadeL, 270, 220, 100, 25);
		initObj(tLowMadeT, 370, 220, 100, 25);
		
		initClimb();
		
		
		teleCalcB = new JButton("Calculate Teleop Points");
		telePointsL = new JLabel("Teleop Points: " + telePoints);
		
		initObj(teleCalcB, 265, 320, 170, 25);
		initObj(telePointsL, 300, 345, 100, 25);
		
		teleCalcB.addActionListener(this);
		
		totalTelePointsL = new JLabel("Total Teleop Points: " + totalTelePoints);
		totalAllPointsL = new JLabel("Total Overall Points: " + totalOverallPoints);
		
		initObj(totalTelePointsL, 275, 395, 150, 25);
		initObj(totalAllPointsL, 160, 425, 150, 25);
	}
	
	private void initClimb() {
		
		climbL = new JLabel("Climb: ");
		
		initObj(climbL, 270, 270, 100, 25);
		
		
		noClimbL = new JLabel("NC");
		lowClimbL = new JLabel("Low");
		midClimbL = new JLabel("Mid");
		highClimbL = new JLabel("High");
		traversalClimbL = new JLabel("Trav");
		
		noClimbC = new JCheckBox();
		lowClimbC = new JCheckBox();
		midClimbC = new JCheckBox();
		highClimbC = new JCheckBox();
		traversalClimbC = new JCheckBox();
		
		initObj(noClimbL, 320, 250, 100, 25);
		initObj(noClimbC, 320, 270, 25, 25);
		
		initObj(lowClimbL, 348, 250, 100, 25);
		initObj(lowClimbC, 350, 270, 25, 25);
		
		initObj(midClimbL, 380, 250, 100, 25);
		initObj(midClimbC, 380, 270, 25, 25);
		
		initObj(highClimbL, 410, 250, 100, 25);
		initObj(highClimbC, 410, 270, 25, 25);
		
		initObj(traversalClimbL, 440, 250, 100, 25);
		initObj(traversalClimbC, 440, 270, 25, 25);
		
		climbPointsL = new JLabel("Climb Points: " + climbPoints);
		
		initObj(climbPointsL, 300, 370, 100, 25);
		
	}
	
	
	
	private void initObj(JComponent obj, int x, int y, int width, int height) {
		
		obj.setVisible(true);
		obj.setBounds(x, y, width, height);
		this.add(obj);
		
	}
	
	private int calcAutoPoints() {
		int points = 0;
		
		int highMade = Integer.valueOf(aHighMadeT.getText());
		
		int lowMade = Integer.valueOf(aLowMadeT.getText());
		
		boolean taxiPoints = taxiC.isSelected();
		
		points += (highMade * 4);
		points += (lowMade * 2);
		if(taxiPoints){points+=2;}
		
		
		return points;
	}
	
	private int[] calcTelePoints() {
		int points[] = {0, 0};
		
		int highMade = Integer.valueOf(tHighMadeT.getText());
		
		int lowMade = Integer.valueOf(tLowMadeT.getText());
		
		points[0] += (highMade * 2);
		
		points[0] += (lowMade);
		
		boolean NC = noClimbC.isSelected();
		boolean LC = lowClimbC.isSelected();
		boolean MC = midClimbC.isSelected();
		boolean HC = highClimbC.isSelected();
		boolean TC = traversalClimbC.isSelected();
		
		boolean[] climbVals = {NC, LC, MC, HC, TC};
		
		boolean wrongInput = checkWrongInput(climbVals);
		
		if(!wrongInput) {
			
			if(LC) {
				points[1] = 4;
			}else if(MC) {
				points[1] = 6;
			}else if(HC) {
				points[1] = 10;
			}else if(TC) {
				points[1] = 15;
			}
			
		}else {
			
			points[1] = -1;
			
		}
		
		return points;
		
	}
	
	private boolean checkWrongInput(boolean[] vals) {
		
		for(int i = 0; i < vals.length; i++) {
			
			for(int k = 0; k < vals.length; k++) {
				if(vals[k] && vals[i] && (k != i)) {
					return true;
				}
			}
			
		}
		
		return false;
	}
	
	public int[] getVals() {
		
		int[] vals = new int[11];
		
		vals[0] = Integer.valueOf(teamNumT.getText());
		vals[1] = taxiC.isSelected() ? 1 : 0;
		
		vals[2] = Integer.valueOf(aLowAttemptsT.getText());
		vals[3] = Integer.valueOf(aLowMadeT.getText());
		
		vals[4] = Integer.valueOf(aHighAttemptsT.getText());
		vals[5] = Integer.valueOf(aHighMadeT.getText());
		
		vals[6] = Integer.valueOf(tLowAttemptsT.getText());
		vals[7] = Integer.valueOf(tLowMadeT.getText());
		
		vals[8] = Integer.valueOf(tHighAttemptsT.getText());
		vals[9] = Integer.valueOf(tHighMadeT.getText());
		
		vals[10] = climbPoints;
		
		return vals;
		
	}
	
	public void displayData(Team team) {
		
		String data = team.toData();
		
		dataL.setText(data);
		
	}
	
	private void autoCalc() {
		
		autoPoints = calcAutoPoints();
		
		autoPointsL.setText("Auto Points: " + autoPoints);
		
		
		totalTelePoints = telePoints + climbPoints;
		
		totalOverallPoints = totalTelePoints + autoPoints;
		
		totalTelePointsL.setText("Total Teleop Points: " + totalTelePoints);
		totalAllPointsL.setText("Total Overall Points: " + totalOverallPoints);
		
	}
	
	private void teleCalc() {
		
		int[] points = calcTelePoints();
		telePoints = points[0];
		climbPoints = points[1];
		
		telePointsL.setText("Teleop Points: " + telePoints);
		if(climbPoints >= 0) {
			climbPointsL.setText("Climb Points: " + climbPoints);
		}else {
			climbPointsL.setText("Input Error");
			climbPoints = 0;
		}
		
		totalTelePoints = telePoints + climbPoints;
		
		totalOverallPoints = totalTelePoints + autoPoints;
		
		totalTelePointsL.setText("Total Teleop Points: " + totalTelePoints);
		totalAllPointsL.setText("Total Overall Points: " + totalOverallPoints);
		
	}
	
	private void calcAll() {
		
		autoCalc();
		teleCalc();
		
	}
	private void formatData() {
		
		if(!formatted) {
			for(int i = 0; i < teams.size(); i++) {
				System.out.println(i);
				if(teams.get(i).getNumber() == teamNum) {
					
					formatted = true;
					
					teams.get(i).addMatch(getVals());
					
					displayData(teams.get(i));
					
					return;
					
				}
				
			}
			
			//if team no exist then create team
			new Team(teamNum);
			
			formatData();
			
		}else {
			formatDataB.setText("Already Formatted");
		}
		
	}
	
	private void clearData() {
		
		teamNumT.setText("0");
		matchNumT.setText("0");
		
		aHighAttemptsT.setText("0");
		aHighMadeT.setText("0");
		
		aLowAttemptsT.setText("0");
		aLowMadeT.setText("0");
		
		taxiC.setSelected(false);
		
		
		tHighAttemptsT.setText("0");
		tHighMadeT.setText("0");
		
		tLowAttemptsT.setText("0");
		tLowMadeT.setText("0");
		
		noClimbC.setSelected(false);
		lowClimbC.setSelected(false);
		midClimbC.setSelected(false);
		highClimbC.setSelected(false);
		traversalClimbC.setSelected(false);
		
		dataL.setText(" ");
		
		formatted = false;
		formatDataB.setText("Format Data");
		
		calcAll();
		
	}
	
	private void pushData() {
		
		
		clearData();
	}
}