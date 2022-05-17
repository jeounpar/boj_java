package DynamicProgramming;

import java.util.Scanner;

public class BOJ_2193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] d = new long[91][2];
		d[1][1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < 2; j++) {
				if (j==1)
					d[i][j] += d[i-1][j-1];
				else
					d[i][j] += d[i - 1][j] + d[i - 1][j + 1];
			}
		}
		System.out.println(d[n][0] + d[n][1]);
	}
}
