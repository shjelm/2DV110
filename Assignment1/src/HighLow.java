
public class HighLow {

	public HighLow(Object object) {
		if(object == null || object.equals(Integer.valueOf(-9)))
			throw new IllegalArgumentException();
	}

}
