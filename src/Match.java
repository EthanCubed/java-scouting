
public class Match {

	private int matchNum = 0;
	private Team[] teams = new Team[6];
	
	private int redScore;
	private int blueScore;
	private boolean winner; //true if red win, false if blue win
	
	public Match(int matchNum, int redScore, int blueScore) {
		
		this.matchNum = matchNum;
		winner = (redScore > blueScore);
		
	}
	
	public String checkWin() {
		
		if(winner) {
			return "Red";
		}else {
			return "Blue";
		}
		
	}
}
