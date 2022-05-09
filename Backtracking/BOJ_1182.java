package Backtracking;

import java.util.Scanner;

public class BOJ_1182 {
	static int[] a;
	static int n;
	static int s;
	static int ans = 0;

	static void solve(int index, int cnt, int sum, boolean[] ok) {
		if (sum == s && cnt > 0) {
			ans++;
			if (index == n)
				return;
		}
		for (int i = index; i < n; i++) {
			if (ok[i]) continue;
			ok[i] = true;
			sum += a[i];
			solve(i + 1, cnt+1, sum, ok);
			sum -= a[i];
			ok[i] = false;
		}
	}
 	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.nextInt();
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		boolean[] ok = new boolean[n];
		solve(0, 0, 0, ok);
		System.out.println(ans);
	}
}
