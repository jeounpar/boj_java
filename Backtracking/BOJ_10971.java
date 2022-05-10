package Backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_10971 {
	static int n;
	static int[][] a = new int[10][10];
	static int ans = Integer.MAX_VALUE;

	static void solve(int curr, int start, ArrayList<Integer> visited, boolean[] ok) {
		if (visited.size() == n) {
			if (a[curr][start] == 0)
				return;
			int sum = 0;
			for (int i = 0; i < n - 1; i++) {
				sum += a[visited.get(i)][visited.get(i + 1)];
			}
			sum += a[curr][start];
			if (sum < ans)
				ans = sum;
			return;
		}

		for (int i = 1; i < n; i++) {
			if (ok[i]) continue;
			if (a[curr][i] == 0) continue;
			ok[i] = true;
			visited.add(i);
			solve(i, start, visited, ok);
			ok[i] = false;
			visited.remove(visited.size() - 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		ArrayList<Integer> visited = new ArrayList<>();
		boolean[] ok = new boolean[10];
		ok[0] = true;
		visited.add(0);
		solve(0, 0, visited, ok);

		System.out.println(ans);
	}
}
