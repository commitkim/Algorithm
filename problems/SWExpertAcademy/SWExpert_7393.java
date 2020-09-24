package problems.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWExpert_7393 {
	private static int[][][] arr = new int[101][10][1<<10];  // 길이, 마지막에 붙힐거, 사용한거
	private static int MOD = 1000000000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=1; i<10; i++) arr[1][i][1<<i] = 1;
		
		for(int i=2; i<=100; ++i) {// 길이
			for(int j=0; j<=9; ++j) { // 이번에 붙힐거
				for(int k=0; k<1<<10; ++k) { // 사용한 것
					int pre, post, bit = k | (1<<j);
					
					if(j==0) pre = 0;
					else pre = arr[i-1][j-1][k];
					
					if(j==9) post = 0;
					else post = arr[i-1][j+1][k];
					
					arr[i][j][bit] = (arr[i][j][bit] + ((pre + post) % MOD)) % MOD;
				}
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case<=T; ++test_case) {
			int N = Integer.parseInt(br.readLine());
			int answer = 0;
			
			for(int i = 0; i<10; ++i) answer = (answer + arr[N][i][(1<<10)-1]) % MOD;
			System.out.println("#"+ test_case + " " + answer);
		}
	}
}
