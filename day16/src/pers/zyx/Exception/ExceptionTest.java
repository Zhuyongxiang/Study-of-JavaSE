package pers.zyx.Exception;



import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class ExceptionTest {
	
	
	//NullPointerException
	@Test
	public void test1() {
		String str = "abc";
		str = null;
		System.out.println(str.charAt(0));
	}
	
	
	//IndexOutOfBoundsException
	@Test
	public void test2() {
		int arr[] = new int[3];
		System.out.println(arr[3]);
	}
	
	//ClassCastException
	@Test
	public void test3() {
		Object obj = new Date();
		String str = (String)obj; 
	}
	
	//NumberFormatException
	@Test
	public void test4() {
		String str = "12a";
		int num = Integer.parseInt(str);
	}
	
	//InputMismatchException
		@Test
		public void test5() {
			Scanner scan = new Scanner(System.in);
			int  score = scan.nextInt();
			//输入一个字符串
			System.out.println(score);
		}
		
	//ArithmeticException
		@Test
		public void test6() {
			int a = 10;
			int b = 0;
			System.out.println(a/b);
		}
		
	//编译时异常：
		
		/*
		 * 
		 * 
		 public void test7() {
			File file = new File("hello.txt");
			FileInputStream fis = new FileInputStream(file);
			
			int data = fis.read();
			while(data!=-1) {
				System.out.println((char)data);
				data = fis.read();
			}
			fis.close();
		}
		 
		 */
		
	
}
