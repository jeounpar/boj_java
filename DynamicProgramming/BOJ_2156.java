package DynamicProgramming;

import java.util.Scanner;

public class BOJ_2156 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[10001];
		for (int i = 1; i < n + 1; i++) {
			a[i] = sc.nextInt();
		}
		int[][] d = new int[10001][3];
		// d[i][0] -> 이전 상황과 관계 없이 i번째 포도주를 마시지 않음
		// d[i][1] -> i번째 포도주는 바로 이전 마시지 않았음
		// d[i][2] -> i번째 포도주는 바로 이전 마셨고 이번에 마셨음
		d[1][0] = 0;
		d[1][1] = a[1];
		d[1][2] = a[1];
		for (int i = 2; i <= 10000; i++) {
			d[i][0] = Math.max(d[i-1][2], Math.max(d[i-1][0], d[i-1][1]));
			d[i][1] = d[i-1][0] + a[i];
			d[i][2] = d[i-1][1] + a[i];
		}
		int t = Math.max(d[n][0], d[n][1]);
		int ans = Math.max(d[n][2], t);
		System.out.println(ans);
	}
}
