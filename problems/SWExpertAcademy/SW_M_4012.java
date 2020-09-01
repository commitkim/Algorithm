package problems.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_M_4012 {
	private static int[] selected;
	private static int[][] synergy;
	private static int answer;

	private static void C(int N, int start, int cnt) {
		if (cnt == N / 2) {
			answer = Math.min(run(), answer);
			return;
		}

		for (int i = start; i < N; ++i) {
			selected[cnt] = i;
			C(N, i + 1, cnt + 1);
		}
	}

	private static int run() {
		int A = 0, B = 0;
		int size = selected.length;
		int[] unselected = new int[size];

		int Aidx = 0, Bidx = 0;
		for (int i = 0; i < size * 2; ++i) {
			if (Aidx < size && selected[Aidx] == i) {
				++Aidx;
				continue;
			}
			unselected[Bidx++] = i;
		}

		for (int interval = 1; interval < size; ++interval) {
			for (int i = 0; i < size; ++i) {
				if (i + interval >= size)
					break;
				A += (synergy[selected[i]][selected[i + interval]]) + (synergy[selected[i + interval]][selected[i]]);
				B += (synergy[unselected[i]][unselected[i + interval]])
						+ (synergy[unselected[i + interval]][unselected[i]]);
			}
		}

		return Math.abs(A - B);

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; ++test_case) {
			int N = Integer.parseInt(br.readLine());

			synergy = new int[N][N];
			selected = new int[N / 2];
			answer = Integer.MAX_VALUE;

			for (int i = 0; i < N; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; ++j) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			C(N, 0, 0);

			System.out.println("#" + test_case + " " + answer);
		}
	}
}
