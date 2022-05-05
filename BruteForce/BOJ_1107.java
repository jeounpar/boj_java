package BruteForce;

import java.util.Scanner;

public class BOJ_1107 {
	static final int MAX = 1000000;

	static int solve(int c, boolean[] broken) {
		if (c == 0) {
			if (broken[0] == true)
				return 0;
			else
				return 1;
		}
		int len = 0;
		while (c > 0) {
			if (broken[c % 10] == true)
				return 0;
			len++;
			c /= 10;
		}
		return len;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean[] broken = new boolean[10]; // broken -> true
		for (int i = 0; i < 10; i++) {
			broken[i] = false;
		}
		for (int i = 0; i < m; i++) {
			int tmp = sc.nextInt();
			broken[tmp] = true;
		}

		int ans = n - 100; // 정답의 초기값
		if (ans < 0)
			ans *= -1;

		for (int i = 0; i <= MAX; i++) {
			int len = solve(i, broken);
			if (len > 0) {
				int press = i - n;
				if (press < 0)
					press *= -1;
				if (len + press < ans)
					ans = len + press;
			}
		}
		System.out.println(ans);
	}
}
