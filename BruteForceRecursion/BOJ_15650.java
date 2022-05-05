package BruteForceRecursion;

import java.util.Scanner;

public class BOJ_15650 {
	static boolean[] ok = new boolean[10];
	static int[] a = new int[10];
	static StringBuilder sb = new StringBuilder();
	static void solve(int index, int pre, int n, int m) {
		if (index == m) {
			for (int i = 0; i < m; i++) {
				sb.append(a[i]);
				if (i + 1 != m)
					sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (ok[i] || i < pre)
				continue;
			ok[i] = true;
			a[index] = i;
			solve(index+1, i, n, m);
			ok[i] = false;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		solve(0, 0, n, m);
		System.out.print(sb);
	}
}
