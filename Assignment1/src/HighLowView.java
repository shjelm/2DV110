import java.io.InputStream;
import java.io.PrintStream;


public class HighLowView {
	InputStream in;
	PrintStream out;

	public HighLowView(InputStream in, PrintStream out){
		if(in == null || out == null){
			throw new IllegalArgumentException();
		}
		this.in = in;
		this.out = out;
	}
}
