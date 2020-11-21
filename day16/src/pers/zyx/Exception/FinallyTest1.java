package pers.zyx.Exception;

public class FinallyTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int value = method();
		System.out.println(value);
	}
	
	public static int method() {
		try {
			int arr[] = new int[10];
			System.out.println(arr[10]);
			return 0;
		}catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			return 1;
		}finally {
			System.out.println("我一定会被执行！");
			return 2;
		}
	}

}
