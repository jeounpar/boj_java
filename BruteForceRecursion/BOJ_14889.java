package BruteForceRecursion;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_14889 {
	static int[][] a;
	static int n;

	static int solve(int index, ArrayList<Integer> first, ArrayList<Integer> second) {
		if (index == n) {
			if (first.size() != n / 2)
				return -1;
			if (second.size() != n / 2)
				return -1;
			int t1 = 0, t2 = 0;
			for (int i = 0; i < n / 2; i++) {
				for (int j = 0; j < n / 2; j++) {
					if (i == j) continue;
					t1 += a[first.get(i)][first.get(j)];
					t2 += a[second.get(i)][second.get(j)];
				}
			}
			int diff = t1 - t2;
			if (diff < 0) diff *= -1;
			return diff;
		}
		if (first.size() > n / 2)
			return -1;
		if (second.size() > n / 2)
			return -1;

		first.add(index);
		int ans = solve(index + 1, first, second);
		first.remove(first.size() - 1);

		second.add(index);
		int t2 = solve(index + 1, first, second);
		if (ans == -1 || (t2 != -1 && ans > t2))
			ans = t2;
		second.remove(second.size() - 1);
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int x = sc.nextInt();
				a[i][j] = x;
			}
		}
		ArrayList<Integer> first = new ArrayList<>();
		ArrayList<Integer> second = new ArrayList<>();
		System.out.println(solve(0, first, second));
	}
}
