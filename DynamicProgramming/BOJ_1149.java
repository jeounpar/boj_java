package DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_1149 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] a = new int[n + 1][3];
		int[][] d = new int[n + 1][3];
		for (int i = 1; i <= n; i++) {
			a[i][0] = sc.nextInt();
			a[i][1] = sc.nextInt();
			a[i][2] = sc.nextInt();
		}
		d[1][0] = a[1][0];
		d[1][1] = a[1][1];
		d[1][2] = a[1][2];
		for (int i = 2; i < n + 1; i++) {
			d[i][1] += Math.min(d[i - 1][0], d[i - 1][2]) + a[i][1];
			d[i][0] += Math.min(d[i - 1][1], d[i - 1][2]) + a[i][0];
			d[i][2] += Math.min(d[i - 1][1], d[i - 1][0]) + a[i][2];
		}
		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(d[n][0]);
		ans.add(d[n][1]);
		ans.add(d[n][2]);
		Collections.sort(ans);
		System.out.println(ans.get(0));
 	}
}
