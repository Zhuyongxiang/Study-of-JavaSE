package pers.zyx.ccf;

import java.util.*;

//201903-1 小中大

public class task4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int nums[] = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = input.nextInt();
		}
		double zhong = 0;
		if (n % 2 == 0) { // 偶数个数字
			if ((nums[n / 2 - 1] + nums[n / 2]) % 2 == 0) { // 两数之和是2的倍数，中位数是整数
				zhong = (nums[n / 2 - 1] + nums[n / 2]) / 2;
				if (nums[0] >= nums[n - 1]) {
					System.out.print(nums[0] + " " + (int) zhong + " " + nums[n - 1]);
				} else {
					System.out.print(nums[n - 1] + " " + (int) zhong + " " + nums[0]);
				}
			} else { // 两数之和不是2的倍数，需四舍五入保留一位小数
				zhong = (double) Math.round((nums[n / 2 - 1] + nums[n / 2] ) / 2.0);
				if (nums[0] >= nums[n - 1]) {
					System.out.print(nums[0] + " " + zhong + " " + nums[n - 1]);
				} else {
					System.out.print(nums[n - 1] + " " + zhong + " " + nums[0]);
				}
			}

		} else { // 奇数个数字
			zhong = nums[n / 2];
			if (nums[0] >= nums[n - 1]) {
				System.out.print(nums[0] + " " + (int) zhong + " " + nums[n - 1]);
			} else {
				System.out.print(nums[n - 1] + " " + (int) zhong + " " + nums[0]);
			}
		}
	}

}
