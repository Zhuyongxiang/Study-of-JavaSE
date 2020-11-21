package pers.zyx.sort;
import java.util.*;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.println("请输入元素个数：");
		int n=in.nextInt();
		int nums[]=new int[n];
		for(int i=0;i<n;i++) {
			System.out.printf("请输入第%d个数据：	",i+1);
			nums[i]=in.nextInt();
		}
		System.out.println("排序前的数据如下：");
		for(int i=0;i<n;i++) {
			System.out.print(nums[i]+" ");
		}
		System.out.println();
		
		//以下是冒泡排序
		int temp=0;
		for(int i=0;i<n;i++) {		
			for(int j=n-1;j>i;j--) {
				if(nums[j]<nums[j-1]) {
					temp=nums[j-1];
					nums[j-1]=nums[j];
					nums[j]=temp;
				}
			}
		}
		//以上是冒泡排序
		
		System.out.println("排序后的数据如下：");
		for(int i=0;i<n;i++) {
			System.out.print(nums[i]+" ");
		}
	}

}
