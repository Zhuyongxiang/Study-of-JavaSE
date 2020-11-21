package pers.zyx.ccf;

import java.util.Scanner;

//201812-2 小明放学
public class task8 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int red = input.nextInt(); // 记录红灯设置
		int yellow = input.nextInt();// 记录黄灯设置
		int green = input.nextInt(); // 记录绿灯设置
		int n = input.nextInt(); // 总共经过的道路段数和看到的红绿灯数目
		long sum = 0L;
		for (int i = 0; i < n; i++) {
			int k = input.nextInt();
			int t = input.nextInt();
			if (k == 0) { // 经过一段道路，耗时加t
				sum += t;
			} else if (k == 1) { // 0时刻为红灯
				Long index = ((long)red - (long)t + sum) % (long)(red + yellow + green); // 到达此红绿灯时的红绿灯情况
				sum += resolve(index, (long)red, (long)green, (long)yellow);
			} else if (k == 2) { // 0时刻为黄灯
				Long index = ((long)red + (long)green + (long)yellow - (long)t + sum) % (long)(red + yellow + green);// 到达此红绿灯时的红绿灯情况
				sum += resolve(index, (long)red, (long)green, (long)yellow);
			} else if (k == 3) { // 0时刻为绿灯
				Long index = ((long)red + (long)green - (long)t + sum) % (long)(red + yellow + green);// 到达此红绿灯时的红绿灯情况
				sum += resolve(index, (long)red, (long)green, (long)yellow);
			}
		}
		System.out.println(sum);
	}

	public static Long resolve(Long index, Long red, Long green, Long yellow) {
		if (index < red) { // 到达的时候是红灯
			return red - index;
		} else if (index > red + green - 1) { // 到达的时候是黄灯
			return red + green + yellow - index + red;
		}
		return 0L;
	}
}
