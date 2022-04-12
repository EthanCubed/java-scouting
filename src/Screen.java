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
	
	JLabel telePeriod;
	
	JLabel tHighAttemptsL;
	JTextField tHighAttemptsT;
	
	JLabel tHighMadeL;
	JTextField tHighMadeT;
	
	JLabel tLowAttemptsL;
	JTextField tLowAttemptsT;
	
	JLabel tLowMadeL;
	JTextField tLowMadeT;
	
	private double autoPoints = 0;
	public Screen() {
		
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(null);
		
		teamNumL = new JLabel("Team Number:");
		teamNumT = new JTextField("0");
		
		initObj(teamNumL, 165, 25, 125, 25);
		initObj(teamNumT, 255, 25, 70, 25);
		
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
		
		
		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource().equals(autoCalcB)) {
			
			autoPoints = calcAutoPoints();
			
			autoPointsL.setText("Auto Points: " + autoPoints);
		}
	}
	
	
	private void initObj(JComponent obj, int x, int y, int width, int height) {
		
		obj.setVisible(true);
		obj.setBounds(x, y, width, height);
		this.add(obj);
		
	}
	
	private double calcAutoPoints() {
		int points = 0;
		
		int highMade = Integer.valueOf(aHighMadeT.getText());
		
		int lowMade = Integer.valueOf(aLowMadeT.getText());
		
		boolean taxiPoints = taxiC.isSelected();
		
		points += (highMade * 4);
		points += (lowMade * 2);
		if(taxiPoints){points+=2;}
		
		
		return points;
	}
}
