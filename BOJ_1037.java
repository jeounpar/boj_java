import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_1037 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			arr.add(sc.nextInt());
		}
		System.out.println(Collections.max(arr) * Collections.min(arr));
	}
}
