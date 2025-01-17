package pers.zyx.sort;

import java.util.Scanner;

public class halfSearch {

	// 以下是快速排序
	public static void quickSort(int arr[], int low, int high) {
		if (low >= high) {
			return;
		}
		int i = low;
		int j = high;
		int temp = arr[low];
		int t = 0;
		while (i < j) {
			while (arr[j] >= temp && i < j) {
				j--;
			}
			while (arr[i] <= temp && i < j) {
				i++;
			}
			if (i < j) {
				t = arr[j];
				arr[j] = arr[i];
				arr[i] = t;
			}
		}
		arr[low] = arr[i];
		arr[i] = temp;
		quickSort(arr, low, i - 1);
		quickSort(arr, i + 1, high);
	}
	// 以上是快速排序

	// 以下是折半查找递归实现
	public static int halfsearch(int arr[], int start, int end, int key) {
		int mid = (start + end) / 2;
		if (arr[mid] == key) {
			return mid;
		} else if (arr[mid] > key && mid - 1 >= start) {
			return halfsearch(arr, start, mid - 1, key);
		} else if (arr[mid] < key && mid + 1 <= end) {
			return halfsearch(arr, mid + 1, end, key);
		}
		return -1;
	}
	// 以上是折半查找递归实现

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		System.out.println("请输入元素个数：");
		int n = in.nextInt();
		int nums[] = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.printf("请输入第%d个数据：	", i + 1);
			nums[i] = in.nextInt();
		}
		System.out.println("排序前的数据如下：");
		for (int i = 0; i < n; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		quickSort(nums, 0, nums.length - 1);
		System.out.println("排序后的数据如下：");
		for (int i = 0; i < n; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		System.out.println("请输入要查找的数字：");
		int key = in.nextInt();
		int xiabiao = halfsearch(nums, 0, nums.length - 1, key);
		System.out.printf("要查找的数字的下标为：%d", xiabiao);
	}
}
