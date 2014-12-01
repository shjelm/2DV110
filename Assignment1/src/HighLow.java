import java.io.IOException;
import java.util.Random;

public class HighLow {
	
	private static final int MAX_GUESSES = 10;
	public int secretNumber;
	public int numberOfGuesses;
	private HighLowView view;
	
	public static void main(String[] args){
		HighLow hg = new HighLow();
		hg.runGame();
	}
	
	public HighLow() {
		secretNumber = generateRandomNumber();
		numberOfGuesses = 0;
		view = new HighLowView();
	}
	
	public HighLow(HighLowView v) {
		secretNumber = generateRandomNumber();
		numberOfGuesses = 0;
		view = v;
	}

	public boolean checkIfEqualToSecretNumber(int a) {
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
		numberOfGuesses++;
		if(i > 100 || i <= 0)
			return false;
		return true;
	}

	public void runGame() {
		while(canMakeGuess()){

			try {
				System.out.println(getInstructionsStr());
				int i;
				i = readInt();

				if(inRange(i)){ 
					if(checkIfEqualToSecretNumber(i)){
						System.out.println(getCorrectStr());
						break;
				}
					else{
						if(checkIfTooHigh(i)){
							System.out.println(getTooHighStr());
						}
						else{
							System.out.println(getTooLowStr());
						}
					}
				}
				else{
		
					System.out.println(getNotInRangeStr());
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public int readInt() throws IOException {
		return view.readInt();
	}

	public String getTooLowStr() {
		return "Too low!";
	}

	public String getTooHighStr() {
		return "Too high!";
	}

	public String getNotInRangeStr() {
		return "Guess not in range [1-100]";
	}

	public String getCorrectStr() {
		return "Correct, after "+numberOfGuesses+" guesses!";
	}

	public boolean canMakeGuess() {
		if(numberOfGuesses < MAX_GUESSES){
			return true;
		}
		return false;
	}

	public int getNrOfGuesses() {
		return numberOfGuesses;
	}

	public String getInstructionsStr() {
		return "Provide an integer between 1 and 100: ";
	}

}
