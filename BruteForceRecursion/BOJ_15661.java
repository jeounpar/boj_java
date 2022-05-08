package BruteForceRecursion;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_15661 {
	static int[][] a;

	static int solve(int index, int n, ArrayList<Integer> first, ArrayList<Integer> second) {
		if (index == n) {
			if (first.size() < 1 || first.size() > n)
				return -1;
			if (second.size() < 1 || second.size() > n)
				return -1;
			int t1 = 0, t2 = 0;
			for (int i = 0; i < first.size(); i++) {
				for (int j = 0; j < first.size(); j++) {
					if (i == j) continue;
					t1 += a[first.get(i)][first.get(j)];
				}
			}
			for (int i = 0; i < second.size(); i++) {
				for (int j = 0; j < second.size(); j++) {
					if (i == j) continue;
					t2 += a[second.get(i)][second.get(j)];
				}
			}
			int diff = t1 - t2;
			if (diff < 0) diff = -diff;
			return diff;
		}
		first.add(index);
		int ans = solve(index+1, n, first, second);
		first.remove(first.size() - 1);

		second.add(index);
		int t2 = solve(index + 1, n, first, second);
		if (ans == -1 || (t2 != -1 && t2 < ans))
			ans = t2;
		second.remove(second.size() - 1);
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		a = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				a[i][j] = sc.nextInt();
		ArrayList<Integer> first = new ArrayList<>();
		ArrayList<Integer> second = new ArrayList<>();
		System.out.println(solve(0, n, first, second));
	}
}
