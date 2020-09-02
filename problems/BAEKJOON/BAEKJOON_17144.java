package problems.BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_17144 {
	private static int R,C,T,airCleanerX;
	private static int[] moveX = {-1,1,0,0};
	private static int[] moveY = {0,0,-1,1};

	private static int[] topMoveX = {0,-1,0,1};
	private static int[] topMoveY = {1,0,-1,0};
	
	private static int[] bottomMoveX = {0,1,0,-1};
	private static int[] bottomMoveY = {1,0,-1,0};
	
	private static int[][] map,copy;
	
	private static void spread() {
		for(int i = 0 ; i<R; ++i) {
			for(int j = 0 ; j<C; ++j) {
				if(copy[i][j] < 5) 
					continue;
				int m = copy[i][j]/5;
				for(int k = 0; k<4; ++k) {
					int a = i + moveX[k];
					int b = j + moveY[k];
					
					if(a<0 || b<0 || a>=R || b>=C || map[a][b] == -1) continue;
					
					map[a][b] += m;
					map[i][j] -= m;
				}
			}
		}
	}
	
	private static void init() {
		for(int i = 0 ; i<R; ++i) {
			for(int j = 0 ; j<C; ++j) {
				copy[i][j] = map[i][j];
			}
		}
	}
	
	private static void purify() {
		int topStart = airCleanerX-1;
		int bottomStart = airCleanerX;
		
		int a = topStart + topMoveX[0];
		int b = topMoveY[0];
		int now = map[a][b];
		int before = 0;
		map[a][b] = before;
		for(int i = 0; i<4; ++i) {
			while(true) {
				a += topMoveX[i];
				b += topMoveY[i];
				
				if(a<0 || b<0 || a>=R || b>=C || map[a][b] == -1) {
					a -= topMoveX[i];
					b -= topMoveY[i];
					break;
				}
				before = now;
				now = map[a][b];
				map[a][b] = before;
			}
		}
		
		
		a = bottomStart + bottomMoveX[0];
		b = bottomMoveY[0];
		now = map[a][b];
		before = 0;
		map[a][b] = before;
		for(int i = 0; i<4; ++i) {
			while(true) {
				a += bottomMoveX[i];
				b += bottomMoveY[i];
				
				if(a<0 || b<0 || a>=R || b>=C || map[a][b] == -1) {
					a -= bottomMoveX[i];
					b -= bottomMoveY[i];
					break;
				}
				before = now;
				now = map[a][b];
				map[a][b] = before;
			}
		}
	}
	
	private static int check() {
		int cnt = 0;
		for(int i = 0 ; i<R; ++i) {
			for(int j = 0 ; j<C; ++j) {
				cnt += map[i][j];
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		copy = new int[R][C];
		airCleanerX = 0;
		
		for(int i = 0 ; i<R; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<C; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				copy[i][j] = map[i][j];
				if(map[i][j] == -1)
					airCleanerX = i;
			}
		}
		
		for(int i = 0; i<T; ++i) {
			spread();
			init();
			purify();
			init();
		}
		
		System.out.println(check()+2);
	}
}
