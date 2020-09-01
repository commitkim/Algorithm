package problems.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo_1208 {

	public static void main(String[] args) throws Exception {
		int N = 3;

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[N][N];
		for (int t = 0; t < 10; t++) {
			int test_case = Integer.parseInt(in.readLine());

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = st.nextToken().charAt(0) - '0';
				}
			}
			System.out.println(Arrays.deepToString(arr));

			int y = -1;
			for (int i = 0; i < N; ++i) {
				if (arr[99][i] == 2) {
					y = i;
					break;
				}
			}

			int a = 99;
			int b = y;

			while (a != 0) {
				if (b - 1 >= 0 && arr[a][b - 1] == 1)
					do {
						b -= 1;
					} while (arr[a - 1][b] != 1);

				else if (b + 1 < N && arr[a][b + 1] == 1)
					do {
						b += 1;
					} while (arr[a - 1][b] != 1);

				a -= 1;
			}
			StringBuilder sb = new StringBuilder().append('#').append(test_case).append(' ').append(b);
			System.out.println(sb.toString());
		}
	}
}
