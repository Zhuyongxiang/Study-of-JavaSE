package pers.zyx.ccf;
import java.util.*;
//201909-1 小明种苹果
public class task17 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int T = 0, K = 0, P = 0;
		int res = 0;
		int ans = 0;
		int values[][] = new int[n][m + 2];
		for (int i = 0; i < n; i++) {
			res = 0;
			for (int j = 0; j <= m; j++) {
				values[i][j] = sc.nextInt();
				res = res + values[i][j];
			}
			values[i][m + 1] = res;
			T = T + res;
			ans = values[i][0] - res;
			if(ans > P) {
				P = ans;
				K = i+1;
			}
		}
		System.out.println(T + " " + K + " " + P);
	}
}
