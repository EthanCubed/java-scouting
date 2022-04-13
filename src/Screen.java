import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Screen extends JFrame implements ActionListener{
	
	JLabel teamNumL;
	JTextField teamNumT;
	
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
	
	private int autoPoints = 0;
	private int telePoints = 0;
	private int climbPoints = 0;
	private int totalTelePoints = 0;
	private int totalOverallPoints = 0;
	private int teamNum = 0;
	
	public Screen() {
		
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(null);
		
		
		//////////Team Number///////////////////////
		teamNumL = new JLabel("Team Number:");
		teamNumT = new JTextField("0");
		
		initObj(teamNumL, 165, 25, 125, 25);
		initObj(teamNumT, 255, 25, 70, 25);
		
		initAutonomous();
		
		initTeleop();
		
		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource().equals(autoCalcB)) {
			
			autoPoints = calcAutoPoints();
			
			autoPointsL.setText("Auto Points: " + autoPoints);
			
			
			totalTelePoints = telePoints + climbPoints;
			
			totalOverallPoints = totalTelePoints + autoPoints;
			
			totalTelePointsL.setText("Total Teleop Points: " + totalTelePoints);
			totalAllPointsL.setText("Total Overall Points: " + totalOverallPoints);
			
		}else if(e.getSource().equals(teleCalcB)) {
			
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
		
		
		tHighAttemptsL = new JLabel("High Attempts: ");
		tHighAttemptsT = new JTextField("0");
		
		initObj(tHighAttemptsL, 270, 100, 100, 25);
		initObj(tHighAttemptsT, 370, 100, 100, 25);
		
		tHighMadeL = new JLabel("High Attempts: ");
		tHighMadeT = new JTextField("0");
		
		initObj(tHighMadeL, 270, 135, 100, 25);
		initObj(tHighMadeT, 370, 135, 100, 25);
		
		
		tLowAttemptsL = new JLabel("Low Attempts: ");
		tLowAttemptsT = new JTextField("0");
		
		initObj(tLowAttemptsL, 270, 185, 100, 25);
		initObj(tLowAttemptsT, 370, 185, 100, 25);
		
		tLowMadeL = new JLabel("Low Attempts: ");
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
	
	private void initOther() { //rename later plz
		
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
			
			System.out.println("Congrats");
			
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
}
