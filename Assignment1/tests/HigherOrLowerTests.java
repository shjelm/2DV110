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
	public void shouldCheckIfEquals(){
		HighLow game = buildGame();
		int a = 9;
		game.secretNumber = 9;
		assertTrue(game.checkIfEqualToSecretNumber(a));
	}
	
	@Test
	public void shouldNotEqual(){
		HighLow gamex = buildGame();
		HighLow gamey = buildGame();
		assertTrue(gamex.secretNumber != gamey.secretNumber);
	}

	private HighLow buildGame() {
		HighLow hl = new HighLow();
		return hl;
	}
}
