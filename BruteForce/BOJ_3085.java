package BruteForce;

import java.util.Scanner;

public class BOJ_3085 {
	public static int solve(char[][] arr, int n) {
		int ans = 1;
		for (int i = 0; i < n; i++) {
			int cnt = 1;
			for (int j = 0; j < n - 1; j++) {
				if(arr[i][j] == arr[i][j + 1])
					cnt += 1;
				else
					cnt = 1;
				if (cnt > ans)
					ans = cnt;
			}
		}
		for (int j = 0; j < n; j++) {
			int cnt = 1;
			for (int i = 0; i < n - 1; i++) {
				if(arr[i][j] == arr[i + 1][j])
					cnt += 1;
				else
					cnt = 1;
				if (cnt > ans)
					ans = cnt;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[][] arr = new char[n][n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.next().toCharArray();
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j + 1 < n) {
					char tmp = arr[i][j];
					arr[i][j] = arr[i][j + 1];
					arr[i][j + 1] = tmp;
					int solved = solve(arr, n);
					if (solved > ans)
						ans = solved;
					tmp = arr[i][j];
					arr[i][j] = arr[i][j + 1];
					arr[i][j + 1] = tmp;
				}
				if (i + 1 < n) {
					char tmp = arr[i][j];
					arr[i][j] = arr[i + 1][j];
					arr[i + 1][j] = tmp;
					int solved = solve(arr, n);
					if (solved > ans)
						ans = solved;
					tmp = arr[i][j];
					arr[i][j] = arr[i + 1][j];
					arr[i + 1][j] = tmp;
				}
			}
		}
		System.out.println(ans);
	}
}
