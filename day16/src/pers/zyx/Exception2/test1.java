package pers.zyx.Exception2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			method2();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void method2() throws IOException{
		method1();
	}
	
	public static void method1() throws FileNotFoundException,IOException{
		FileInputStream fis = null;
		File file = new File("hello.txt");
		fis = new FileInputStream(file);
		int data = fis.read();
		while(data!=-1) {
			System.out.print((char)data);
			data = fis.read();
		}
		fis.close();
	}

}
