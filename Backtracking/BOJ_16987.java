package Backtracking;

import java.util.Scanner;

public class BOJ_16987 {
	static int[] s = new int[8];
	static int[] w = new int[8];
	static boolean[] broken = new boolean[8]; // false -> 안깨짐, true -> 깨짐
	static int ans = 0;

	static void solve(int index, int br, int n) {
		if (index == n){
			if (br > ans)
				ans = br;
			return;
		}

		if (s[index] <= 0 || br == n - 1) {
			solve(index + 1, br, n);
			return;
		}

		int tmp = br;
		for (int i = 0; i < n; i++) {
			if (i == index)
				continue;
			if (s[i] <= 0)
				continue;
			s[index] -= w[i];
			s[i] -= w[index];
			if (s[index] <= 0)
				br++;
			if (s[i] <= 0)
				br++;
			solve(index+1, br, n);
			br = tmp;
			s[index] += w[i];
			s[i] += w[index];
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			s[i] = x;
			w[i] = y;
		}
		solve(0,0, n);
		System.out.println(ans);
	}
}
