package pers.zyx.ccf;

import java.io.IOException;
import java.util.Scanner;

//201803-1 ��һ��
public class task16 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int ans = 0;
		int score = 0;// ��¼��һ�ε÷�
		int n = 0;
		while (true) {
			n = sc.nextInt();
			if (n == 1) {
				ans++;
				score = 1;
			} else if (n == 2) {
				if (score == 1 || score == 0) { // 1֮���2�����ǵ�һ����Ծ
					ans += 2;
					score = 2;
				} else { // 2֮����ֵ�2
					score += 2;
					ans += score;
				}
			} else if (n == 0) {
				break;
			}
		}
		System.out.println(ans);
	}

}
