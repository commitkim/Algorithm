package problems.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_M_2105 {
	private static int N, answer;
	private static int[] moveX = { 0, 1, 1, -1, -1 };
	private static int[] moveY = { 0, 1, -1, -1, 1 };
	private static int[][] map;
	private static boolean[] dessert;

	private static void init() {
		for (int i = 0; i < 101; ++i) {
			dessert[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; ++test_case) {
			N = Integer.parseInt(br.readLine());
			answer = -1;
			map = new int[N][N];
			dessert = new boolean[101];
			for (int i = 0; i < N; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if ((i == 0 || i == N - 1) && (j == 0 || j == N - 1))
						continue;

					for (int oneThree = 1; oneThree <= N; ++oneThree) {
						 for (int twoFour = 1; twoFour <= N; ++twoFour) {
							int count = 0;
							int a = i;
							int b = j;
							
							OUTER:
							for (int k = 1; k <= 4; ++k) {
								int size = 0;
								if (k % 2 == 1)
									size = oneThree;
								else
									size = twoFour;

								for (int l = 0; l < size; ++l) {
									a += moveX[k];
									b += moveY[k];

									if (a < 0 || b < 0 || a >= N || b >= N)
										break OUTER;

									if (dessert[map[a][b]])
										break OUTER;
									else {
										dessert[map[a][b]] = true;
										++count;
									}
								}
							}
							init();
							if(count == oneThree*2 + twoFour*2)
								answer = Math.max(answer, count);
						}
					}

				}
			}

			System.out.println("#" + test_case + " " + answer);

		}
	}
}
