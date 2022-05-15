package DynamicProgramming;

import java.util.Scanner;

public class BOJ_11052 {
	static int[] d = new int[1001];
	static int[] a;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		a = new int[n+1];
		for (int i = 0; i < n; i++) {
			a[i + 1] = sc.nextInt();
		}
		d[0] = 0;
		d[1] = a[1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				if (d[i] < d[i - j] + a[j])
					d[i] = d[i - j] + a[j];
			}
		}
		System.out.println(d[n]);
	}
}
