import java.util.Scanner;

public class BOJ_1978 {
	public static int isPrime(int a) {
		if (a < 2)
			return 0;
		for (int i = 2; i * i <= a; i++) {
			if (a % i == 0)
				return 0;
		}
		return 1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			int k = sc.nextInt();
			cnt += isPrime(k);
		}
		System.out.println(cnt);
	}
}
