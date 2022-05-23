package DynamicProgramming;

import java.util.Scanner;

public class BOJ_1932 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] a = new int[500][500];
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i ; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		int[][] d = new int[500][500];
		d[0][0] = a[0][0];
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j - 1 >= 0) {
					d[i][j] = Math.max(d[i - 1][j], d[i - 1][j - 1]) + a[i][j];
				} else {
					d[i][j] = d[i-1][j] + a[i][j];
				}
			}
		}
		int maxValue = d[n-1][0];
		for (int i = 1; i < n; i++) {
			maxValue = Math.max(maxValue, d[n - 1][i]);
		}
		System.out.println(maxValue);
	}
}
