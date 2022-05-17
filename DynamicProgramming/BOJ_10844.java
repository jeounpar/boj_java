package DynamicProgramming;

import java.util.Scanner;

public class BOJ_10844 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mod = 1000000000;
		int n = sc.nextInt();
		int[][] d = new int[101][10];

		for (int i = 0; i < 9; i++) {
			d[1][i+1] = 1;
		}
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < 10; j++) {
				d[i][j] = 0;
				if (j - 1 >= 0)
					d[i][j] += d[i - 1][j - 1];
				if (j + 1 <= 9)
					d[i][j] += d[i - 1][j + 1];
				d[i][j] %= mod;
			}
		}
		long ans = 0;
		for (int i = 0; i < 10; i++) {
			ans += d[n][i];
		}
		ans %= mod;
		System.out.println(ans);
	}
}
