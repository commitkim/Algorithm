package coding_Test_Contest;

public class KAKAO_Solution04 {
	public int solution(int n, int s, int a, int b, int[][] fares) {
		int[][] map = new int[n + 1][n + 1];

		for (int i = 0; i < fares.length; ++i) {
			int[] temp = fares[i];
			map[temp[0]][temp[1]] = temp[2];
			map[temp[1]][temp[0]] = temp[2];
		}

		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				if(i!=j && map[i][j] == 0) map[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				for (int k = 1; k <= n; ++k) {
					if (map[j][i] == Integer.MAX_VALUE || map[i][k] == Integer.MAX_VALUE) {
						continue;
					}
					int through = map[j][i] + map[i][k];
					int direct = map[j][k];

					if (direct > through) {
						map[j][k] = through;
					}
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= n; ++i) {
			min = Math.min(min, map[s][i] + map[i][a] + map[i][b]);
		}

		return min;
	}

	public static void main(String[] args) {
		int[][] arr = { { 4, 1, 10 }, { 3, 5, 24 }, { 5, 6, 2 }, { 3, 1, 41 }, { 5, 1, 24 }, { 4, 6, 50 }, { 2, 4, 66 },
				{ 2, 3, 22 }, { 1, 6, 25 } };
		int a = new KAKAO_Solution04().solution(6, 4, 6, 2, arr);
		System.out.println(a);
	}
}
