package problems.BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_2563 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] back = new int[100][100];
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i<N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j<100; ++j) {
				back[x+j/10][y+j%10] = 1;
			}
		}
		
		int answer = 0;
		for(int i = 0; i<100; ++i) {
			for(int j = 0; j<100; ++j) {
				if(back[i][j] == 1)++answer;
			}
		}
		
		System.out.println(answer);
	}
}
