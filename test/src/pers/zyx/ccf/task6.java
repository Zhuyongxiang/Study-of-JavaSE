package pers.zyx.ccf;

import java.util.*;

//201903-3 损坏的 RAID5 

public class task6 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt(); // 硬盘数目
		int s = input.nextInt(); // 条带大小
		int l = input.nextInt(); // 现存硬盘数目
		int size = 0; // 字符串长度
		int nums1 = input.nextInt();
		String str = input.nextLine();
		String str1 = str.substring(1);
		size = str1.length() / 8; // 数组每个元素为一个块，4字节，二维数组的列数为字符串长度除以8
		String data[][] = new String[n][size]; // 定义n行size列数组存放每一个磁盘上的内容,缺省磁盘元素内容为null
		int k = 0; // 指针指向字符串首字符
		for (int i = 0; i < size; i++) { // 先把第一行输入的数据存入数组
			data[nums1][i] = str1.substring(k, k + 8);
			k += 8;
		}
		for (int j = 1; j < l; j++) { // 再把剩余l-1行输入的数据存入数组
			int hang = input.nextInt();
			str = input.nextLine();
			str1 = str.substring(1);
			k = 0; // 指针指向字符串首字符
			for (int i = 0; i < size; i++) {
				data[hang][i] = str1.substring(k, k + 8);
				k += 8;
			}
		}

		int flag[][] = new int[n][size]; // 存储各个磁盘(每一行为一个磁盘)所存储的内容编号，-1表示存储的是P
		for (int i = 0; i < n; i++) { // 先找出P的位置
			for (int j = 0; j < size; j++) {
				if (j == (n - i - 1) * s || (j - ((n - i - 1) * s)) % (n * s) == 0) { // P的位置，数组值为-1,P的下一个位置，数组值为1
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
		int count = 0; // 记录每一次循环的条带数
		int j = 0; // 列号
		int i = 0; // 行号
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
			if (a == -1) { // 找不到块号
				System.out.println("-");
			} else if (data[a][b] != null) { // 能找到块号并且不在缺失的硬盘上
				System.out.println(data[a][b]);
			} else if ((data[a][b] == null) && (n - l > 1)) { // 在缺失的硬盘上但是推导不出来
				System.out.println("-");
			} else { // 在缺失的硬盘上但是能推导出来
				StringBuffer jieguo = new StringBuffer();
				char table[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
				int count1=0;
				while (count1 < 8) {// 一共8个字符，循环8次
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
