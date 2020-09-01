package problems.BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEKJOON_1697 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[100001];
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {N,0});
		
		while(!q.isEmpty()) {
			int[] arr = q.poll(); 
			int X = arr[0];
			int cnt = arr[1];
			visited[X] = true;

			if(X == K) {
				System.out.println(cnt);
				return;
			}

			if(X*2<=100000 && !visited[X*2]) q.offer(new int[] {X*2,cnt+1});
			if(X+1<=100000 && !visited[X+1]) q.offer(new int[] {X+1,cnt+1});
			if(X-1>=0 && !visited[X-1]) q.offer(new int[] {X-1,cnt+1});
		}

	}
}
