package pers.zyx.Exception;


/*
 * finally��ʹ��:
 * 	(1)��ѡ��
 * 	(2)finally����������һ���ᱻִ�еĴ��룬��ʹcatch���ֳ������쳣��try����return��䣬catch����return����
 *	(3)�����ݿ����ӡ������������������Socket����Դ��JVM�ǲ����Զ����յģ�������Ҫ�ֶ��Ľ�����Դ���ͷš�
 *	        ��ʱ����Դ�ͷţ�����Ҫ������finally��*/
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
			System.out.println("�Һ�˧����");
		}
	}
}
