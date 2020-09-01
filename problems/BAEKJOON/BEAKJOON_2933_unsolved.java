package problems.BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BEAKJOON_2933_unsolved {
	private static int R,C,N;
	private static char [][] map;
	
	private static void run(int dir, int height) {
		for(int i = 0; i<C; ++i) {
			if(map[R-height][i] == 'x') {
				map[R-height][i] = '.';
				break;
			}
		}
		
		for(int i = 0; i<C; ++i) {
			if(map[R-height][i] == 'x') 
				return;
		}
		
		for(int i = height+1; i>=1; --i) {
			for(int j = 0; j<C; ++j) {
				map[i][j] = map[i-1][j];
			}
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int i = 0; i<R; ++i) {
			char[] line = br.readLine().toCharArray();
			for(int j = 0; j<C; ++j) {
				map[i][j] = line[j];
			}
		}
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; ++i) {
			
		}
	}
}
