import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
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

	public int readInt() throws IOException {
//		Scanner scan = new Scanner(in);
//		System.out.println(scan.nextInt());
//		String guess = scan.next();
//		return guess;
		
		return this.in.read();
	}
}
