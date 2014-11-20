import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;


public class HighLowView {
	InputStream in;
	PrintStream out;
	
	public HighLowView(){
		this.in = System.in;
	}

	public HighLowView(InputStream in, PrintStream out){
		if(in == null && out == null){
			throw new IllegalArgumentException();
		}
		this.in = in;
		this.out = out;
	}

	public int readInt() throws IOException {
		return this.in.read();
	}

	public String getStr() {
		return this.out.toString();
	}
}
