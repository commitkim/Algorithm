package problems.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_M_4014 {
	private static int N,X,answer;
	private static int[][] map;
	private static int[] line;
	
	private static boolean check(int[] arr) {
		int[] copy = arr.clone();
		for(int i = 0; i<N-1; ++i) {
			if(copy[i]+1 == copy[i+1]) {
				if(i-X+1 < 0) return false;
				int height = copy[i];
				for(int j = i; j>=i-X+1; --j) {
					if(arr[j] != height) return false;
				}
				
				for(int j = i; j>=i-X+1; --j) {
					arr[j] = -1;
				}
				
			}
			else if(copy[i] == copy[i+1]+1) {
				if(i+X >= N) return false;
				// 2 + 3 - 1 = 4 -> 2,3,4 
				
				int height = copy[i+1];
				for(int j = i+1; j<=i+X; ++j) {
					if(arr[j] != height) return false;
				}
				
				for(int j = i+1; j<=i+X; ++j) {
					arr[j] = -1;
				}
				i += X-1;
			}
			else if(copy[i] == copy[i+1]) {
				continue;
			}
			else {
				return false;
			}
			
		}
		
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case<=T; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			answer = 0;
			
			for(int i = 0; i<N; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
			
			for(int i = 0; i<N; ++i) {  /// 가로
				line = new int[N];
				
				for(int j = 0; j<N; ++j) {
					line[j] = map[i][j];
				}
				if(check(line)) ++answer;
				
				for(int j = 0; j<N; ++j) {
					line[j] = map[j][i];
				}
				
				if(check(line)) ++answer;
				
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}
