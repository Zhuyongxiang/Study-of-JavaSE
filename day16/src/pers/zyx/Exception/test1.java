package pers.zyx.Exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

//���õ��쳣����ʽ��
//	(1)String getMessage()
//	(2)printStackTrace()
//	��᣺(1)ʹ��try-catch-finally�������ʱ�쳣��ʹ�ó����ڱ���ʱ�Ͳ��ٱ�����������ʱ�Կ��ܱ���
//      �൱������ʹ��try-catch-finally��һ������ʱ���ܳ��ֵ��쳣���ӳٵ�����ʱ���֡�
//		(2)�����У���������ʱ�쳣�Ƚϳ������������ǾͲ��������ʱ�쳣��дtry-catch-finally�ˣ���
//		�Ա���ʱ�쳣������˵һ��Ҫ�����쳣�Ĵ���
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
