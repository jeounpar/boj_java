package DynamicProgramming;

import java.util.Scanner;

public class BOJ_15988 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		//d[n] = n을 1, 2, 3의 합으로 나타내는 방법
		//d[n] = sum(d[n-1][1] + d[n-2][2] + d[n-3][3]) + 1
		long[] d = new long[1000001];
		d[0] = 1;
		d[1] = 1;
		d[2] = 2;
		int mod = 1000000009;
		for (int i = 3; i < 1000001; i++) {
			d[i] += d[i - 1] % mod;
			d[i] += d[i - 2] % mod;
			d[i] += d[i - 3] % mod;
			d[i] %= mod;
		}
		while (t-- > 0) {
			int n = sc.nextInt();
			System.out.println(d[n]);
		}
	}
}
