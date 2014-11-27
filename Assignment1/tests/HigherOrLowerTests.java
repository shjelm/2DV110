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
	public void shouldGenerateRandomNumberInRange(){
		assertTrue(HighLow.generateRandomNumber() > 0 
				&& HighLow.generateRandomNumber() <= 100);
	}
	
	@Test
	public void shouldGenerateDifferentRandomNumber(){
		int a = HighLow.generateRandomNumber();
		int b = HighLow.generateRandomNumber();
		assertTrue(a != b);
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
		game.inRange(x);
		assertEquals(x+1, game.numberOfGuesses);
	}
	
	@Test
	public void testTooManyGuesses(){
		HighLow game = buildGame();
		int x = game.numberOfGuesses;
		for(int i = 0; i < 11; i++){
			game.inRange(x);
		}
		assertFalse(game.canMakeGuess());
	}
	
	@Test
	public void testIfGuessIsTooHigh(){
		HighLow game = buildGame();
		game.secretNumber = 9;
		
		assertTrue(game.checkIfTooHigh(15));
	}

	@Test
	public void testIfInRange(){
		HighLow game = buildGame();
		
		assertFalse(game.inRange(101) 
				&& game.inRange(-5) 
				&& game.inRange(0));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testViewConstuctor(){		
		assertTrue(new HighLowView(null, null).getClass() == HighLowView.class);
	}
	
	@Test
	public void shouldReadInt() throws IOException {
		
		HighLowView view = buildView(23,null);
		assertEquals(23, view.readInt());
	}
	
	@Test
	public void shouldReturnStr() throws IOException {
		
		HighLowView view = buildView(15,"foo");
		assertEquals("foo",view.getStr());		
	}
	
	@Test
	public void runGame() throws IOException{
		HighLow game = mock(HighLow.class);
		
		game.runGame();
		verify(game).runGame();
		
	}
	
	@Test
	public void runGameVerification() throws IOException{
		HighLowView v = buildView(15,null);
		HighLow game = Mockito.spy(new HighLow(v));
		int x = game.readInt();
		game.numberOfGuesses = 8;
		
		game.runGame();
		verify(game, times(2)).checkIfEqualToSecretNumber(x);
		verify(game, times(2)).checkIfTooHigh(x);
		verify(game, times(2)).inRange(x);
		verify(game, times(3)).canMakeGuess();
		verify(game).runGame();
		
	}
	
	@Test
	public void runGameCorrectGuess() throws IOException{
		HighLowView v = buildView(15,null);
		HighLow game = Mockito.spy(new HighLow(v));
		int x = game.readInt();
		game.secretNumber = x;
		
		game.runGame();
		verify(game).checkIfEqualToSecretNumber(x);
		verify(game).inRange(x);
		verify(game).getCorrectStr();
		verify(game).runGame();
		
	}
	
	@Test
	public void makeGuessMultiple() throws IOException{
		HighLowView v = buildView(15,null);
		HighLow game = Mockito.spy(new HighLow(v));
		game.numberOfGuesses = 8;
		
		game.runGame();
		verify(game, times(3)).canMakeGuess();
		
	}
	
	@Test
	public void checkViewUsed() throws IOException{
		HighLowView v = buildView(5,null);
		HighLow game = Mockito.spy(new HighLow(v));
		game.secretNumber= 1;
		
		game.numberOfGuesses = 8;
		
		game.runGame();
		verify(game, times(2)).readInt();
		verify(game, times(2)).getTooHighStr();
	}
	
	@Test
	public void checkHintTooLow() throws IOException{
		HighLow game = buildGameWithView(15,null);
		assertTrue(game.getTooLowStr().equals("Too low!"));
	}
	
	@Test
	public void checkHintTooHgih() throws IOException{
		HighLow game = buildGameWithView(15,null);
		assertTrue(game.getTooHighStr().equals("Too high!"));
	}
	
	@Test
	public void checkNotInRangeStr() throws IOException{
		HighLow game = buildGameWithView(15,null);
		assertTrue(game.getNotInRangeStr().equals("Guess not in range [1-100]"));
	}
	
	@Test
	public void checkCorrectStr() throws IOException{
		HighLow game = buildGameWithView(15,null);
		assertTrue(game.getCorrectStr().equals("Correct!"));
	}
	
	@Test
	public void checkNumberOfGuesses() throws IOException{
		HighLow game = buildGameWithView(15,null);
		int x = 9;
		game.inRange(x);
		assertTrue(game.getNrOfGuesses() == 1);
	}
	
	@Test
	public void checkGuessNotInRange() throws IOException{
		HighLowView v = buildView(115,null);
		HighLow game = Mockito.spy(new HighLow(v));
		
		game.runGame();
		verify(game, times(10)).getNotInRangeStr();
	}
	
	
	/** Privata hjälpmetoder**/
	private HighLow buildGame() {
		HighLow hl = new HighLow();
		return hl;
	}
	
	private HighLowView buildView(int input, String output) throws IOException{
		InputStream in = mock(InputStream.class);
		when(in.read()).thenReturn(input);
		
		PrintStream out = mock(PrintStream.class);
		when(out.toString()).thenReturn(output);
		
		HighLowView v = new HighLowView(in,out);
		
		return v;
	}
	
	private HighLow buildGameWithView(int input, String output) throws IOException {
		
		HighLowView v = buildView(input, output);
		HighLow hl = new HighLow(v);
		return hl;
	}
}
