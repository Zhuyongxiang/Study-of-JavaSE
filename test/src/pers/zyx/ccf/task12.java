package pers.zyx.ccf;

import java.util.Scanner;

//202006-1 ���Է�����
public class task12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int data1[][] = new int[n][2];
		int data2[][] = new int[n][2];
		int test[][] = new int[m][3];
		String type[] = new String[n];
		int num1, num2, num3;
		int count1 = 0;
		int count2 = 0;
		String lable = "";
		for (int i = 0; i < n; i++) {
			num1 = input.nextInt();
			num2 = input.nextInt();
			lable = input.next();
			if ("A".equals(lable)) {
				data1[count1][0] = num1;
				data1[count1][1] = num2;
				count1++;
			} else {
				data2[count2][0] = num1;
				data2[count2][1] = num2;
				count2++;
			}
		}
		for (int i = 0; i < m; i++) {
			num1 = input.nextInt();
			num2 = input.nextInt();
			num3 = input.nextInt();
			test[i][0] = num1;
			test[i][1] = num2;
			test[i][2] = num3;
		}

		for (int i = 0; i < m; i++) {
			if (test[i][0] + test[i][1] * data1[0][0] + test[i][2] * data1[0][1] <= 0) {
				// A����ΪС�ڵ���0
				int j = 1;
				int k = 0;
				boolean flag = false;
				for (; j < count1; j++) {
					if (test[i][0] + test[i][1] * data1[j][0] + test[i][2] * data1[j][1] <= 0) {
						continue;
					} else {
						System.out.println("No");
						flag = true;
						break;
					}
				}
				//data1������ϣ���Ȼû�д��󣬼����ж�data2
				if (flag == false) {
					for (; k < count2; k++) {
						if (test[i][0] + test[i][1] * data2[k][0] + test[i][2] * data2[k][1] > 0) {
							continue;
						} else {
							System.out.println("No");
							flag=true;
							break;
						}
					}
				}
				if(j>=count1 && k>=count2) {
					System.out.println("Yes");
				}

			} else {
				// A����Ϊ����0
				int j = 1;
				int k = 0;
				boolean flag = false;
				for (; j < count1; j++) {
					if (test[i][0] + test[i][1] * data1[j][0] + test[i][2] * data1[j][1] > 0) {
						continue;
					} else {
						System.out.println("No");
						flag = true;
						break;
					}
				}
				//data1������ϣ���Ȼû�д���,�����ж�data2
				if (flag == false) {
					for (; k < count2; k++) {
						if (test[i][0] + test[i][1] * data2[k][0] + test[i][2] * data2[k][1] <= 0) {
							continue;
						} else {
							System.out.println("No");
							flag=true;
							break;
						}
					}
				}
				if(j>=count1 && k>=count2) {
					System.out.println("Yes");
				}

			}
		}
	}

}
