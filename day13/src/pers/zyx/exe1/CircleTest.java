package pers.zyx.exe1;

public class CircleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle circle1 =new Circle(2.3);
		Circle circle2 =new Circle(2.3,"white",2.0);
		
		System.out.println("颜色是否相等:"+circle1.getColor().equals(circle2.getColor()));
		
		System.out.println("半径是否相等:"+circle1.equals(circle2));
		
		System.out.println(circle1);
		System.out.println(circle2);
	}

}
