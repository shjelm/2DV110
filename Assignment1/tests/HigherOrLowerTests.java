import static org.junit.Assert.*;

import org.junit.*;

public class HigherOrLowerTests {
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructor(){
		new HighLow(null);
	}

}
