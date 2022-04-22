import java.util.ArrayList;

public class Main {

	public static ArrayList<Team> teams = new ArrayList<Team>();
	public static ArrayList<Match> matches = new ArrayList<Match>();
	
	public static InputScreen inputScreen;
	
	public static DataScreen dataScreen;
	
	public static void main(String[] args) throws InterruptedException {
		
		InputScrn inputScrn = new InputScrn();
		inputScrn.start();
		Thread.sleep(1);
		
		DataScrn dataScrn = new DataScrn();
		dataScrn.start();
		
	}

}

class InputScrn extends Thread{
	
	public void run() {
		Main.inputScreen = new InputScreen();
	}
}
class DataScrn extends Thread{
	
	public void run() {
		Main.dataScreen = new DataScreen();
	}
}
