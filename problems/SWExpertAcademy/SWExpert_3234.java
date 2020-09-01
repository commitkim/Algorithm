package problems.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWExpert_3234 {
	private static int N, answer;
	private static int[] weight,selected;
	private static boolean[] visited;
	
	private static void P(int cnt) {
		if(cnt == N) {
			solve(0,0,0);
			return;
		}
		
		for(int i = 0; i<N; ++i) {
			if(visited[i]) continue;
			
			visited[i] = true;
			selected[cnt] = i;
			P(cnt+1);
			visited[i] = false;
		}
	}
	
	private static boolean nextPermutation(int[] selected) {
		int i = N - 1;
		while(i > 0 && selected[i] <= selected[i-1]) --i;   // i가 꼭대기, i-1이 꼭대기에서 한칸 내려온거
		
		if(i == 0) return false;
		
		int j = N - 1;
		while(selected[i-1] >= selected[j]) --j;

		int k = N - 1;
		
		while(k>i) {
			int temp = selected[k];
			selected[k--] = selected[i];
			selected[i++] = temp;
		}
		
		return true;
	}
	
	private static void solve(int left, int right, int cnt) {
		if(cnt == N) {
//			System.out.println(left + " " + right);
			++answer;
			return;
		}
		
		solve(left + weight[selected[cnt]], right , cnt+1);
		if(left >= right + weight[selected[cnt]] )
			solve(left, right + weight[selected[cnt]] , cnt+1);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case<=T; ++test_case) {
			N = Integer.parseInt(br.readLine());
			
			weight = new int[N];
			selected = new int[N];
			visited = new boolean[N];
			answer = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; ++i) {
				weight[i] = Integer.parseInt(st.nextToken());
				selected[i] = i;
			}
			
//			do {
//				solve(0,0,0);
//			}while(nextPermutation(selected));
//			
			P(0);

			
			
//			System.out.println("#" + test_case + " " + answer);
			
		}
	}
}
