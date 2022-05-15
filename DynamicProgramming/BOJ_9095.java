package DynamicProgramming;

import java.util.Scanner;

public class BOJ_9095 {
	static int[] d = new int[11];

	static int solve(int n) {
		if (n <= 3)
			return d[n];
		if (d[n] > 0)
			return d[n];
		d[n] = solve(n - 1) + solve(n - 2) + solve(n - 3);
		return d[n];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		d[1] = 1;
		d[2] = 2;
		d[3] = 4;
		while (t-- > 0) {
			int n = sc.nextInt();
			System.out.println(solve(n));
		}
	}
}
