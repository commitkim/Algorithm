package problems.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_M_5648_incomplete {
	private static int[] moveX = { 0, 0, -1, 1 };
	private static int[] moveY = { 1, -1, 0, 0 };
	private static int[][] map;
	private static int N;

	static class Atom {
		int x,y,dir, k;

		Atom() {
		}

		Atom(int x, int y,int dir, int k) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.k = k;
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Atom[] arr = new Atom[1001];
		int idx = 0;

		for (int test_case = 1; test_case <= T; ++test_case) {
			map = new int[4001][4001];
			N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				map[x*2 + 2000][y*2 + 2000] = idx;
				arr[idx++] = new Atom(x*2 + 2000, y*2 + 2000, dir,k);
			}

			int answer = 0;
			int atomCnt = idx;
			
			while(atomCnt!=0) {
				for(int i = 0; i<idx; ++i) {
					if(arr[i].dir == -1)
						continue;
					
					arr[i].x += moveX[arr[i].dir];
					arr[i].y += moveY[arr[i].dir];
					map[arr[i].x][arr[i].y] = i;
					if(arr[i].x < 0 || arr[i].x >= 4000 || arr[i].y < 0 || arr[i].y >= 4000) {
						arr[i].dir = -1;
						--atomCnt;
						continue;
					}
					
					
					if(map[arr[i].x][arr[i].y] != 0 ) {
						answer += (arr[map[arr[i].x][arr[i].y]].k + arr[i].k);
						arr[map[arr[i].x][arr[i].y]].dir = -1;
						arr[i].dir = -1;
						atomCnt -= 2;
					}
					
					map[arr[i].x][arr[i].y] = 0;
				}
			}



			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

}
