package DynamicProgramming;

// boj.kr/11727
import java.util.Scanner;

public class BOJ_11727 {
	static int[] d = new int[1001];

	static int solve(int n) {
		if (n == 1)
			return 1;
		else if (n == 2)
			return 3;
		if (d[n] > 0)
			return d[n];
		d[n] = (solve(n - 1) + solve(n - 2) * 2) % 10007;
		return d[n];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		d[0] = 1;
		d[1] = 1;
		d[2] = 3;
		System.out.println(solve(n));
	}
}
