package Graph;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2606 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] a = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			a[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			String[] tmp = br.readLine().split(" ");
			int x = Integer.parseInt(tmp[0]);
			int y = Integer.parseInt(tmp[1]);
			a[x].add(y);
			a[y].add(x);
		}
		boolean[] visited = new boolean[n + 1];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		visited[1] = true;
		int cnt = 0;
		while (!q.isEmpty()) {
			int x = q.remove();
			for (int y : a[x]) {
				if (!visited[y]) {
					cnt++;
					visited[y] = true;
					q.add(y);
				}
			}
		}
		System.out.println(cnt);
	}
}
