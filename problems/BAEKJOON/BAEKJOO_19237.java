package problems.BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BAEKJOO_19237 {
	private int N, M, K, sharkCount;
	private int[] moveX = { 0, -1, 1, 0, 0 }, moveY = { 0, 0, 0, -1, 1 };
	private int[] sharkStates;
	private int[][] sharkPoint, map, area, count;
	List<int[][]> priority;

	private void move() {
		int size = sharkPoint.length;

		for (int i = 0; i < size; ++i) {
			int[] point = sharkPoint[i];
			if (sharkStates[i] == 0)
				continue;

			boolean flag = false;
			int x = point[0];
			int y = point[1];
			int[] dir = priority.get(i)[sharkStates[i]];
			for (int j = 0; j < 4; ++j) {
				int a = x + moveX[dir[j]];
				int b = y + moveY[dir[j]];

				if (a < 0 || b < 0 || a >= N || b >= N)
					continue;
				if (count[a][b] != 0)
					continue;
				
				
				if (map[a][b] != 0 && map[a][b] < map[x][y]) {
					--sharkCount;
					sharkStates[i] = 0;
				} 
				else {
					sharkStates[i] = dir[j];
					
					sharkPoint[i] = new int[] {a,b};
					map[a][b] = map[x][y];
					area[a][b] = map[x][y];
				}
				map[x][y] = (map[x][y] == i + 1) ? 0 : map[x][y];
				
				flag = true;
				break;
			}

			if (flag)
				continue;

			for (int j = 0; j < 4; ++j) {
				int a = x + moveX[dir[j]];
				int b = y + moveY[dir[j]];

				if (a < 0 || b < 0 || a >= N || b >= N)
					continue;
				if (area[a][b] != area[x][y])
					continue;

				sharkStates[i] = dir[j];
				
				sharkPoint[i] = new int[] {a,b};
				map[a][b] = map[x][y];
				map[x][y] = (map[x][y] == i + 1) ? 0 : map[x][y];
				break;
			}
		}
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if(map[i][j] !=0) count[i][j] = K +1;
			}
		}
		
	}

	private void wasteTime() {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (count[i][j] == 0)
					continue;
				area[i][j] = (--count[i][j] == 0) ? 0 : area[i][j];
			}
		}
	}

	private void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		sharkCount = M;
		sharkPoint = new int[M][2];
		map = new int[N][N];
		area = new int[N][N];
		count = new int[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					sharkPoint[map[i][j] - 1] = new int[] { i, j };
					area[i][j] = map[i][j];
					count[i][j] = K;
				}
			}
		}

		sharkStates = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; ++i) {
			sharkStates[i] = Integer.parseInt(st.nextToken());
		}

		priority = new ArrayList<int[][]>();
		for (int i = 0; i < M; ++i) {
			int[][] arr = new int[5][4];
			for (int j = 1; j <= 4; ++j) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 4; ++k) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			priority.add(arr);
		}
		for (int i = 1; i <= 1000; ++i) {
			move();
			
			wasteTime();
			
			if(sharkCount == 1) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);

	}

	public static void main(String[] args) throws Exception {
		new BAEKJOO_19237().solution();
	}
}
