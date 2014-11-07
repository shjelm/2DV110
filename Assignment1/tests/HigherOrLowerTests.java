import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.*;

public class HigherOrLowerTests {
	
	@Test
	public void testConstructor(){		
		buildGame();
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
		assertTrue(game.readInt() != 0);
	}
	
	@Test
	public void shouldCheckIfEquals(){
		HighLow game = buildGame();
		int a = 9;
		int b = 7;
		assertTrue(!game.checkIfEqual());
	}
	

	private HighLow buildGame() {
		HighLow hl = new HighLow();
		return hl;
	}
}
