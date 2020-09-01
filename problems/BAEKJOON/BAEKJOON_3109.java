package problems.BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_3109 {
	private static int R, C, answer;
	private static int[] moveX = { -1, 0, 1 };
	private static int[] moveY = { 1, 1, 1 };
	private static char[][] map;
	private static boolean flag;
	
	private static void DFS(int x, int y) {
		if(flag) return;
		if (y == C - 1) {
			flag = true;
			return;
		}
		
		for (int j = 0; j < 3 && !flag; ++j) {
			int a = x + moveX[j];
			int b = y + moveY[j];

			if (a < 0 || b < 0 || a >= R || b >= C)
				continue;

			if (map[a][b] != '.')
				continue;

			map[a][b] = 'x';
			DFS(a,b);
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		answer = 0;
		for (int i = 0; i < R; ++i) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < C; ++j) {
				map[i][j] = line[j];
			}
		}

		for (int i = 0; i < R; ++i) {
			int x = i;
			int y = 0;
			flag = false;
			DFS(x,y);
			if(flag) ++answer;
			
		}
		System.out.println(answer);
	}
}
