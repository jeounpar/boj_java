package Graph;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1058 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] a = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			a[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < n; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				if (tmp[j] == 'Y') {
					a[i].add(j);
					a[j].add(i);
				}
			}
		}
		int MAX = Integer.MIN_VALUE;
		for (int start = 0; start < n; start++) {
			int cnt = 0;
			int[] friends = new int[n];
			boolean[] visited = new boolean[n];
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(start);
			visited[start] = true;
			while (!q.isEmpty()) {
				int now = q.remove();
				for (int next : a[now]) {
					if (!visited[next]) {
						visited[next] = true;
						q.add(next);
						friends[next] = friends[now] + 1;
					}
				}
			}
			for (int i = 0; i < n; i++) {
				if (friends[i] >= 1 && friends[i] <= 2)
					cnt++;
			}
			if (cnt > MAX)
				MAX = cnt;
		}
		bw.write(MAX + "\n");
		bw.flush();
		bw.close();
	}
}
