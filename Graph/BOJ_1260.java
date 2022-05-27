package Graph;

import java.util.*;

public class BOJ_1260 {
	static ArrayList<Integer>[] a;
	static boolean[] visited;

	static void dfs(int v) {
		if (visited[v])
			return;
		visited[v] = true;
		System.out.print(v + " ");
		for (int x : a[v]) {
			if (!visited[x])
				dfs(x);
		}
	}

	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		visited[v] = true;
		while (!q.isEmpty()) {
			int x = q.remove();
			System.out.print(x + " ");
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
		int v = sc.nextInt();
		a = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			a[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			int q = sc.nextInt();
			int w = sc.nextInt();
			a[q].add(w);
			a[w].add(q);
		}
		for (int i = 1; i < n + 1; i++) {
			Collections.sort(a[i]);
		}
		visited = new boolean[n + 1];
		dfs(v);
		System.out.println();
		visited = new boolean[n + 1];
		bfs(v);
		System.out.println();
	}
}
