package pers.zyx.Exception;


/*
 * finally的使用:
 * 	(1)可选的
 * 	(2)finally中声明的是一定会被执行的代码，即使catch中又出现了异常，try中又return语句，catch中又return语句等
 *	(3)像数据库连接、输入输出流、网络编程Socket等资源，JVM是不能自动回收的，我们需要手动的进行资源的释放。
 *	        此时的资源释放，就需要声明在finally中*/
public class FinallyTest {
	public static void main(String[] args) {
		try {
			int a = 10;
			int b = 0;
			System.out.println(a/b);
		}catch(ArithmeticException e) {
			int[] arr = new int[10];
			System.out.println(arr[10]);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("我好帅啊！");
		}
	}
}
