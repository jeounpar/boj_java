import java.util.Scanner;

public class BOJ_1476 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int e = sc.nextInt();
		int s = sc.nextInt();
		int m = sc.nextInt();
		int a = 1, b = 1, c = 1, year = 1;
		while (a != e || s != b || c != m) {
			a++;
			b++;
			c++;
			year++;
			if (a > 15)
				a = 1;
			if (b > 28)
				b = 1;
			if (c > 19)
				c = 1;
		}
		System.out.println(year);
	}
}
