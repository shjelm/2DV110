import org.junit.*;
import org.mockito.Mock;

public class FirstTests {

	@Test(expected  = IllegalArgumentException.class)
	public void testAWithNull(){
		new TestA(null);
	}
	
	@Test
	public void testAWithNotNull(){
		Object o = new Object();
		new TestA(o);
	}
}
