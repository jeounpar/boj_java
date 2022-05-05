package BruteForceRecursion;

import java.util.Scanner;

public class BOJ_15649 {
	static boolean[] ok = new boolean[10];
	static int[] arr = new int[10];
	static StringBuilder sb = new StringBuilder();
	static void solve(int index, int n, int m) {
		if (index == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]);
				if (i + 1 != m)
					sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (ok[i])
				continue;
			ok[i] = true;
			arr[index] = i;
			solve(index+1, n, m);
			ok[i] = false;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		for (int i = 0; i < 9; i++) {
			ok[i] = false;
		}
		solve(0, n, m);
		System.out.print(sb);
	}
}
