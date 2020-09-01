package problems.SWExpertAcademy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class SW_WS {
	private static int[] moveX = { -2, 2, 0, 0 };
	private static int[] moveY = { 0, 0, -2, 2 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] map = new int[N][M];
			int cnt = N * M;

			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < M; ++j) {
					if (map[i][j] == 1)
						continue;

					for (int k = 0; k < 4; ++k) {
						int a = i + moveX[k];
						int b = j + moveY[k];

						if (a < 0 || b < 0 || a >= N || b >= M || map[a][b] == 1)
							continue;

						map[a][b] = 1;
						--cnt;
					}
				}
			}

			sb.append("#").append(test_case).append(" ").append(cnt).append("\n");

		}
		System.out.println(sb.toString());
	}
}
