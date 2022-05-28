package Graph;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_2667 {
	static int n;
	static boolean[] visited;
	public static final int[] dx = {0, 0, 1, -1};
	public static final int[] dy = {1, -1, 0, 0};
	public static void dfs(int[][] a, int[][] group, int x, int y, int cnt) {
		group[x][y] = cnt;
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if (0 <= nx && nx < n && 0 <= ny && ny < n) {
				if (a[nx][ny] == 1 && group[nx][ny] == 0) {
					dfs(a, group, nx, ny, cnt);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n * n];
		int[][] a = new int[n][n];
		for (int i = 0; i < n; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				a[i][j] = tmp[j] - '0';
			}
		}
		int[][] group = new int[n][n];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 1 && group[i][j] == 0) {
					cnt++;
					dfs(a, group, i, j, cnt);
				}
			}
		}
		int[] ans = new int[cnt];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (group[i][j] != 0)
					ans[group[i][j] - 1] += 1;
			}
		}
		Arrays.sort(ans);
		bw.write(cnt + "\n");
		for (int an : ans) {
			bw.write(an + "\n");
		}
		bw.flush();
		bw.close();
	}
}
