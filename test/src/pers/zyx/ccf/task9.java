package pers.zyx.ccf;

import java.util.Scanner;

//201809-1 Âô²Ë
public class task9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] oldPrice = new int[n];
		int[] newPrice = new int[n];
		for(int i =0;i<n;i++) {
			oldPrice[i] = input.nextInt();
		}
		for(int i = 0;i<n;i++) {
			if(i==0) {
				newPrice[i] = (oldPrice[i]+oldPrice[i+1])/2;
			}else if(i==n-1) {
				newPrice[i] = (oldPrice[i]+oldPrice[i-1])/2;
			}else {
				newPrice[i] = (oldPrice[i-1]+oldPrice[i]+oldPrice[i+1])/3;
			}
			System.out.print(newPrice[i]+" ");
		}
	}

}
