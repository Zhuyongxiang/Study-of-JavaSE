package JUnitTest;

import org.junit.Test;

/*
 * Java中的JUnit单元测试
 * 
 * 步骤：
 * 1.选中当前工程--右键选择：build path -- add libraries -- JUnit 5 --下一步
 * 2.创建Java类进行单元测试。
 * 		此Java类的要求：（1）此类是public的。（2）提供公共的无参构造器
 * 3.此类中声明单元测试方法。
 * 		此时的单元测试方法：权限是public，没有返回值，没有形参
 * 4.单元测试方法上需要声明注解：@Test,并在单元测试类中导入：import org.junit.Test;
 * 5.声明好单元测试方法以后，就可以在方法体内测试相关的代码。
 * 6.写完代码以后，左键双击单元测试方法名，右键：run as -- JUnit Test
 * 
 * 
 * 说明：
 * 1.如果执行结果没有任何异常：绿条
 * 2.如果执行结果出现异常：红条
 * 
 */
public class JUnitTest {
	
	
	@Test
	public void test1() {
		System.out.println("这里是第一个测试...");
	}
	
	@Test
	public void testToString() {
		String s2 = "GGGG";
		System.out.println(s2.toString());
	}
}
