import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_6588 {
	public static final int MAX = 1000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] isPrime = new boolean[MAX + 1];
		ArrayList<Integer> arr = new ArrayList<Integer>();
		isPrime[0] = true;
		isPrime[1] = true;
		for (int i = 2; i * i <= MAX; i++) {
			if (isPrime[i])
				continue;
			arr.add(i);
			for (int j = i + i; j <= MAX; j += i)
				isPrime[j] = true;
		}
		while (true) {
			int t = sc.nextInt();
			if (t == 0)
				break;
			for (int prime : arr) {
				if (!isPrime[t - prime]) {
					System.out.println(t + " = " + prime + " + " + (t - prime));
					break;
				}
			}
		}
	}
}
