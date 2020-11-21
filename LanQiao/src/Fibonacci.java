import java.util.Scanner;
public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans[] = new int[n];
        ans[0] = ans[1] = 1;
        for (int i = 2; i < n; i++) {
            ans[i] = (ans[i - 1] + ans[i - 2]) % 10007;
        }
        System.out.println(ans[n - 1]);
	}

}
