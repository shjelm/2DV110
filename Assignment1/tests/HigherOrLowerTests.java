import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import javax.swing.text.Highlighter.Highlight;

import org.junit.*;
import org.mockito.Mockito;

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
	
	@Test
	public void testNumberOfGuessesTooMany(){
		HighLow game = buildGame();
		assertTrue(game.numberOfGuesses <= 10);
	}
	
	@Test
	public void testNumberOfGuesses(){
		HighLow game = buildGame();
		int x = game.numberOfGuesses;
		game.checkIfEqualToSecretNumber(x);
		assertEquals(x+1, game.numberOfGuesses);
	}
	
	@Test 
	public void testMainMethod(){
		HighLow hg = Mockito.mock(HighLow.class);
		hg.main(null);
		Mockito.verify(hg).main(null);
	}
	
	@Test 
	public void testMainMethodCalls(){
		HighLow hg = Mockito.mock(HighLow.class);
		hg.main(null);
		Mockito.verify(hg).checkIfEqualToSecretNumber(5);
	}

	private HighLow buildGame() {
		HighLow hl = new HighLow();
		return hl;
	}
}
