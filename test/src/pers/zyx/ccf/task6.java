package pers.zyx.ccf;

import java.util.*;

//201903-3 �𻵵� RAID5 

public class task6 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt(); // Ӳ����Ŀ
		int s = input.nextInt(); // ������С
		int l = input.nextInt(); // �ִ�Ӳ����Ŀ
		int size = 0; // �ַ�������
		int nums1 = input.nextInt();
		String str = input.nextLine();
		String str1 = str.substring(1);
		size = str1.length() / 8; // ����ÿ��Ԫ��Ϊһ���飬4�ֽڣ���ά���������Ϊ�ַ������ȳ���8
		String data[][] = new String[n][size]; // ����n��size��������ÿһ�������ϵ�����,ȱʡ����Ԫ������Ϊnull
		int k = 0; // ָ��ָ���ַ������ַ�
		for (int i = 0; i < size; i++) { // �Ȱѵ�һ����������ݴ�������
			data[nums1][i] = str1.substring(k, k + 8);
			k += 8;
		}
		for (int j = 1; j < l; j++) { // �ٰ�ʣ��l-1����������ݴ�������
			int hang = input.nextInt();
			str = input.nextLine();
			str1 = str.substring(1);
			k = 0; // ָ��ָ���ַ������ַ�
			for (int i = 0; i < size; i++) {
				data[hang][i] = str1.substring(k, k + 8);
				k += 8;
			}
		}

		int flag[][] = new int[n][size]; // �洢��������(ÿһ��Ϊһ������)���洢�����ݱ�ţ�-1��ʾ�洢����P
		for (int i = 0; i < n; i++) { // ���ҳ�P��λ��
			for (int j = 0; j < size; j++) {
				if (j == (n - i - 1) * s || (j - ((n - i - 1) * s)) % (n * s) == 0) { // P��λ�ã�����ֵΪ-1,P����һ��λ�ã�����ֵΪ1
					for (int r = 0; r < s; r++) {
						flag[i][j] = -1;
						if (i == n - 1) {
							flag[0][j] = 1;
						} else {
							flag[i + 1][j] = 1;
						}
						j++;
					}
				}
			}
		}

		int number = 0;
		int count = 0; // ��¼ÿһ��ѭ����������
		int j = 0; // �к�
		int i = 0; // �к�
		while (j < size) {
			if (flag[i][j] == 1) {
				while (count < n - 1) {
					for (int r = 0; r < s; r++) {
						flag[i][j] = number;
						j++;
						number++;
					}
					j = j - s;
					count++;
					if (count == n - 1) {
						count = 0;
						i = 0;
						j = j + s;
						break;
					} else {
						if (i < n - 1) {
							i++;
						} else if (i == n - 1) {
							i = 0;
						}
					}
				}
			} else {
				i++;
			}
		}

		int m = input.nextInt();
		int bianhao[] = new int[m];
		String ans[] = new String[m];
		for (int w = 0; w < m; w++) {
			bianhao[w] = input.nextInt();
		}
		for (int w = 0; w < m; w++) {
			int a = 0;
			int b = 0;
			int xiabiao[] = findBianhao(bianhao[w], n, size, flag);
			a = xiabiao[0];
			b = xiabiao[1];
			if (a == -1) { // �Ҳ������
				System.out.println("-");
			} else if (data[a][b] != null) { // ���ҵ���Ų��Ҳ���ȱʧ��Ӳ����
				System.out.println(data[a][b]);
			} else if ((data[a][b] == null) && (n - l > 1)) { // ��ȱʧ��Ӳ���ϵ����Ƶ�������
				System.out.println("-");
			} else { // ��ȱʧ��Ӳ���ϵ������Ƶ�����
				StringBuffer jieguo = new StringBuffer();
				char table[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
				int count1=0;
				while (count1 < 8) {// һ��8���ַ���ѭ��8��
					int result = 0;
					for (int d = 0; d < n; d++) {
						if (data[d][b] != null) {
							result = result ^ Toint(data[d][b].charAt(count1), table);
						}
					}
					String str2 = Integer.toHexString(result);
					String str3=xiaoTOda(str2);
					jieguo.append(str3);
					count1++;
				}
				System.out.println(jieguo.toString());
			}

		}
	}

	public static int Toint(char ch, char table[]) {
		int ans = 0;
		for (int i = 0; i < 16; i++) {
			if (table[i] == ch) {
				ans = i;
			}
		}
		return ans;
	}

	public static int[] findBianhao(int bianhao, int n, int size, int flag[][]) {
		int ans[] = { -1, -1 };
		for (int u = 0; u < n; u++) {
			for (int v = 0; v < size; v++) {
				if (flag[u][v] == bianhao) {
					ans[0] = u;
					ans[1] = v;
				}
			}
		}
		return ans;
	}
	
	public static String xiaoTOda(String str) {
		StringBuffer ans = new StringBuffer();
		for(int z=0;z<str.length();z++) {
			if(str.charAt(z)=='a') {
				ans.append("A");
			}
			else if(str.charAt(z)=='b') {
				ans.append("B");
			}
			else if(str.charAt(z)=='c') {
				ans.append("C");
			}
			else if(str.charAt(z)=='d') {
				ans.append("D");
			}
			else if(str.charAt(z)=='e') {
				ans.append("E");
			}
			else if(str.charAt(z)=='f') {
				ans.append("F");
			}
			else {
				ans.append(str.subSequence(z, z+1));
			}
		}
		return ans.toString();
	}
}
