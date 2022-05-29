package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1697 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int MAX = 100000;
		int n = sc.nextInt();
		int k = sc.nextInt();
		boolean[] visited = new boolean[MAX + 1];
		int[] dist = new int[MAX + 1];
		Queue<Integer> q = new LinkedList<Integer>();
		visited[n] = true;
		q.add(n);
		dist[n] = 0;
		while (!q.isEmpty()) {
			int now = q.remove();
			if (now - 1 >= 0) {
				if (!visited[now - 1]) {
				visited[now - 1] = true;
				q.add(now - 1);
				dist[now - 1] = dist[now] + 1;
				}
			}
			if (now + 1 <= MAX) {
				if (!visited[now + 1]) {
				visited[now + 1] = true;
				q.add(now + 1);
				dist[now + 1] = dist[now] + 1;
				}
			}
			if (now * 2 <= MAX) {
				if (!visited[now * 2]) {
				visited[now * 2] = true;
				q.add(now * 2);
				dist[now * 2] = dist[now] + 1;
				}
			}
		}
		System.out.println(dist[k]);
	}
}
