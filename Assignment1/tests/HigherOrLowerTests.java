import static org.junit.Assert.*;

import org.junit.*;

public class HigherOrLowerTests {
	
	@Test
	public void testConstructor(){		
		new HighLow(9);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorWithNegative(){		
		new HighLow(-9);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorWithTooHigh(){		
		new HighLow(101);
	}
	
	

}
