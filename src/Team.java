import java.text.DecimalFormat;

public class Team {
	
	private int teamNum;
	private int matchesPlayed;
	
	private boolean taxi;
	private double taxiAvg;
	
	private int autoHighAttempts;
	private int autoHighSuccesses;
	private double autoHighAvg;
	
	private int allAutoHighAttempts;
	private int allAutoHighMade;
	private double allAutoHighAvg;
	
	private int autoLowAttempts;
	private int autoLowSuccesses;
	private double autoLowAvg;
	
	private int allAutoLowAttempts;
	private int allAutoLowMade;
	private double allAutoLowAvg;
	
	private int autoPoints;
	private int allAutoPoints;
	private double allAutoPointsAvg;
	
	private int teleHighAttempts;
	private int teleHighSuccesses;
	private double teleHighAvg;
	
	private int allTeleHighAttempts;
	private int allTeleHighMad;
	private double allTeleHighAvg;
	
	private int teleLowAttempts;
	private int teleLowSuccesses;
	private double teleLowAvg;
	
	private int allTeleLowAttempts;
	private int allTeleLowMade;
	private double allTeleLowAvg;
	
	private int climbScore;
	private int climbAvg;
	private String climbAvgString;
	private String bestClimb;
	
	private int telePoints;
	
	public Team(int teamNum) {
		boolean exist = false;
		
		this.teamNum = teamNum;
		
		for(int i = 0; i < Main.teams.size(); i++) {
			if(Main.teams.get(i).getNumber() == teamNum) {
				exist = true;
			}
		}
		if(!exist) {
			Main.teams.add(this);
		}
		
	}
	
	public void addMatch(int[] scores) {
		
		matchesPlayed++;
		
		taxi = (scores[1] == 1);
		
		autoLowAttempts = scores[2];
		autoLowSuccesses = scores[3];
		
		autoHighAttempts = scores[4];
		autoHighSuccesses = scores[5];
		
		teleLowAttempts = scores[6];
		teleLowSuccesses = scores[7];
		
		teleHighAttempts = scores[8];
		teleHighSuccesses = scores[9];
		
		climbScore = scores[10];
		
		teleLowAvg = (teleLowAttempts > 0) ? (teleLowSuccesses * 100) / teleLowAttempts : 0;
		teleHighAvg = (teleHighAttempts > 0) ? (teleHighSuccesses * 100) / teleHighAttempts : 0;
		
		autoLowAvg = (autoLowAttempts > 0) ? (autoLowSuccesses * 100) / autoLowAttempts : 0;
		autoHighAvg = (autoHighAttempts > 0) ? (autoHighSuccesses * 100) / autoHighAttempts : 0;
		
		autoPoints = (taxi) ? 2 : 0;
		autoPoints = (autoHighSuccesses * 4) + (autoLowSuccesses * 2);
		
		telePoints = (teleHighSuccesses * 2) + (teleLowSuccesses);
		
		addToTotals();
		
	}
	
	private void addToTotals() {
		
	}
	
	public int getNumber() {
		return teamNum;
	}
	
	public int getTeleSuccesses(String goal) {
		
		if(goal.equals("h")) {
			return teleHighSuccesses;
		}else if(goal.equals("l")) {
			return teleLowSuccesses;
		}
		
		return 0;
 
	}
	
	public int getAutoSuccesses(String goal) {
		
		if(goal.equals("h")) {
			return autoHighSuccesses;
		}else if(goal.equals("l")) {
			return autoLowSuccesses;
		}
		
		return 0;
	}
	
	public static Team findTeam(int number) {
		Team team = new Team(number);
		
		return team;
	}
	
	public String toData() {
		
		//return String.valueOf(teamNum);
		//2d array time, kms
		String climbLevel = "No Climb";
		
		if(climbScore == 4) {
			climbLevel = "Low Climb";
		}else if(climbScore == 6) {
			climbLevel = "Mid Climb";
		}else if(climbScore == 10) {
			climbLevel = "High Climb";
		}else if(climbScore == 15) {
			climbLevel = "Traversal Climb";
		}
		
		String tab = "---";
		String[][] array = {{"Number", ": ", String.valueOf(teamNum)},
							{"Auto points", ": ", String.valueOf(autoPoints)},
							{tab, "Low Attempts: ", String.valueOf(autoLowAttempts)},
							{tab, "Low Made: ", String.valueOf(autoLowSuccesses)},
							{tab, "Auto Low Goal Average: ", String.valueOf(autoLowAvg), "%"},
							{tab, "High Attempts: ", String.valueOf(autoHighAttempts)},
							{tab, "High Made: ", String.valueOf(autoHighSuccesses)},
							{tab, "Auto High Goal Average: ", String.valueOf(autoHighAvg), "%"},
							{tab, "Taxi: ", String.valueOf(taxi)},
							{"Teleop Points: ", String.valueOf(telePoints)},
							{tab, "Low Attempts: ", String.valueOf(teleLowAttempts)},
							{tab, "Low Made: ", String.valueOf(teleLowSuccesses)},
							{tab, "Teleop Low Average: ", String.valueOf(teleLowAvg), "%"},
							{tab, "High Attempts: ", String.valueOf(teleHighAttempts)},
							{tab, "High Made: ", String.valueOf(teleHighSuccesses)},
							{tab, "Teleop High Average: ", String.valueOf(teleHighAvg), "%"},
							{tab, "Climb: ", climbLevel}
		};
		
		String line1Labels = "Num  | aLowAttempts | aLowMade";
		String line1String = teamNum + " | " + autoLowAttempts + " | " + autoLowSuccesses;
		
		String line2Labels = "aHighAttempts | aHighMade | taxi";
		String line2String = autoHighAttempts + " | " + autoHighSuccesses + " | " + taxi;
		
		String line3Labels = "tLowAttempts | teleLowMade | teleLowAvg";
		String line3String = teleLowAttempts + " | " + teleLowSuccesses + " | " + teleLowAvg;
		
		
		String string = "<html>" + line1Labels + "<BR>" + line1String + "<BR><BR>"
						+ line2Labels + "<BR>" + line2String + "<BR><BR>"
						+ line3Labels + "<BR>" + line3String + "<BR><BR>"
						+ "</html>";
		
		String newString = "<html>";
		for(int i = 0; i < array.length; i++) {
			for(int k = 0; k < array[i].length; k++) {
				newString += array[i][k];
			}
			newString += "<BR>";
		}
		
		newString += "</html>";
		
		return newString;
		
	}
	
	private void pullFromText() {
		//Creates team object from text, use this when initializing
		//to create the array list
		
	}
	
	public String toDataTab() {
		
		String string = teamNum + ": " + autoHighAvg + "% | " + autoLowAvg + "% | " + teleHighAvg + "% | " + teleLowAvg + "% | " + bestClimb + " | " + climbAvg;
		return string;
	}
}
