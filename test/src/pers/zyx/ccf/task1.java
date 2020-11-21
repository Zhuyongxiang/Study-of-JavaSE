package pers.zyx.ccf;

import java.util.*;

//出现次数最多的数

public class task1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int valNums = input.nextInt();
		int arr[] = new int[10001];
		int maxTimes = 0; // 记录元素出现的最大次数
		int maxtimesVal = 10002; // 记录出现次数最多的元素
		for (int i = 0; i < valNums; i++) {
			int val = input.nextInt();
			arr[val]++;
			if (arr[val] > maxTimes || (arr[val] == maxTimes) && val < maxtimesVal) {
				/*
				 * 当一个元素出现次数大于当前的元素的最大次数，或者是一个元素的出现的次数等于当前 的元素出现的最大次数并且该元素小于当前出现次数最多的元素时，替换
				 */
				maxTimes = arr[val];
				maxtimesVal = val;
			}
		}
		System.out.println(maxtimesVal);
	}
}
