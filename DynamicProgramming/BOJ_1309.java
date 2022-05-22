package DynamicProgramming;

import java.util.Scanner;

public class BOJ_1309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// d[n][2] = 2 * n 배열에 사자를 배치하는 경우의 수
		int[][] d = new int[100001][3];
		d[1][0] = 1; // 왼쪽에 사자
		d[1][1] = 1; // 오른쪽에 사자
		d[1][2] = 1; // 한 마리도 배치 안함
		for (int i = 2; i <= 100000; i++) {
			d[i][0] = (d[i - 1][1] + d[i - 1][2]) % 9901;
			d[i][1] = (d[i - 1][0] + d[i - 1][2]) % 9901;
			d[i][2] = (d[i - 1][0] + d[i - 1][1] + d[i - 1][2]) % 9901;
		}
		System.out.println((d[n][0] + d[n][1] + d[n][2]) % 9901);
	}
}
