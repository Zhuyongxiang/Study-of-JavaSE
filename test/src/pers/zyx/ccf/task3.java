package pers.zyx.ccf;

import java.util.*;

//最大的矩形

public class task3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int MAX = 0;
		int nums = input.nextInt();
		int arr[] = new int[nums];
		for (int i = 0; i < nums; i++) {
			arr[i] = input.nextInt();
		}
		for (int i = 0; i < nums - 1; i++) {
			for (int j = i; j < nums; j++) {
				if ((j - i + 1) * findMin(i, j, arr) > MAX) {
					MAX = (j - i + 1) * findMin(i, j, arr);
				}
			}
		}
		System.out.println(MAX);
	}
	public static int findMin(int i, int j, int arr[]) {
		int min = arr[i];
		for (int k = i + 1; k <= j; k++) {
			if (arr[k] < min) {
				min = arr[k];
			}
		}
		return min;
	}
}
