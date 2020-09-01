package problems.BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_2468 {
	private static int N;
	private static int[][] map;
	private static boolean[][] visited;
	
	private static int[] moveX = {-1,1,0,0};
	private static int[] moveY = {0,0,-1,1};
	
	private static void DFS(int x, int y, int water) {
		for(int i = 0; i<4; ++i) {
			int a = x + moveX[i];
			int b = y + moveY[i];
			
			if(a<0 || b<0|| a>=N || b>=N)
				continue;
			if(visited[a][b] || map[a][b]-water <= 0)
				continue;
			
			visited[a][b] = true;
			DFS(a,b,water);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		
		int maximum = 0;
		int answer = 0;
		
		for(int i = 0; i<N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maximum = Math.max(maximum, map[i][j]);
			}
		}
		
		for(int water= 0; water<=maximum; ++water) {
			int cnt = 0;
			visited = new boolean[N][N];
			
			for(int i = 0; i<N; ++i) {
				for(int j = 0; j<N; ++j) {
					if(map[i][j]-water > 0 && !visited[i][j]) {
						DFS(i,j,water);
						++cnt;
					}
				}
			}
			
			answer = Math.max(answer,cnt);
		}
		
		System.out.println(answer);
		
	}
}
