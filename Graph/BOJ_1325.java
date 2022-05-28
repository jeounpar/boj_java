package Graph;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1325 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] a = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			a[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			a[y].add(x);
		}
		int[] hacking = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			boolean[] visited = new boolean[n + 1];
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(i);
			visited[i] = true;
			while (!q.isEmpty()) {
				int x = q.remove();
				for (int y : a[x]) {
					if (!visited[y]) {
						q.add(y);
						visited[y] = true;
						hacking[i]++;
					}
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < n + 1; i++) {
			max = Math.max(hacking[i], max);
		}
		for (int i = 1; i < n + 1; i++) {
			if (hacking[i] == max) {
				bw.write(i + " ");
			}
		}
		bw.flush();
		bw.close();
	}
}
