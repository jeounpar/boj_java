package Backtracking;

import java.io.*;
import java.util.Arrays;

public class BOJ_6443 {
	static int n;
	static char[] vocab, rst, dup;
	static boolean[] ok = new boolean[21];
	static StringBuilder sb = new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static void solve(int index, int size) throws IOException {
		if (index == size) {
			bw.write(rst);
			bw.write("\n");
			return;
		}
		dup[index] = 0;
		for (int i = 0; i < size; i++) {
			if (ok[i]) continue;
			if (dup[index] == vocab[i]) continue;
			dup[index] = vocab[i];
			ok[i] = true;
			rst[index] = vocab[i];
			solve(index+1, size);
			ok[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			vocab = br.readLine().toCharArray();
			rst = new char[vocab.length];
			dup = new char[vocab.length];
			Arrays.sort(vocab);
			solve(0, vocab.length);
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
