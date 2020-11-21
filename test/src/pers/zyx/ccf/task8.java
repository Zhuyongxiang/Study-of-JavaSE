package pers.zyx.ccf;

import java.util.Scanner;

//201812-2 С����ѧ
public class task8 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int red = input.nextInt(); // ��¼�������
		int yellow = input.nextInt();// ��¼�Ƶ�����
		int green = input.nextInt(); // ��¼�̵�����
		int n = input.nextInt(); // �ܹ������ĵ�·�����Ϳ����ĺ��̵���Ŀ
		long sum = 0L;
		for (int i = 0; i < n; i++) {
			int k = input.nextInt();
			int t = input.nextInt();
			if (k == 0) { // ����һ�ε�·����ʱ��t
				sum += t;
			} else if (k == 1) { // 0ʱ��Ϊ���
				Long index = ((long)red - (long)t + sum) % (long)(red + yellow + green); // ����˺��̵�ʱ�ĺ��̵����
				sum += resolve(index, (long)red, (long)green, (long)yellow);
			} else if (k == 2) { // 0ʱ��Ϊ�Ƶ�
				Long index = ((long)red + (long)green + (long)yellow - (long)t + sum) % (long)(red + yellow + green);// ����˺��̵�ʱ�ĺ��̵����
				sum += resolve(index, (long)red, (long)green, (long)yellow);
			} else if (k == 3) { // 0ʱ��Ϊ�̵�
				Long index = ((long)red + (long)green - (long)t + sum) % (long)(red + yellow + green);// ����˺��̵�ʱ�ĺ��̵����
				sum += resolve(index, (long)red, (long)green, (long)yellow);
			}
		}
		System.out.println(sum);
	}

	public static Long resolve(Long index, Long red, Long green, Long yellow) {
		if (index < red) { // �����ʱ���Ǻ��
			return red - index;
		} else if (index > red + green - 1) { // �����ʱ���ǻƵ�
			return red + green + yellow - index + red;
		}
		return 0L;
	}
}
