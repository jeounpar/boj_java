package Backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_6603 {
	static int[] a;
	static boolean[] ok;
	static StringBuilder sb;

	static void solve(int cnt, int pre, int k, ArrayList<Integer> num) {
		if (cnt == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(num.get(i));
				if (i + 1 != k)
					sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < k; i++) {
			if (ok[i]) continue;
			if (a[pre] > a[i]) continue;
			ok[i] = true;
			num.add(a[i]);
			solve(cnt + 1, i, k, num);
			num.remove(num.size() - 1);
			ok[i] = false;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int k = sc.nextInt();
			if (k == 0)
				break;
			a = new int[k];
			sb = new StringBuilder();
			ok = new boolean[k];
			ArrayList<Integer> num = new ArrayList<>();
			for (int i = 0; i < k; i++) {
				a[i] = sc.nextInt();
			}
			solve(0, 0, k, num);
			System.out.println(sb);
		}
	}
}
