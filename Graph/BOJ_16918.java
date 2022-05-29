package Graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16918 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		char[][] a = new char[r][c];
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		Queue<Pair> q = new LinkedList<Pair>();
		for (int i = 0; i < r; i++) {
			a[i] = br.readLine().toCharArray();
		}
		for (int i = 2; i < n + 1; i++) {
			if (i % 2 == 0) {
				for (int x = 0; x < r; x++) {
					for (int y = 0; y < c; y++) {
						if (a[x][y] == 'O')
							q.add(new Pair(x, y));
						if (a[x][y] == '.')
							a[x][y] = 'O';
					}
				}
			} else {
				while (!q.isEmpty()) {
					Pair p = q.remove();
					int x = p.x;
					int y = p.y;
					a[x][y] = '.';
					for (int k = 0; k < 4; k++) {
						int nx = x + dx[k];
						int ny = y + dy[k];
						if ((nx >= 0 && nx < r) && (ny >= 0 && ny < c))
							a[nx][ny] = '.';
					}
				}
			}
		}
		for (int i = 0; i < r; i++) {
			bw.write(a[i]);
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
