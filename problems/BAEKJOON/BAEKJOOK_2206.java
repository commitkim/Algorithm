package problems.BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEKJOOK_2206 {
	private static int N,M,answer;
	private static int[] moveX = {-1,1,0,0};
	private static int[] moveY = {0,0,-1,1};
	private static int[][] map;
	private static int[][][] count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = -1;
		map = new int[N][M];
		count = new int[N][M][2];
		
		for(int i = 0; i<N; ++i) {
			String line = br.readLine();
			
			for(int j = 0; j<M; ++j) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0,0,0,1});
		count[0][0][0] = 1;
		
		while(!q.isEmpty()) {
			int[] arr = q.poll();
			int x = arr[0];
			int y = arr[1];
			int crash = arr[2];
			int cnt = arr[3];
			
			if(x == N-1 && y == M-1) {
				answer = count[x][y][crash];
				break;
			}
			
			for(int i = 0; i<4; ++i) {
				int a = x + moveX[i];
				int b = y + moveY[i];
				
				if(a<0 || b<0 || a>=N || b>=M ) continue;
				
				if(map[a][b] == 1) {
					if(crash == 1) continue;
					
					q.offer(new int[] {a,b,1,cnt+1});
					count[a][b][1] = count[x][y][0] + 1; 
				}
				else if(map[a][b] == 0 && count[a][b][crash] == 0) {
					q.offer(new int[] {a,b,crash,cnt+1});
					count[a][b][crash] = count[x][y][crash] + 1;
				}
			}
			
		}

		System.out.println(answer);
	}
}
