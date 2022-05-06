package BruteForceRecursion;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15654 {
	static int[] nums;
	static int[] a = new int[10];
	static boolean[] ok = new boolean[10];
	static StringBuilder sb = new StringBuilder();

	static void solve(int index, int n, int m) {
		if (index == m) {
			for (int i = 0; i < m; i++) {
				sb.append(a[i]);
				if (i + 1 != m)
					sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < n; i++) {
			if (ok[i]) continue;
			ok[i] = true;
			a[index] = nums[i];
			solve(index+1, n, m);
			ok[i] = false;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		nums = new int[n];
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			nums[i] = x;
		}
		Arrays.sort(nums);
		solve(0, n, m);
		System.out.println(sb);
	}
}
