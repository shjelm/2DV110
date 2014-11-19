import java.util.Random;


public class HighLow {
	
	public int secretNumber;
	public int numberOfGuesses;

	public HighLow() {
		secretNumber = generateRandomNumber();
		numberOfGuesses = 0;
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

	public boolean checkIfTooLow(int i) {
		if(i < secretNumber){
			return true;
		}
		return false;
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

	public String tooLowStr() {
		return "Too low";
	}

}
