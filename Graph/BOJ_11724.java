package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11724 {
	static ArrayList<Integer>[] a;
	static boolean[] visited;

	static void dfs(int st) {
		if (visited[st])
			return;
		visited[st] = true;
		for (int x : a[st]) {
			if (!visited[x])
				dfs(x);
		}
	}

	static void bfs(int st) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(st);
		visited[st] = true;
		while (!q.isEmpty()) {
			int x = q.remove();
			for (int y : a[x]) {
				if (!visited[y]) {
					q.add(y);
					visited[y] = true;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		a = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			a[i] = new ArrayList<Integer>();
		}
		visited = new boolean[n + 1];
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			a[x].add(y);
			a[y].add(x);
		}
		int cnt = 0;
		for (int i = 1; i <  n + 1; i++) {
			if (!visited[i]) {
				bfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
