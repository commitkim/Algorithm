package problems.BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class BAEKJOON_1987 {
	private static int R,C,answer;
	private static int[] moveX = {-1,1,0,0};
	private static int[] moveY = {0,0,-1,1};
	private static char[][] alphabet;
	private static boolean[] visited;
	
	private static void DFS(int x, int y, int cnt) {
		for(int i = 0; i<4; ++i) {
			int a = x + moveX[i];
			int b = y + moveY[i];
			
			if(a<0 || b<0 || a>=R || b>=C) continue;
			if(visited[alphabet[a][b] - 'A']) continue;
			
			visited[alphabet[a][b] - 'A'] = true;
			DFS(a,b, cnt+1);
			visited[alphabet[a][b] - 'A'] = false;
		}
		answer = Math.max(answer, cnt);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alphabet = new char[R][C];
		visited = new boolean[26];
		answer = 0;
		
		for(int i = 0; i<R; ++i) {
			char[] line = br.readLine().toCharArray();
			for(int j = 0; j<C; ++j) {
				alphabet[i][j] = line[j]; 
			}
		}
		visited[alphabet[0][0] - 'A'] = true;
		DFS(0,0,1);
		System.out.println(answer);
	}
}
