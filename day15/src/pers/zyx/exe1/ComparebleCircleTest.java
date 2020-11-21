package pers.zyx.exe1;

public class ComparebleCircleTest {
	public static void main(String[] args) {
		ComparebleCircle c1 = new ComparebleCircle(3.4);
		ComparebleCircle c2 = new ComparebleCircle(3.6);
		
		int compareValue = c1.compareTo(c2);
		if(compareValue>0) {
			System.out.println("c1对象大！");
		}else if(compareValue<0) {
			System.out.println("c2对象大！");
		}else {
			System.out.println("c1与c2一样大！");
		}
	}
}
