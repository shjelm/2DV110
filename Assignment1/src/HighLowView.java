import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;


public class HighLowView {
	InputStream in;
	PrintStream out;

	public HighLowView(InputStream in, PrintStream out){
		if(in == null && out == null){
			throw new IllegalArgumentException();
		}
		this.in = in;
		this.out = out;
	}

	public HighLowView() {
		this.in = System.in;
	}

	public int readInt() throws IOException {
		return this.in.read(); 
	}

	public String getStr() {
		return this.out.toString();
	}
}
