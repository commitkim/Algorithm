package problems.BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BEAKJOON_19238 {
	int N,M,F;
	int[][] map;
	int[] moveX = {-1,1,0,0}, moveY = {0,0,-1,1};
	
	public int[] drive(int[] start, int endX, int endY) {
		boolean[][] visited = new boolean[N+1][N+1];
		Queue<int[]> q = new LinkedList<int[]>();
		start[3] = 0;
		q.offer(start);
		int[] result = null;
		int min = Integer.MAX_VALUE;
		
		while(!q.isEmpty()) {
			int[] arr = q.poll();
			int x = arr[0];
			int y = arr[1];
			int f = arr[2];
			int cnt = arr[3];
			
			if(f == 0) {
				break;
			}
			
			if(endX == -1) {
				if(map[x][y]>1) {
					if(min<cnt)
						return result;
					if(min == Integer.MAX_VALUE)
						result = arr; 
					
					min = cnt;
					result = (x < result[0])? arr : ((x == result[0])? ((y < result[1])? arr : result) : result);
				}
			}
			else {
				if(x == endX && y == endY) {
					return arr;
				}
			}
			for(int i = 0; i<4; ++i) {
				int a = x + moveX[i];
				int b = y + moveY[i];
				
				if(a<=0 || b<=0 || a>N || b>N) continue;
				if(map[a][b] == 1) continue;
				if(visited[a][b]) continue;
				
				visited[a][b] = true;
				q.offer(new int[] {a,b,f-1,cnt+1});
			}
		}
		
		return result;
	}
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		
		for(int i = 1; i<=N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int startX = Integer.parseInt(st.nextToken());
		int startY = Integer.parseInt(st.nextToken());
		
		int clientNum = 2;
		
		List<int[]> list = new ArrayList<>();
		
		for(int i = 0; i<M; ++i) {
			st = new StringTokenizer(br.readLine());
			
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = clientNum;
			list.add(new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
			++clientNum;
		}
		int[] arr = new int[] {startX,startY,F,0};
		for(int i = 0; i<M; ++i) {
			arr = drive(arr,-1,-1);  //손님 찾기
			
			if(arr == null) {
				System.out.println(-1);
				return;
			}
			
			int idx = map[arr[0]][arr[1]];
			map[arr[0]][arr[1]] = 0;
			
			arr = drive(arr,list.get(idx-2)[0],list.get(idx-2)[1]);  // 데려다주기
			
			if(arr == null) {
				System.out.println(-1);
				return;
			}
			
			arr[2] += arr[3]*2;
		}
		System.out.println(arr[2]);
	}
	
	public static void main(String[] args) throws Exception {
		new BEAKJOON_19238().solution();
	}
}
