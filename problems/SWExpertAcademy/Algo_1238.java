package problems.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo_1238 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case<=10; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int answer = 0;
			
			int[] visited = new int[101];
			int[][] arr = new int[101][101];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N/2; ++i) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				arr[x][y] = 1;
			}
			
			
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(start);
			visited[start] = 1;
			while(!q.isEmpty()) {
				answer = 0;
				
				int size = q.size();
				for(int i = 0; i<size; ++i) {///level 별로 접근하는 방법
					int idx = q.poll();
					answer = (answer<idx)? idx : answer;
								
					for(int j = 1; j<=100; ++j) {
						if(arr[idx][j] == 1 && visited[j] == 0) {
							//갔다가 다시 안가려면 배열을 바꾸는거보다 visited 배열을 쓰는게 좋다! 
							q.offer(j);
							visited[j] = 1;
						}
					}
				}
				
			}			
			System.out.println("#" + test_case + " " + answer);
		}
		
	}
}
