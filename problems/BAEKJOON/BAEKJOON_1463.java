package problems.BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BAEKJOON_1463 {
    private static int[][][] arr = new int[101][10][1<<10];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 1; i < 10; ++i)
			arr[1][i][1 << i] = 1;
		int bit = 0;

		for (int i = 2; i <= 100; ++i) {
			for (int j = 0; j <= 9; ++j) {
				for (int k = 0; k < 1 << 10; ++k) {
					bit = k | (1 << j);
					int pre,post;
					if (j == 0) pre = 0;
					else pre = arr[i - 1][j - 1][k];
					if (j == 9) post = 0;
					else post = arr[i - 1][j + 1][k];
					arr[i][j][bit] += (int)((pre + post) % 1000000000);
					arr[i][j][bit] %= 1000000000;
				}
			}
		}

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; ++test_case) {
			int N = Integer.parseInt(br.readLine());
			int answer = 0;
			for (int i = 0; i < 10; i++) {
				answer += (int)((arr[N][i][(1 << 10) - 1]) % 1000000000);
				answer %= 1000000000;
			}
			System.out.println("#" + test_case + " " + answer);
		}
	}
}
