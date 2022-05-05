package BruteForce;

import java.util.Scanner;

public class BOJ_1748 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int len = 0;
		long ans = 0;
		for (int start = 1; start <= n; start*=10) {
			len++;
			int end = start*10-1;
			if (end > n)
				end = n;
			ans += (long)(end - start + 1) * len;
		}
		System.out.println(ans);
	}
}
