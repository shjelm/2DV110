import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class HighLow {
	
	public int secretNumber;
	public int numberOfGuesses;

	public static void main(String[] args) throws IOException{
		System.out.println("Int: ");
		HighLowView view = new HighLowView(System.in, null);
		System.out.println(Character.getNumericValue(view.readInt()));
	}
	
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

	public void runGame(int i) {
		if(inRange(i)){
			if(checkIfEqualToSecretNumber(i)){
				
			}
			else{
				if(checkIfTooHigh(i)){
					
				}
				else{
					
				}
			}
		}
		
	}

}
