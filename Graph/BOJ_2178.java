package Graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
	int x;
	int y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_2178 {
	static int[][] a;
	static int n, m;

	static int bfs() {
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		int[][] dist = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(0, 0));
		visited[0][0] = true;
		dist[0][0] = 1;
		while (!q.isEmpty()) {
			Pair p = q.remove();
			int x = p.x;
			int y = p.y;
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if ((nx >= 0 && nx < n) && (ny >= 0 && ny < m)) {
					if (!visited[nx][ny] && a[nx][ny] == 1) {
						q.add(new Pair(nx, ny));
						dist[nx][ny] = dist[x][y] + 1;
						visited[nx][ny] = true;
					}
				}
			}
		}
		return dist[n - 1][m - 1];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] tmp = br.readLine().split(" ");
		n = Integer.parseInt(tmp[0]);
		m = Integer.parseInt(tmp[1]);
		a = new int[n][m];
		for (int i = 0; i < n; i++) {
			char[] t = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				a[i][j] = t[j] - '0';
			}
		}
		int ans = bfs();
		bw.write(ans+ "\n");
		bw.flush();
		bw.close();
	}
}
