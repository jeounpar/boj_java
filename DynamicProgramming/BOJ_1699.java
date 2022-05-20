package DynamicProgramming;

import java.util.Scanner;

public class BOJ_1699 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] d = new int[n + 1];
		d[1] = 1;
		for (int i = 2; i <= n; i++) {
			int minValue = Integer.MAX_VALUE;
			for (int j = 1; j * j <= i; j++) {
				int t = d[i - j*j];
				if (t < minValue)
					minValue = t;
			}
			d[i] = minValue + 1;
		}
		System.out.println(d[n]);
	}
}
