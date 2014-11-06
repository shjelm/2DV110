
public class HighLow {

	public HighLow(Object object) {
		if(object == null || object.equals(Integer.valueOf(-9)) 
				|| object.equals(Integer.valueOf(101))){
			throw new IllegalArgumentException();
		}
	}

}
