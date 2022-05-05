package BruteForce;

import java.util.Scanner;

public class BOJ_6064 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			boolean ok = false;
			for (int i = x; i < (n*m); i+=m) {
				if (i % n == y) {
					System.out.println(i+1);
					ok = true;
					break;
				}
			}
			if(!ok)
				System.out.println(-1);
		}
	}
}
