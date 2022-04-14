
public class Team {

	private int teamNum;
	private int matchesPlayed;
	
	private int autoHighAttempts;
	private int autoHighSuccesses;
	
	private int autoLowAttempts;
	private int autoLowSuccesses;
	
	public Team() {
		
	}
	
	public void addMatch(int[] scores) {
		matchesPlayed++;
		
		
	}
	
	public int getNumber() {
		return teamNum;
	}
	
	public String toString() {
		
		String string = teamNum + ": " + autoHighAttempts + " | " + autoHighSuccesses + " | " +
						autoLowAttempts + " | " + autoLowSuccesses + " | ";
		
		return string;
		
	}
}
