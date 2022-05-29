package Graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13913 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static void printAnswer(int n, int k, int[] from) throws IOException {
		if (n != k) {
			printAnswer(n, from[k], from);
		}
		bw.write(k + " ");
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int MAX = 200001;
		int[] dist = new int[MAX];
		boolean[] visited = new boolean[MAX];
		int[] from = new int[MAX];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		visited[n] = true;
		dist[n] = 0;
		while (!q.isEmpty()) {
			int now = q.remove();
			if (now - 1 >= 0) {
				if (!visited[now - 1]) {
					visited[now - 1] = true;
					q.add(now - 1);
					dist[now - 1] = dist[now] + 1;
					from[now - 1] = now;
				}
			}
			if (now + 1 < MAX) {
				if (!visited[now + 1]) {
					visited[now + 1] = true;
					q.add(now + 1);
					dist[now + 1] = dist[now] + 1;
					from[now + 1] = now;
				}
			}
			if (now * 2 < MAX) {
				if (!visited[now * 2]) {
					visited[now * 2] = true;
					q.add(now * 2);
					dist[now * 2] = dist[now] + 1;
					from[now * 2] = now;
				}
			}
		}
		bw.write(dist[k] + "\n");
		printAnswer(n, k, from);
		bw.flush();
		bw.close();
	}
}
