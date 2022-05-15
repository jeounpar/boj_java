package DynamicProgramming;

import java.util.Scanner;

public class BOJ_1463 {
	static int[] d = new int[1000001];
	static int solve(int n) {
		if (n == 1)
			return 0;
		if (d[n] > 0)
			return d[n];
		d[n] = solve(n - 1 ) + 1;
		if (n % 3 == 0) {
			int t = solve(n / 3) + 1;
			if (t < d[n])
				d[n] = t;
		}
		if (n % 2 == 0) {
			int t = solve(n / 2) + 1;
			if (t < d[n])
				d[n] = t;
		}
		return d[n];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(solve(n));
	}
}
