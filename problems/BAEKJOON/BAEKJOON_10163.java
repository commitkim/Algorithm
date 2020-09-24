package problems.BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEKJOON_10163 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] back = new int[102][102];
		int N = Integer.parseInt(br.readLine());
		
		int[] paper = new int[N];
		for(int i = 1; i<=N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			for(int j = x; j<x+width; ++j) {
				for(int k = y; k<y+height; ++k) {
					back[j][k] = i;
				}
			}
		}
		
		for(int i = 0; i<102; ++i) {
			for(int j = 0; j<102; ++j) {
				if(back[i][j] == 0) continue;
				++paper[back[i][j]-1];
			}
		}
		Arrays.stream(paper).forEach(e->System.out.println(e));
	}
}
