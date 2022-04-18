
public class Team {

	private int teamNum;
	private int matchesPlayed;
	
	private boolean taxi;
	private double taxiAvg;
	
	private int autoHighAttempts;
	private int autoHighSuccesses;
	private double autoHighAvg;
	
	private int autoLowAttempts;
	private int autoLowSuccesses;
	private double autoLowAvg;
	
	private int teleHighAttempts;
	private int teleHighSuccesses;
	private double teleHighAcc;
	private double teleHighAvg;
	
	private int teleLowAttempts;
	private int teleLowSuccesses;
	private double teleLowAcc;
	private double teleLowAvg;
	
	private int climbScore;
	
	public Team(int teamNum) {
		
		this.teamNum = teamNum;
		
		Main.teams.add(this);
		
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
		
		if(teleLowAttempts <= 0) {
			teleLowAvg = 0;
		}else {
			teleLowAvg = (teleLowSuccesses / teleLowAttempts);
		}
		
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
	
	public Team findTeam(int number) {
		Team team = new Team(number);
		
		return team;
	}
	
	public String toString() {
		
		//return String.valueOf(teamNum);
		
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
		
		return string;
		
		
	}
	
	private void pullFromText() {
		//Creates team object from text, use this when initializing
		//to create the array list
		
	}
}
