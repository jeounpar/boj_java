import java.util.Scanner;

public class BOJ_1929 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		boolean[] isPrime = new boolean[n + 1]; // false -> 소수, true ->소수아님
		isPrime[1] = true;
		for (int i = 2; i <= n; i++) {
			if (isPrime[i])
				continue;
			for (int j = 2; i * j <= n; j++) {
				isPrime[i * j] = true;
			}
		}
		for (int i = m; i <= n ; i++) {
			if (!isPrime[i])
				System.out.println(i);
		}
	}
}
