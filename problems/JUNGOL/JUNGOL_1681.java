package problems.JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int x, y, weight;

	Edge(int x, int y, int weight) {
		this.x = x;
		this.y = y;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}
}

public class JUNGOL_1681 {
	private static int N, answer;
	private static boolean[] visited;
	private static int[][] map;

	private static void DFS(int now, int cnt, int sum) {
		if (cnt == N) {
			answer = Math.min(answer, sum);
			return;
		}
		
		if(sum >= answer) return;

		if (cnt == N - 1) {
			if( map[now][0] == 0) return;
			DFS(0, cnt + 1, sum + map[now][0]);
		}
		else {
			for (int i = 0; i < N; ++i) {
				if (visited[i] || map[now][i] == 0)
					continue;
				visited[i] = true;
				DFS(i, cnt + 1, sum + map[now][i]);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		answer = Integer.MAX_VALUE;
		visited = new boolean[N];
		
		map = new int[N][N];
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited[0] = true;
		DFS(0,0,0);

		System.out.println(answer == Integer.MAX_VALUE? 0 : answer);

	}
}
