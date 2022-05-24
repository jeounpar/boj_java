package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11055 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int[] d = new int[n];
		for (int i = 0; i < n; i++) {
			d[i] = a[i];
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i] && d[i] < d[j] + a[i])
					d[i] = d[j] + a[i];
			}
		}
		System.out.println(Arrays.stream(d).max().getAsInt());
	}
}
