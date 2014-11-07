
public class HighLow {

	public HighLow(int number) {
		if(number < 0 || number > 100){
			throw new IllegalArgumentException();
		}
	}

	public static int generateRandomNumber() {
		return 1;
	}

}
