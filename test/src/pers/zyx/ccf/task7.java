package pers.zyx.ccf;

import java.util.Scanner;

//201812-1 С����ѧ
public class task7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int red = input.nextInt(); // ��¼�������
		int yellow = input.nextInt();// ��¼�Ƶ�����
		int green = input.nextInt(); // ��¼�̵�����
		int n = input.nextInt(); // �ܹ������ĵ�·�����Ϳ����ĺ��̵���Ŀ
		int ans = 0; // ��¼��ѧ���õ�ʱ��
		int k = 0; // ��¼ÿ�еĵ�һ����
		int t = 0; // ��¼ÿ�еĵڶ�����
		for (int i = 0; i < n; i++) {
			k = input.nextInt();
			t = input.nextInt();
			if (k == 0) { // ����һ�ε�·����ʱ��t
				ans += t;
			} else if (k == 1) { // ��ƣ����ڹ������̵ƣ���ʱ��t
				ans += t;
			} else if (k == 2) { // �Ƶƣ����ڹ����Ǻ�ƣ���ʱ��t�Ӻ�����õ��ʱ��
				ans += (t + red);
			}
		}
		System.out.println(ans);
	}
}
