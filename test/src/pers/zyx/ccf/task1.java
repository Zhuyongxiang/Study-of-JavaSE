package pers.zyx.ccf;

import java.util.*;

//���ִ���������

public class task1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int valNums = input.nextInt();
		int arr[] = new int[10001];
		int maxTimes = 0; // ��¼Ԫ�س��ֵ�������
		int maxtimesVal = 10002; // ��¼���ִ�������Ԫ��
		for (int i = 0; i < valNums; i++) {
			int val = input.nextInt();
			arr[val]++;
			if (arr[val] > maxTimes || (arr[val] == maxTimes) && val < maxtimesVal) {
				/*
				 * ��һ��Ԫ�س��ִ������ڵ�ǰ��Ԫ�ص���������������һ��Ԫ�صĳ��ֵĴ������ڵ�ǰ ��Ԫ�س��ֵ����������Ҹ�Ԫ��С�ڵ�ǰ���ִ�������Ԫ��ʱ���滻
				 */
				maxTimes = arr[val];
				maxtimesVal = val;
			}
		}
		System.out.println(maxtimesVal);
	}
}
