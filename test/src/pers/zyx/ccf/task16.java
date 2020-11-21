package pers.zyx.ccf;

import java.io.IOException;
import java.util.Scanner;

//201803-1 跳一跳
public class task16 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int ans = 0;
		int score = 0;// 记录上一次得分
		int n = 0;
		while (true) {
			n = sc.nextInt();
			if (n == 1) {
				ans++;
				score = 1;
			} else if (n == 2) {
				if (score == 1 || score == 0) { // 1之后的2或者是第一次跳跃
					ans += 2;
					score = 2;
				} else { // 2之后出现的2
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
