import java.util.ArrayList;

public class Main {

	public static ArrayList<Team> teams = new ArrayList<Team>();
	
	public static InputScreen inputScreen;
	
	public static DataScreen dataScreen;
	
	public static void main(String[] args) {
		
		inputScreen = new InputScreen(teams);
		
		
	}

}
