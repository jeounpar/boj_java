package BruteForceRecursion;

import java.util.Scanner;

public class BOJ_18290 {
	public static int n, m, k;
	static int ans = -2147483648;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static void solve(int[][] a, boolean[][] ok, int cnt, int sum) {
		if (cnt == k) {
			if (sum > ans)
				ans = sum;
			return;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(ok[i][j])
					continue;
				boolean t = true;
				for (int k = 0; k < 4; k++) {
					int x = i + dx[k];
					int y = j + dy[k];
					if ((x >= 0 && x < n) && (y >= 0 && y < m)) {
						if (ok[x][y])
							t = false;
					}
				}
				if (t) {
					ok[i][j] = true;
					solve(a, ok, cnt+1, sum+a[i][j]);
					ok[i][j] = false;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		boolean[][] ok = new boolean[n][m];
		int[][] a = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int x = sc.nextInt();
				a[i][j] = x;
			}
		}
		solve(a, ok, 0, 0);
		System.out.println(ans);
	}
}
