package problems.BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BEAKJOON_14889 {
	private static int N, answer;
	private static int[] selected;
	private static int[][] S;

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static boolean nextPermutation(int[] selected) {
		int i = N - 1;
		while (i > 0 && selected[i - 1] >= selected[i])
			--i;

		if (i == 0)
			return false;

		int j = N - 1;
		while (selected[i - 1] >= selected[j])
			--j;

		swap(selected, i - 1, j);

		int k = N - 1;
		while (k > i) {
			swap(selected, k--, i++);
		}

		return true;
	}

	private static int check() {
		List<Integer> AList = new ArrayList<>();
		List<Integer> BList = new ArrayList<>();

		int a = 0;
		int b = 0;

		for (int i = 0; i < N; ++i) {
			if (selected[i] == 1)
				AList.add(i);
			else
				BList.add(i);
		}

		for (int i = 0; i < N / 2; ++i) {
			for (int j = i + 1; j < N / 2; ++j) {
				a += (S[AList.get(i)][AList.get(j)] + S[AList.get(j)][AList.get(i)]);
				b += (S[BList.get(i)][BList.get(j)] + S[BList.get(j)][BList.get(i)]);
			}
		}

		return Math.abs(a - b);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		S = new int[N][N];
		answer = Integer.MAX_VALUE;
		selected = new int[N];

		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int idx = N - 1;
		while (idx >= N / 2) {
			selected[idx--] = 1;
		}

		do {
			answer = Math.min(check(), answer);
		} while (nextPermutation(selected));

		System.out.println(+answer);

	}
}

