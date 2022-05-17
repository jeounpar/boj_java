package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11053 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] d = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			d[i] = 1;
			int maxValue = 0;
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i]) {
					if (d[j] > maxValue)
						maxValue = d[j];
				}
			}
			d[i] = maxValue + 1;
		}
		Arrays.sort(d);
		System.out.println(d[d.length - 1]);
	}
}
