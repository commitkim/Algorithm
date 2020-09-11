package problems.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SW_M_1949 {
	private static int N,K,answer;
	private static int[] moveX = {-1,1,0,0};
	private static int[] moveY = {0,0,-1,1};
	private static int[][] map;
	private static boolean[][] visited;
	private static List<int[]> start;
	
	
	
	private static void DFS(int x, int y, int crash, int cnt) {
//		System.out.println(x + " " + y + " " + cnt);
		for(int i = 0; i<4; ++i) {
			int a  = x + moveX[i];
			int b  = y + moveY[i];
			
			if(a<0 || b<0 || a>=N || b>=N || visited[a][b]) continue;
			
			if(map[a][b] < map[x][y]) {
				visited[a][b] = true;
				DFS(a,b,crash,cnt+1);
				visited[a][b] = false;
			}
			else if(map[a][b] >= map[x][y] && crash == 0) {
				if(map[a][b] - K  <= map[x][y] - 1) {
					int temp = map[a][b];
					map[a][b] = map[x][y] -1;
					visited[a][b] = true;
					DFS(a,b,1,cnt+1);
					visited[a][b] = false;
					map[a][b] = temp;
				}
			}
		}
		answer = Math.max(answer, cnt);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case<=T; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			visited = new boolean[N][N];
			answer = 0;
			int maximum = 0;
			for(int i = 0 ; i<N; ++i ) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(maximum < map[i][j]) {
						start = new ArrayList<>();
						start.add(new int[] {i,j});
						maximum = map[i][j];
					}
					else if(maximum == map[i][j]) {
						start.add(new int[] {i,j});
					}
				}
			}
			
			for(int[] point : start) {
				visited[point[0]][point[1]] = true;
				DFS(point[0],point[1],0,1);
				visited[point[0]][point[1]] = false;
				
			}
			
			System.out.println("#" + test_case + " " + answer);
			
		}
	}
}
