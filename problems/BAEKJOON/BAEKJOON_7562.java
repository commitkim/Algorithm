package problems.BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEKJOON_7562 {
	private static int[] moveX = {-2,-1,1,2,2,1,-1,-2};
	private static int[] moveY = {1,2,2,1,-1,-2,-2,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; ++test_case) {
			int l = Integer.parseInt(br.readLine());
			StringTokenizer st;
			boolean[][] visited = new boolean[l][l];
			
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			
			
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] {startX,startY,0});
			visited[startX][startY] = true;
			
			while(!q.isEmpty()) {
				int[] arr = q.poll();
				int x = arr[0];
				int y = arr[1];
				int cnt = arr[2];
				
				if(x == endX && y == endY) {
					System.out.println(cnt);
					break;
				}
				
				for(int i = 0; i<8; ++i) {
					int a = x + moveX[i];
					int b = y + moveY[i];
					
					if(a<0 || b<0 || a>=l || b>=l) continue;
					if(visited[a][b]) continue;
					
					visited[a][b] = true;
					q.offer(new int[] {a,b,cnt+1});
				}
			}
		}
	}
}
