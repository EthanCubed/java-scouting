
public class Team {

	private int teamNum;
	private int matchesPlayed;
	
	private int autoHighAttempts;
	private int autoHighSuccesses;
	
	private int autoLowAttempts;
	private int autoLowSuccesses;
	
	private int teleHighAttempts;
	private int teleHighSuccesses;
	
	private int teleLowAttempts;
	private int teleLowSuccesses;
	
	private int climbScores;
	
	public Team() {
		
	}
	
	public void addMatch(int[] scores) {
		matchesPlayed++;
		
		
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
	
	public Team findTeam(int number) {
		Team team = new Team();
		
		return team;
	}
	
	public String toString() {
		
		String string = teamNum + ": " + autoHighAttempts + " | " + autoHighSuccesses + " | " +
						autoLowAttempts + " | " + autoLowSuccesses + " | ";
		
		return string;
		
	}
}
