import static org.junit.Assert.*;

import org.junit.*;

public class HigherOrLowerTests {
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructor(){		
		new HighLow(9);
	}
	
	@Test
	public void testEmptyConstructor(){		
		new HighLow();
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
