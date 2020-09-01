package problems.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_WS2 {
	private static int[][] ig;
	private static int[] idxs;
	private static int N,L,answer = 0;
	
	private static void P(int start, int cnt, int max) {
		if(cnt == max) {
			answer = Math.max(run(), answer);
			return;
		}
		
		for(int i = start; i<ig.length; ++i) {
			idxs[i] = 1;
			P(i+1,cnt+1,max);
			idxs[i] = 0;
		}
	}
	
	private static int run() {
		int t = 0;
		int k = 0;
		for(int i = 0; i<ig.length; ++i) {
			if(idxs[i] == 1) {
				t += ig[i][0];
				k += ig[i][1];
			}
		}
		
		return (k<=L)? t : 0;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			answer = 0;
			
			ig = new int[N][2];
			idxs= new int[N];

			for(int i = 0; i<N; ++i) {
				st = new StringTokenizer(br.readLine());
				ig[i][0] = Integer.parseInt(st.nextToken());
				ig[i][1] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 1; i<=ig.length; ++i) {
				P(0,0,i);
			}
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
			
		}
		System.out.println(sb.toString());
	}
}
