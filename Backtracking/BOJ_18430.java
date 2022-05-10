package Backtracking;

import java.util.Scanner;

public class BOJ_18430 {
	static int n, m;
	static int[][] a;
	static boolean[][] ok;
	static int ans = 0;

	static void solve(int index, int sum) {
		if (index == n * m) {
			if (sum > ans)
				ans = sum;
			return;
		}
		int x = index / m;
		int y = index % m;
		if (!ok[x][y]) {
			if ((x + 1 < n && y - 1 >= 0) && !ok[x + 1][y] && !ok[x][y - 1]) {
				ok[x][y] = true;
				ok[x + 1][y] = true;
				ok[x][y - 1] = true;
				solve(index + 1, sum + a[x][y] * 2 + a[x + 1][y] + a[x][y - 1]);
				ok[x][y] = false;
				ok[x + 1][y] = false;
				ok[x][y - 1] = false;
			}
			if ((x - 1 >= 0 && y - 1 >= 0) && !ok[x - 1][y] && !ok[x][y - 1]) {
				ok[x][y] = true;
				ok[x - 1][y] = true;
				ok[x][y - 1] = true;
				solve(index + 1, sum + a[x][y] * 2 + a[x - 1][y] + a[x][y - 1]);
				ok[x][y] = false;
				ok[x - 1][y] = false;
				ok[x][y - 1] = false;
			}
			if ((x - 1 >= 0 && y + 1 < m) && !ok[x - 1][y] && !ok[x][y + 1]) {
				ok[x][y] = true;
				ok[x - 1][y] = true;
				ok[x][y + 1] = true;
				solve(index + 1, sum + a[x][y] * 2 + a[x - 1][y] + a[x][y + 1]);
				ok[x][y] = false;
				ok[x - 1][y] = false;
				ok[x][y + 1] = false;
			}
			if ((x + 1 < n && y + 1 < m) && !ok[x][y + 1] && !ok[x + 1][y]) {
				ok[x][y] = true;
				ok[x][y + 1] = true;
				ok[x + 1][y] = true;
				solve(index + 1, sum + a[x][y] * 2 + a[x][y + 1] + a[x + 1][y]);
				ok[x][y] = false;
				ok[x][y + 1] = false;
				ok[x + 1][y] = false;
			}
		}
		solve(index+1,sum);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		ok = new boolean[n][m];
		solve(0, 0);
		System.out.println(ans);
	}
}
