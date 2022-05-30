package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_13549 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int MAX = 200001;
		boolean[] visited = new boolean[MAX];
		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> next_queue = new LinkedList<>();
		queue.add(n);
		visited[n] = true;
		int[] time = new int[MAX];
		while (!queue.isEmpty()) {
			int now = queue.remove();
			if (now * 2 <= MAX) {
				if (!visited[now * 2]) {
					visited[now * 2] = true;
					queue.add(now * 2);
					time[now * 2] = time[now];
				}
			}
			if (now - 1 >= 0) {
				if (!visited[now - 1]) {
					visited[now - 1] = true;
					next_queue.add(now - 1);
					time[now - 1] = time[now] + 1;
				}
			}
			if (now + 1 < MAX) {
				if (!visited[now + 1]) {
					visited[now + 1] = true;
					next_queue.add(now + 1);
					time[now + 1] = time[now] + 1;
				}
			}
			if (queue.isEmpty()) {
				queue = next_queue;
				next_queue = new LinkedList<>();
			}
		}
		System.out.println(time[m]);
	}
}
