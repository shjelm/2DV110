import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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
	
	@Test
	public void shouldGenerateRandomNumber(){
		assertTrue(HighLow.generateRandomNumber() > 0);
	}
	
	@Test
	public void shouldGenerateDifferentRandomNumber(){
		int a = HighLow.generateRandomNumber();
		int b = HighLow.generateRandomNumber();
		assertTrue(a != b);
	}
	
	@Test
	public void shouldGenerateRandomNumberNotHigherThan100(){
		assertTrue(HighLow.generateRandomNumber() <= 100);
	}
	
	@Test
	public void shouldReadIntFromKeyboard(){
		HighLow game = buildGame();
		assertTrue(game.readInt() != null);
	}

	private HighLow buildGame() {
		HighLow hl = new HighLow(9);
		return hl;
	}
}
