package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11722 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int[] d = new int[n];
		for (int i = 0; i < n; i++) {
			d[i] = 1;
			for (int j = 0; j < i; j++) {
				if (a[i] < a[j] && d[i] < d[j] + 1)
					d[i] = d[j] + 1;
			}
		}
		System.out.println(Arrays.stream(d).max().getAsInt());
	}
}
