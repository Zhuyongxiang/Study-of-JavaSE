package JUnitTest;

import org.junit.Test;

/*
 * Java�е�JUnit��Ԫ����
 * 
 * ���裺
 * 1.ѡ�е�ǰ����--�Ҽ�ѡ��build path -- add libraries -- JUnit 5 --��һ��
 * 2.����Java����е�Ԫ���ԡ�
 * 		��Java���Ҫ�󣺣�1��������public�ġ���2���ṩ�������޲ι�����
 * 3.������������Ԫ���Է�����
 * 		��ʱ�ĵ�Ԫ���Է�����Ȩ����public��û�з���ֵ��û���β�
 * 4.��Ԫ���Է�������Ҫ����ע�⣺@Test,���ڵ�Ԫ�������е��룺import org.junit.Test;
 * 5.�����õ�Ԫ���Է����Ժ󣬾Ϳ����ڷ������ڲ�����صĴ��롣
 * 6.д������Ժ����˫����Ԫ���Է��������Ҽ���run as -- JUnit Test
 * 
 * 
 * ˵����
 * 1.���ִ�н��û���κ��쳣������
 * 2.���ִ�н�������쳣������
 * 
 */
public class JUnitTest {
	
	
	@Test
	public void test1() {
		System.out.println("�����ǵ�һ������...");
	}
	
	@Test
	public void testToString() {
		String s2 = "GGGG";
		System.out.println(s2.toString());
	}
}
