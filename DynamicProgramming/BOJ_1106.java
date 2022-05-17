package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_1106 {
	static int[] a = new int[21];
	static int[] d = new int[21];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			a[x] = y;
		}
		for (int i = 1; i <= n; i++) {
			if (d[n] > 0)
				continue;
			for (int j = 1; j <= 20; j++) {
				ArrayList<Integer> tmp = new ArrayList<>();
				if (a[j] > 0) {
					if (i - j >= 0)
						tmp.add(d[i - j] + a[j]);
				}
				Collections.sort(tmp);
				d[i] = tmp.get(0);
			}
		}
		System.out.println(d[n]);
	}
}
