import java.util.Random;


public class HighLow {

	public int secretNumber;

	public HighLow() {
	}

	public static int generateRandomNumber() {
		int min = 1, max = 100;
		Random rand = new Random();
		return rand.nextInt((max-min)+1)+min;
	}

	public int readInt() {
		return 1;
	}

	public boolean checkIfEqualToSecretNumber(int a) {
		if(a == secretNumber)
			return true;
		return false;
	}

}
