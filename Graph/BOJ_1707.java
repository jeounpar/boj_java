package Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_1707 {
	static ArrayList<Integer>[] a;
	static int[] color; // 0 -> 방문 안함, 1 -> A그룹, 2 -> B그룹

	static boolean dfs(int st, int c) {
		color[st] = c;
		for (int x : a[st]) {
			if (color[x] == 0) {
				if (!dfs(x, 3 - c))
					return false;
			} else if (color[x] == color[st])
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			a = new ArrayList[n + 1];
			for (int i = 1; i < n + 1; i++) {
				a[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < m; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				a[x].add(y);
				a[y].add(x);
			}
			color = new int[n + 1];
			boolean ok = true;
			for (int i = 1; i < n + 1; i++) {
				if (color[i] == 0) {
					if (!dfs(i, 1))
						ok = false;
				}
			}
			if (ok)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
