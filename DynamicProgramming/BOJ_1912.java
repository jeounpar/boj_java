package DynamicProgramming;

import java.util.Scanner;

public class BOJ_1912 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int[] d = new int[n];
		// d[i] = a[i]로 끝나는 가장 큰 연속합
		for (int i = 0; i < n; i++) {
			d[i] = a[i];
			if (i == 0) continue;
			if (d[i - 1] + a[i] > d[i])
				d[i] = d[i - 1] + a[i];
		}
		int ans = d[0];
		for (int i = 0; i < n; i++) {
			if (d[i] > ans)
				ans = d[i];
		}
		System.out.println(ans);
	}
}
