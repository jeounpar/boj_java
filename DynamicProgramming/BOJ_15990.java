package DynamicProgramming;

import java.util.Scanner;

public class BOJ_15990 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		long[][] d = new long[100001][4];
		d[1][1] = 1;
		d[2][2] = 1;
		d[3][3] = 1;
		long mod = 1000000009L;
		for (int i = 1; i <= 100000; i++) {
			if (i - 1 >= 0) {
				d[i][1] = d[i - 1][2] + d[i - 1][3];
				if (i == 1) {
					d[i][1] = 1;
				}
			}
			if (i - 2 >= 0) {
				d[i][2] = d[i - 2][1] + d[i - 2][3];
				if (i == 2) {
					d[i][2] = 1;
				}
			}
			if (i - 3 >= 0) {
				d[i][3] = d[i - 3][1] + d[i - 3][2];
				if (i == 3) {
					d[i][3] = 1;
				}
			}
			d[i][1] %= mod;
			d[i][2] %= mod;
			d[i][3] %= mod;
		}
		while (t-- > 0) {
			int n = sc.nextInt();
			System.out.println((d[n][1] + d[n][2] + d[n][3]) % mod);
		}
	}
}
