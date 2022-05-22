package DynamicProgramming;

import java.util.Scanner;

public class BOJ_11057 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] d = new int[1001][10];
		//d[n][k] = sum(d[n-1][0 <= m < k])
		for (int i = 0; i <= 9; i++) {
			d[1][i] = 1;
		}
		for (int i = 2; i <= 1000; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k <= j; k++) {
					d[i][j] += d[i-1][k] % 10007;
				}
			}
		}
		int ans = 0;
		for (int i = 0; i <= 9; i++) {
			ans += d[n][i];
		}
		System.out.println(ans % 10007);
	}
}
