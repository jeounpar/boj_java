package BruteForceRecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10819 {
	static int n;
	static int[] a;
	static ArrayList<Integer> num;
	static boolean[] ok = new boolean[8];
	static int ans = 0;

	static void solve(int index) {
		if (index == n) {
			int sum = absSum();
			if (sum > ans)
				ans = sum;
			return;
		}
		for (int i = 0; i < n; i++) {
			if (ok[i])
				continue;
			ok[i] = true;
			num.add(a[i]);
			solve(index + 1);
			ok[i] = false;
			num.remove(num.size() - 1);
		}
	}

	static int absSum() {
		int sum = 0;
		for (int i = 0; i < n - 1; i++) {
			sum += Math.abs(num.get(i) - num.get(i + 1));
		}
		return sum;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n];
		num = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		solve(0);
		System.out.println(ans);
	}
}
