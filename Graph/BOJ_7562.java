package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7562 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int x = sc.nextInt(); int y = sc.nextInt();
			Pair st = new Pair(x, y);
			int a = sc.nextInt(); int b = sc.nextInt();
			Queue<Pair> q = new LinkedList<>();
			int[][] dist = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dist[i][j] = -1;
				}
			}
			q.add(st);
			dist[x][y] = 0;
			int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
			int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
			while (!q.isEmpty()) {
				Pair p = q.remove();
				for (int k = 0; k < 8; k++) {
					int nx = p.x + dx[k];
					int ny = p.y + dy[k];
					if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
						if (dist[nx][ny] == -1) {
							q.add(new Pair(nx, ny));
							dist[nx][ny] = dist[p.x][p.y] + 1;
						}
					}
				}
			}
			System.out.println(dist[a][b]);
		}
	}
}
