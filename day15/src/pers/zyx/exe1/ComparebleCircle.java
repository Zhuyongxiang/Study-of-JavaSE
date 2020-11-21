package pers.zyx.exe1;

public class ComparebleCircle extends Circle implements CompareObject {

	public ComparebleCircle(double radius) {
		super(radius);
	}
	public int compareTo(Object o) {
		if (this == o) {
			return 0;
		}

		if (o instanceof ComparebleCircle) {
			ComparebleCircle c = (ComparebleCircle) o;
			if (this.getRadius() > c.getRadius()) {
				return 1;
			} else if (this.getRadius() < c.getRadius()) {
				return -1;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
		
		//方式2：将radius封装成Double，利用compareTO方法
	}
}
