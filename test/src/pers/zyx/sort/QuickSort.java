package pers.zyx.sort;

import java.util.Scanner;

public class QuickSort {
	
	//�����ǿ�������
	public static void quickSort(int arr[], int low, int high) {
		if(low>=high) {
			return;
		}
		int i=low;
		int j=high;
		int temp=arr[low];
		int t=0;
		while(i<j) {
			while(arr[j]>=temp && i<j) {
				j--;
			}
			while(arr[i]<=temp && i<j) {
				i++;
			}
			if(i<j) {
				t=arr[j];
				arr[j]=arr[i];
				arr[i]=t;
			}
		}
		arr[low]=arr[i];
		arr[i]=temp;
		quickSort(arr,low,i-1);
		quickSort(arr,i+1,high);
	}
	//�����ǿ�������
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.println("������Ԫ�ظ�����");
		int n=in.nextInt();
		int nums[]=new int[n];
		for(int i=0;i<n;i++) {
			System.out.printf("�������%d�����ݣ�	",i+1);
			nums[i]=in.nextInt();
		}
		System.out.println("����ǰ���������£�");
		for(int i=0;i<n;i++) {
			System.out.print(nums[i]+" ");
		}
		System.out.println();
		quickSort(nums,0,nums.length-1);
		System.out.println("�������������£�");
		for(int i=0;i<n;i++) {
			System.out.print(nums[i]+" ");
		}
	}
	
}
