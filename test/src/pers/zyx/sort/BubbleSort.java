package pers.zyx.sort;
import java.util.*;

public class BubbleSort {

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
		
		//������ð������
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
		//������ð������
		
		System.out.println("�������������£�");
		for(int i=0;i<n;i++) {
			System.out.print(nums[i]+" ");
		}
	}

}
