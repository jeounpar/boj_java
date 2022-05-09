package Backtracking;

import java.util.Scanner;

public class BOJ_14712 {
	static int ans = 0;
	static int[][] a;
	static int n;
	static int m;
	static void solve(int row, int col) {
		if (row == n) {
			for (int i = 0; i < n - 1; i++) {
				for (int j = 0; j < m - 1; j++) {
					int t = a[i][j] + a[i+1][j] + a[i][j+1] + a[i+1][j+1];
					if (t == 4)
						return;
				}
			}
			ans++;
			return;
		}
		int nextCol = col + 1;
		int nextRow;
		if (nextCol == m)
			nextCol = 0;
		if (nextCol == 0)
			nextRow = row + 1;
		else
			nextRow = row;
		a[row][col] = 1;
		solve(nextRow, nextCol);
		a[row][col] = 0;
		solve(nextRow, nextCol);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new int[n][m];
		solve(0, 0);
		System.out.println(ans);
	}
}
