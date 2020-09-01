package problems.BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BAEKJOON_1753 {
	private static int V,E;
	private static List<int[]>[] list;
	private static int[] answer;
	private static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int now = Integer.parseInt(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		answer = new int[V+1];
		visited = new boolean[V+1];
		list = new ArrayList[V+1];
		
		for(int i = 1; i<=V; ++i) {
			answer[i] = Integer.MAX_VALUE;
			list[i] = new ArrayList<int[]>();
		}
		
		for(int i = 0; i<E; ++i) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new int[] {v,w});
		}
		
		answer[now] = 0;
		
		for(int i = 1; i<=V; ++i) {
			int min = Integer.MAX_VALUE;
			visited[now] = true;

			for(int j = 1; j<=V; ++j) {
				if(!visited[j] && answer[j] < min) {
					now = j;
					min = answer[j];
				}
			}
			
			for(int j = 0; j<list[now].size(); ++j) {
				int[] arr = list[now].get(j);
//				if(answer[arr[0]] == Integer.MAX_VALUE || answer[arr[0]] > answer[now] + arr[1]) {
				if(!visited[arr[0]] && answer[arr[0]] > answer[now] + arr[1]) {
					answer[arr[0]] = answer[now] + arr[1];
				}
			}
		}
		
		for(int i = 1; i<=V; ++i) {
			System.out.println((answer[i]==Integer.MAX_VALUE)? "INF" : answer[i]);
		}
		
	}
}
