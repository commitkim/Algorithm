package problems.BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_15961 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int answer = 0;
		int[] sushi = new int[N];
		
		for(int i = 0; i<N; ++i) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		int[] visited = new int[d+1];
		int kinds = 0;
		for(int i = 0; i<k; ++i) {
			if(visited[sushi[i]] == 0) ++kinds;
			++visited[sushi[i]];
		}
		answer = (visited[c] == 0)? Math.max(answer, kinds+1) : Math.max(answer, kinds);
		
		for(int i = k; i<k+N; ++i) {
			kinds = (--visited[sushi[(i-k)%N]] == 0)? kinds-1 : kinds;
			kinds = (++visited[sushi[i%N]] == 1)? kinds+1 : kinds;
			
			answer = (visited[c] == 0)? Math.max(answer, kinds+1) : Math.max(answer, kinds);
		}
		
		System.out.println(answer);
	}
}
