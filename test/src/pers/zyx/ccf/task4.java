package pers.zyx.ccf;

import java.util.*;

//201903-1 С�д�

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
		if (n % 2 == 0) { // ż��������
			if ((nums[n / 2 - 1] + nums[n / 2]) % 2 == 0) { // ����֮����2�ı�������λ��������
				zhong = (nums[n / 2 - 1] + nums[n / 2]) / 2;
				if (nums[0] >= nums[n - 1]) {
					System.out.print(nums[0] + " " + (int) zhong + " " + nums[n - 1]);
				} else {
					System.out.print(nums[n - 1] + " " + (int) zhong + " " + nums[0]);
				}
			} else { // ����֮�Ͳ���2�ı��������������뱣��һλС��
				zhong = (double) Math.round((nums[n / 2 - 1] + nums[n / 2] ) / 2.0);
				if (nums[0] >= nums[n - 1]) {
					System.out.print(nums[0] + " " + zhong + " " + nums[n - 1]);
				} else {
					System.out.print(nums[n - 1] + " " + zhong + " " + nums[0]);
				}
			}

		} else { // ����������
			zhong = nums[n / 2];
			if (nums[0] >= nums[n - 1]) {
				System.out.print(nums[0] + " " + (int) zhong + " " + nums[n - 1]);
			} else {
				System.out.print(nums[n - 1] + " " + (int) zhong + " " + nums[0]);
			}
		}
	}

}
