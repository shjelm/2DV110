import org.junit.*;

public class FirstTests {

	@Test(expected  = IllegalArgumentException.class)
	public void testA(){
		new TestA(null);
	}
	
}
