package Graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1261 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] st = br.readLine().split(" ");
		int m = Integer.parseInt(st[0]);
		int n = Integer.parseInt(st[1]);
		char[][] a = new char[n][m];
		for (int i = 0; i < n; i++) {
			a[i] = br.readLine().toCharArray();
		}
		Queue<Pair> q = new LinkedList<>();
		Queue<Pair> next_q = new LinkedList<>();
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		q.add(new Pair(0, 0));
		int[][] broken = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				broken[i][j] = -1;
			}
		}
		broken[0][0] = 0;
		while (!q.isEmpty()) {
			Pair p = q.remove();
			for (int k = 0; k < 4; k++) {
				int nx = p.x + dx[k];
				int ny = p.y + dy[k];
				if ((nx >= 0 && nx < n) && (ny >= 0 && ny < m)) {
					if (broken[nx][ny] == -1) {
						if (a[nx][ny] == '0') {
							q.add(new Pair(nx, ny));
							broken[nx][ny] = broken[p.x][p.y];
						} else {
							broken[nx][ny] = broken[p.x][p.y] + 1;
							next_q.add(new Pair(nx, ny));
						}
					}
				}
			}
			if (q.isEmpty()) {
				q = next_q;
				next_q = new LinkedList<>();
			}
		}
		bw.write(broken[n - 1][m - 1] + "\n");
		bw.flush();
		bw.close();
	}
}
