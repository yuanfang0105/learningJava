package learnJavaCode;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Dump {
	
	public static void dump(InputStream src, OutputStream dest) throws IOException {
		InputStream input = new BufferedInputStream(src);
		OutputStream output = new BufferedOutputStream(dest);
		
		byte[] data = new byte[1024];
		int length = -1;
		while((length = input.read(data)) != -1) {
			output.write(data, 0, length);
		}
		
		input.close();
		output.close();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			dump(new FileInputStream("./src/learnJavaCode/aaa.jpg"),new FileOutputStream("./src/learnJavaCode/bbb.jpg"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
