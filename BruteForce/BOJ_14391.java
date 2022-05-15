package BruteForce;

import java.util.Scanner;

public class BOJ_14391 {
	static int[][] a;
	static int n, m, ans = 0;
	static int[][] ok = new int[4][4]; // 가로 -> 0, 세로 -> 1

	static void solve(int index) {
		if (index == n * m) {
			int sum = 0;
			// 가로 종이 조각
			for (int i = 0; i < n; i++) {
				int rowSum = 0;
				for (int j = 0; j < m; j++) {
					if (ok[i][j] != 0) {
						sum += rowSum;
						rowSum = 0;
					} else {
						rowSum = rowSum * 10 + a[i][j];
					}
				}
				sum += rowSum;
			}
			// 세로 종이 조각
			for (int j = 0; j < m; j++) {
				int colSum = 0;
				for (int i = 0; i < n; i++) {
					if (ok[i][j] != 1) {
						sum += colSum;
						colSum = 0;
					}
					else
						colSum = colSum * 10 + a[i][j];
				}
				sum += colSum;
			}
			if (sum > ans) {
				ans = sum;
			}
			return;
		}
		int i = index / m;
		int j = index % m;
		if (ok[i][j] != 1) {
			ok[i][j] = 1;
			solve(index + 1);
			ok[i][j] = 0;
		}
		solve(index+1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new int[n][m];
		for (int i = 0; i < n; i++) {
			String t = sc.next();
			for (int j = 0; j < m; j++) {
				a[i][j] = t.charAt(j) - '0';
			}
		}
		solve(0);
		System.out.println(ans);
	}
}
