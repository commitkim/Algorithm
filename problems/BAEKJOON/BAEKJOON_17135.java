package problems.BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BAEKJOON_17135 {
	private static int answer = 0;
	private static int N,M,D;
	
	private static int[][] map,copy;
	private static int[] archer;
	
	
	private static void Selection(int start, int cnt) {
		if(cnt == 3) {
			int result = run();
			init();
			answer = (result<answer)? answer : result;
			return;
		}
		
		for(int i = start; i<M; ++i) {
			archer[i] = 1;
			Selection(i+1,cnt+1);
			archer[i] = 0;
		}
	}
	
	private static int run() {
		int cnt = 0;

		for(int turn = 0; turn<N; ++turn) {
			for(int i=0; i<M; ++i) { // 궁수 선택
				if(archer[i] != 1)
					continue;
				
				int archerX = N;
				int archerY = i;
				
				
				int diff = Integer.MAX_VALUE;
				int x = -1;
				int y = -1;
				
				for(int j = 0; j<N; ++j) {  //범위내 병사들 조회
					for(int k = 0; k<M; ++k) {
						if(map[j][k] == 1 || map[j][k] == 2) {
							if(Math.abs(archerX-j) + Math.abs(archerY - k) <= D && diff >= Math.abs(archerX-j) + Math.abs(archerY - k) ) {
								if(diff == Math.abs(archerX-j) + Math.abs(archerY - k) && y<k)
										continue;

								diff = Math.abs(archerX-j) + Math.abs(archerY - k);
								x = j;
								y = k;
							}
						}
					}
				}
				
				if(x != -1) {
					map[x][y] = 2; 
				}
				
			}
		for(int i = 0; i<N; ++i) {  //범위내 병사들 조회
			for(int j = 0; j<M; ++j) {
					if(map[i][j] == 2) {
						map[i][j] = 0;
						++cnt;
					}
				}
			}
			
			
			for(int i = N-1; i>=1; --i) { // 병사 이동
				for(int j = 0; j<M; ++j) {
					map[i][j] = map[i-1][j];
				}
			}
			
			for(int i = 0; i<M; ++i) { // 병사 이동 첫줄
				map[0][i] = 0;
			}
			
			
			
		}
		
		return cnt;

	}
	
	private static void init() {
		for(int i = 0; i<N; ++i) {
			for(int j = 0; j<M; ++j) {
				map[i][j] = copy[i][j];
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		copy = new int[N][M];
		archer = new int[M];
		
		for(int i = 0; i<N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				copy[i][j] = map[i][j];
			}
		}
		Selection(0,0);

		System.out.println(answer);
	}
}
