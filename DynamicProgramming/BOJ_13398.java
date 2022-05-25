package DynamicProgramming;

import java.util.Scanner;

public class BOJ_13398 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int[] dl = new int[n];
		for (int i = 0; i < n; i++) {
			dl[i] = a[i];
			if (i == 0) continue;
			if (dl[i - 1] + a[i] > dl[i])
				dl[i] = dl[i - 1] + a[i];
		}
		int[] dr = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			dr[i] = a[i];
			if (i == n - 1) continue;
			if (dr[i + 1] + a[i] > dr[i])
				dr[i] = dr[i + 1] + a[i];
		}
		int max = dl[0];
		for (int i = 1; i < n; i++) {
			if (dl[i] > max)
				max = dl[i];
		}
		for (int i = 1; i < n - 1; i++) {
			if (max < dl[i-1] + dr[i+1])
				max = dl[i - 1] + dr[i + 1];
		}
		System.out.println(max);
	}
}
