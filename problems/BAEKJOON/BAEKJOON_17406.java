package problems.BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Rotation {
	int r;
	int c;
	int s;
	
	public Rotation(int r, int c, int s) {
		super();
		this.r = r;
		this.c = c;
		this.s = s;
	}
	
}

public class BAEKJOON_17406 {
	private static int N,M,K,answer;
	private static int[] selected, visited;
	private static Rotation[] rt;
	private static int[][] arr,copy;
	
	private static int[] dirX = {0,1,0,-1};
	private static int[] dirY = {1,0,-1,0};
	
	private static int getMinimum() {
		int min = Integer.MAX_VALUE;
		
		for(int i = 1; i<=N; ++i) {
			int sum = 0;
			for(int j = 1; j<=M; ++j) {
				sum += arr[i][j];
			}
			min = Math.min(sum, min);
		}
		
		return min;
	}
	
	private static void P(int start, int cnt) {
		if(cnt == K) {
			for(int i = 0; i<K; ++i) {
				Rotation r = rt[selected[i]];
				rotate(r.r, r.c, r.s);
			}
			answer = Math.min(getMinimum(), answer);
			init();
			return;
		}
		
		for(int i = 0; i<K; ++i) {
			if(visited[i]==1) continue;
			visited[i] = 1;
			selected[cnt] = i;
			P(i+1,cnt+1);
			
			visited[i] = 0;
		}
		
	}
	
	private static void rotate(int x, int y, int size) {
		for(int i = 1; i<=size; ++i) {
			int a = x - i;
			int b = y - i;
			int temp = arr[a][b];
			
			for(int k = 0; k<4; ++k) {
				for(int l = 0; l<(i*2); ++l) {
					int n = a + dirX[k];
					int m = b + dirY[k];
					
					int tmp = arr[n][m];
					arr[n][m] = temp;
					temp = tmp;
					
					a = n;
					b = m;
				}
			}
		}
	}
	private static void init() {
		for(int i = 1; i<=N; ++i) {
			for(int j = 1; j<=M; ++j) {
				arr[i][j] = copy[i][j];
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		answer = Integer.MAX_VALUE;
		arr = new int[N+1][M+1];
		copy = new int[N+1][M+1];
		rt = new Rotation[K];
		selected = new int[K+10];
		visited = new int[K+10];
		
		for(int i = 1; i<=N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=M; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				copy[i][j] = arr[i][j];
			}
		}
		for(int i = 0; i<K; ++i) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			rt[i] = new Rotation(r,c,s);
		}
		
		P(0,0);
		
		System.out.println(answer);
		
		
	}
}
