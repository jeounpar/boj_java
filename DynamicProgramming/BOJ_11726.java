package DynamicProgramming;

import java.util.Scanner;

public class BOJ_11726 {
	static int[] d = new int[1001];

	static int solve(int n) {
		if (n == 1)
			return 1;
		else if (n == 2)
			return 2;
		if (d[n] > 0)
			return d[n];
		d[n] = (solve(n - 1) + solve(n - 2)) % 10007;
		return d[n];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		d[1] = 1;
		d[2] = 2;
		System.out.println(solve(n) % 10007);
	}
}
