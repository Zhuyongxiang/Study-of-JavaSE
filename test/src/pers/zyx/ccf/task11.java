package pers.zyx.ccf;

import java.util.Scanner;

//201912-1 报数
public class task11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int count1 = 0, count2 = 0, count3 = 0, count4 = 0;
		for (int i = 1; i <= n; i++) {
			if (i % 7 == 0 || String.valueOf(i).contains("7")) {
				if (i % 4 == 1) {
					count1++;
				} else if (i % 4 == 2) {
					count2++;
				} else if (i % 4 == 3) {
					count3++;
				} else if (i % 4 == 0) {
					count4++;
				}
				n++;	//每跳过一次都要+1
			}
		}
		System.out.println(count1);
		System.out.println(count2);
		System.out.println(count3);
		System.out.println(count4);
	}
}
