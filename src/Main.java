import java.util.ArrayList;

public class Main {

	public static ArrayList<Team> teams = new ArrayList<Team>();
	public static ArrayList<Match> matches = new ArrayList<Match>();
	
	public static InputScreen inputScreen;
	
	public static DataScreen dataScreen;
	
	public static void main(String[] args){
	
		inputScreen = new InputScreen();
		
		dataScreen = new DataScreen();
		
		inputScreen.repaint();
		dataScreen.repaint();
	}
}
