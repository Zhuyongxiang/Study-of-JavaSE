package pers.zyx.ccf;

import java.util.Scanner;

//201812-1 小明上学
public class task7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int red = input.nextInt(); // 记录红灯设置
		int yellow = input.nextInt();// 记录黄灯设置
		int green = input.nextInt(); // 记录绿灯设置
		int n = input.nextInt(); // 总共经过的道路段数和看到的红绿灯数目
		int ans = 0; // 记录上学所用的时间
		int k = 0; // 记录每行的第一个数
		int t = 0; // 记录每行的第二个数
		for (int i = 0; i < n; i++) {
			k = input.nextInt();
			t = input.nextInt();
			if (k == 0) { // 经过一段道路，耗时加t
				ans += t;
			} else if (k == 1) { // 红灯，由于过后是绿灯，耗时加t
				ans += t;
			} else if (k == 2) { // 黄灯，由于过后是红灯，耗时加t加红灯设置的最长时间
				ans += (t + red);
			}
		}
		System.out.println(ans);
	}
}
