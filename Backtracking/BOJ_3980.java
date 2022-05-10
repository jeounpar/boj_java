package Backtracking;

import java.io.*;
import java.util.Scanner;

public class BOJ_3980 {
	static int ans;
	static int[][] a;
	static boolean[] ok;
	static void solve(int index, int sum) {
		if (index == 11) {
			if (sum > ans)
				ans = sum;
			return;
		}

		for (int i = 0; i < 11; i++) {
			if (!ok[i] && a[index][i] != 0) {
				ok[i] = true;
				solve(index+1, sum+a[index][i]);
				ok[i] = false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int c = sc.nextInt();
		while (c-- > 0) {
			a = new int[11][11];
			ok = new boolean[11];
			for (int i = 0; i < 11; i++) {
				for (int j = 0; j < 11; j++) {
					a[i][j] = sc.nextInt();
				}
			}
			ans = 0;
			solve(0, 0);
			System.out.println(ans);
		}
	}
}
