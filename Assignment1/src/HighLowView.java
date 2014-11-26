import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.util.Scanner;


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
		Scanner scan = new Scanner(this.in);
		int x = 0;
		if (scan.hasNext()) {
			x = scan.nextInt();
		}
		else{
			x = this.in.read();
		}
		return x;
	}
		

	public String getStr() {
		return this.out.toString();
	}
}
