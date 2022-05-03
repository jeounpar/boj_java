import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int[] heights = new int[9];
		for (int i = 0; i < 9; i++) {
			int n = sc.nextInt();
			heights[i] = n;
			sum += n;
		}
		Arrays.sort(heights);
		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - heights[i] - heights[j] == 100) {
					for (int k = 0; k < 9; k++) {
						if (heights[k] != heights[i] && heights[k] != heights[j])
							System.out.println(heights[k]);
					}
					return;
				}
			}
		}
	}
}
