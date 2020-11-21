package pers.zyx.Exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

//常用的异常处理方式：
//	(1)String getMessage()
//	(2)printStackTrace()
//	体会：(1)使用try-catch-finally处理编译时异常，使得程序在编译时就不再报错，但是运行时仍可能报错
//      相当于我们使用try-catch-finally将一个编译时可能出现的异常，延迟到运行时出现。
//		(2)开发中，由于运行时异常比较常见，所以我们就不针对运行时异常编写try-catch-finally了，针
//		对编译时异常，我们说一定要考虑异常的处理。
public class test1 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
				File file = new File("hello.txt");
				fis = new FileInputStream(file);
				int data = fis.read();
				while(data!=-1) {
					System.out.print((char)data);
					data = fis.read();
				}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fis!=null)
					fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
}
