import java.io.IOException;
import java.util.Random;

public class HighLow {
	
	public int secretNumber;
	public int numberOfGuesses;
	private HighLowView view;

//	public static void main(String[] args) throws IOException{
//		System.out.println("Int: ");
//		HighLowView view = new HighLowView(System.in, null);
//		System.out.println(Character.getNumericValue(view.readInt()));
//		HighLow hg = new HighLow();
//		hg.runGame();
		
//	}
	
	public HighLow() {
		secretNumber = generateRandomNumber();
		numberOfGuesses = 0;
		view = new HighLowView(System.in, null);
	}

	public boolean checkIfEqualToSecretNumber(int a) {
		numberOfGuesses++;
		if(a == secretNumber)
			return true;
		return false;
	}

	public static int generateRandomNumber() {
		int min = 1, max = 100;
		Random rand = new Random();
		return rand.nextInt((max-min)+1)+min;
	}

	public boolean checkIfTooHigh(int i) {
		if(i > secretNumber)
			return true;
		return false;
	}

	public boolean inRange(int i) {
		if(i > 100 || i <= 0)
			return false;
		return true;
	}

	public void runGame() throws IOException{
		int i = readInt();
		if(inRange(i)){
			if(checkIfEqualToSecretNumber(i)){
				
			}
			else{
				if(checkIfTooHigh(i)){
					getStr();
				}
				else{
					getStr();
				}
			}
		}

		getStr();
	}

	public int readInt() throws IOException {
		return view.readInt();
		
	}

	public String getStr() {
		return "";
		
	}

}
