import java.util.Random;


public class HighLow {

	public HighLow(int number) {
		if(number < 0 || number > 100){
			throw new IllegalArgumentException();
		}
	}

	public static int generateRandomNumber() {
		int min = 1, max = 100;
		Random rand = new Random();
		return rand.nextInt((max-min)+1)+min;
	}

	public int readInt() {
		return 1;
	}

}
