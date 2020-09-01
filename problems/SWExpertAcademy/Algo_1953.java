package problems.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo_1953 {
	private static int[] moveX = {-1,1,0,0};
	private static int[] moveY = {0,0,-1,1};
	private static int[][] map;
	private static int N,M,answer;
	private static Queue<int[]> q;
	
	private static void check(int[] arr,int x, int y, int cnt) {
		for(int i = 0; i<arr.length; ++i) {
			int a = x + moveX[arr[i]];
			int b = y + moveY[arr[i]];
			
			if(a<0 || b<0 || a>=N || b>=M)
				continue;
			if(map[a][b] == -1 || map[a][b] == 0)
				continue;
			
			switch(arr[i]) {
			case 0: //3,4,7
				if(map[a][b] == 3 || map[a][b] == 4 || map[a][b] == 7)
					continue;
				break;
			case 1:  //3,5,6
				if(map[a][b] == 3 || map[a][b] == 5 || map[a][b] == 6)
					continue;
				break;
			case 2: //2,6,7
				if(map[a][b] == 2 || map[a][b] == 6 || map[a][b] == 7)
					continue;
				break;
			case 3://2,4,5
				if(map[a][b] == 2 || map[a][b] == 4 || map[a][b] == 5)
					continue;
				break;
			}
			
			
			q.offer(new int[] {a,b,cnt+1});
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		for(int test_case = 1; test_case<=T; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			answer = 0;
			q = new LinkedList<int[]>();
			
			map = new int[N][M];
			
			for(int i = 0; i<N; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j<M; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			q.clear();
			q.offer(new int[] {R,C,1});
			

			while(!q.isEmpty() && q.peek()[2] <= L) {
				if(map[q.peek()[0]][q.peek()[1]] == -1) {
					q.poll();
					continue;
				}
					
				int[] point = q.poll();
				int x = point[0];
				int y = point[1];
				int time = point[2];
				
				++answer;

				switch(map[x][y]) {
				case 1:  //0,1,2,3
					check(new int[] {0,1,2,3},x,y,time);
					break;
				case 2: //0,1
					check(new int[] {0,1},x,y,time);
					break;
				case 3: //2,3
					check(new int[] {2,3},x,y,time);
					break;
				case 4: //0,3
					check(new int[] {0,3},x,y,time);
					break;
				case 5: //1,3
					check(new int[] {1,3},x,y,time);
					break;
				case 6: //1,2
					check(new int[] {1,2},x,y,time);
					break;
				case 7: //0,2
					check(new int[] {0,2},x,y,time);
					break;
				}
				
				map[x][y] = -1;
			}
			
			System.out.println("#" + test_case +  " " + answer);
		}
	}
}
