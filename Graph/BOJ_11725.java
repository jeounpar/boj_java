package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11725 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer>[] a = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			a[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < n - 1; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			a[x].add(y);
			a[y].add(x);
		}
		boolean[] visited = new boolean[n + 1];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		visited[1] = true;
		int[] parents = new int[n + 1];
		while (!q.isEmpty()) {
			int x = q.remove();
			for (int y : a[x]) {
				if (!visited[y]) {
					parents[y] = x;
					q.add(y);
					visited[y] = true;
				}
			}
		}
		for (int i = 2; i < n + 1; i++) {
			System.out.println(parents[i]);
		}
	}
}
