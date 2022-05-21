package DynamicProgramming;

import java.util.Scanner;

public class BOJ_2225 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] d = new int[k + 1][n + 1];
		//d[k][n] = 정수 K개를 더해 그합이 N이 되었음
		//d[k][n] = sum(d[k-1][n-i]) + 1 (0 <= i <= n)
		int mod = 1000000000;
		d[0][0] = 1;
		for (int i = 1; i <= k; i++) {
			for (int j = 0; j <= n; j++) {
				for (int q = 0; q <= j; q++) {
					d[i][j] += d[i - 1][j - q];
					d[i][j] = d[i][j] % mod;
				}
			}
		}
		System.out.println(d[k][n]);
	}
}
