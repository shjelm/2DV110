import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.util.Scanner;

import javax.swing.text.Highlighter.Highlight;

import org.hamcrest.core.IsEqual;
import org.junit.*;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.internal.configuration.injection.scanner.MockScanner;

public class HigherOrLowerTests {
	
	@Test
	public void testConstructor(){		
		HighLow game = buildGame();
		assertTrue(game.getClass() == HighLow.class);
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
		gamex.secretNumber = 4;
		
		HighLow gamey = buildGame();
		gamey.secretNumber = 6;
		
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
	public void testIfGuessIsTooHigh(){
		HighLow game = buildGame();
		game.secretNumber = 9;
		
		assertTrue(game.checkIfTooHigh(15));
	}

	@Test
	public void testIfInRangeHigh(){
		HighLow game = buildGame();
		
		assertFalse(game.inRange(101));
	}
	
	@Test
	public void testIfInRangeLow(){
		HighLow game = buildGame();
		
		assertFalse(game.inRange(-5));
	}
	
	@Test
	public void testIfInRangeZero(){
		HighLow game = buildGame();
		
		assertFalse(game.inRange(0));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testViewConstuctor(){
		HighLowView v = new HighLowView(null, null);
	}
	
	@Test
	public void shouldReadInt() throws IOException {
		InputStream in = mock(InputStream.class);
		when(in.read()).thenReturn(5);
		
		HighLowView view = new HighLowView(in, null);
		assertEquals(5, view.readInt());
	}
	
	@Test
	public void shouldReturnStr() {
		PrintStream out = mock(PrintStream.class);
		when(out.toString()).thenReturn("foo");
		
		HighLowView view = new HighLowView(null, out);
		assertEquals("foo",view.getStr());		
	}
	
	@Test
	public void runGame(){
		HighLow game = mock(HighLow.class);
		
		game.runGame(9);
		verify(game).runGame(9);
		
	}
	
	private HighLow buildGame() {
		HighLow hl = new HighLow();
		return hl;
	}
}
