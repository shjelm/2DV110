import static org.junit.Assert.*;

import org.junit.*;

public class HigherOrLowerTests {
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorNull(){
		new HighLow(null);
	}
	
	@Test
	public void testConstructor(){		
		new HighLow(9);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorWithNegative(){		
		new HighLow(-9);
	}

}
