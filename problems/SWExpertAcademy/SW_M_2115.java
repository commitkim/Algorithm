package problems.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_M_2115 {
	private static int N,M,C,answer;
	private static int[][] map;
	private static int[] selected;
	private static boolean[] visited;
	private static int income;
	
	private static int calc(int x, int y) {
		int sum = 0;
		int max = 0;
		int[] arr = new int[M];
		System.arraycopy(map[x], y, arr, 0, M);
		
		for(int i = 0; i<M; ++i) {
			if(arr[selected[i]] + max > C) break;
			sum += (arr[selected[i]] * arr[selected[i]]);
			max += arr[selected[i]];
		}
		
		return sum;
	}
	
	private static void P(int x, int y, int cnt) {
		if(cnt == M) {
			income = Math.max(calc(x,y), income);
//			System.out.println(Arrays.toString(selected));
			return;
		}
		
		for(int i = 0; i<M; ++i) {
			if(visited[i]) continue;
			
			visited[i] = true;
			selected[cnt] = i;
			P(x,y,cnt+1);
			
			visited[i] = false;
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T  = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <=T; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			answer = 0;
			map = new int[N][N];
			selected = new int[M];
			visited = new boolean[M];
			
			for(int i = 0; i<N; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; ++j){
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i<N; ++i) {
				for(int j = 0; j<=N-M; ++j){
					
					for(int k = i; k<N; ++k) {
						for(int l = 0; l<=N-M; ++l) {
							if(i == k && j+M > l) {
								continue;
							}
							income = 0;
							int sum = 0;
							P(i,j,0);
							sum += income;
							
							income = 0;
							P(k,l,0);
							sum += income;
							
							answer = Math.max(answer, sum);
//							answer = Math.max(calc(i,j)+calc(k,l),answer);
//							System.out.println("(" + i +" " + j + ")" + "(" + k +" " + l + ")"  + answer);
						}
					}
					
					
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
			
		}
	}
}
