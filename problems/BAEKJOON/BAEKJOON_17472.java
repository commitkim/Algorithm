package problems.BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Bridge implements Comparable<Bridge>{
	int x,y,length;
	Bridge(int x, int y, int length){
		this.x = x;
		this.y = y;
		this.length = length;
	}
	@Override
	public int compareTo(Bridge o) {
		return this.length - o.length;
	}
}

public class BAEKJOON_17472 {
	private static int N, M;
	private static boolean[] check;
	private static int[] moveX = { -1, 1, 0, 0 };
	private static int[] moveY = { 0, 0, -1, 1 };
	private static int[][] map;
	private static int[][] bridges;
	private static boolean[][] visited;
	private static int[] parents;
	private static PriorityQueue<Bridge> pq;

	private static void makeSet(int size) {
		for (int i = 0; i < size; ++i) {
			parents[i] = i;
		}
	}

	private static int find(int n) {
		if (n == parents[n])
			return n;
		return parents[n] = find(parents[n]);
	}

	private static boolean union(int n, int m) {
		int nP = find(n);
		int mP = find(m);

		if (nP == mP)
			return false;
		parents[nP] = mP;

		return true;
	}

	private static void DFS(int x, int y, int num) {
		map[x][y] = num;
		visited[x][y] = true;
		for (int i = 0; i < 4; ++i) {
			int a = x + moveX[i];
			int b = y + moveY[i];

			if (a < 0 || b < 0 || a >= N || b >= M)
				continue;
			if (map[a][b] != -1)
				continue;
			if (visited[a][b])
				continue;

			DFS(a, b, num);
		}
		visited[x][y] = false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				map[i][j] = -Integer.parseInt(st.nextToken());
			}
		}

		int num = 1;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (map[i][j] == -1)
					DFS(i, j, num++);
			}
		}
		bridges = new int[num][num];

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (map[i][j] != 0) {
					int now = map[i][j];
					for (int k = 0; k < 4; ++k) {
						int arrival = 0;
						int count = 0;
						int a = i;
						int b = j;
						while (true) {
							a += moveX[k];
							b += moveY[k];

							if (a < 0 || b < 0 || a >= N || b >= M)
								break;
							if (map[a][b] != 0) {
								arrival = map[a][b];
								break;
							}

							++count;
						}

						if (arrival != 0 && count > 1) {
							if (bridges[now][arrival] == 0) {
								bridges[now][arrival] = count;
							} else {
								bridges[now][arrival] = Math.min(bridges[now][arrival], count);
							}
						}
					}
				}
			}
		}

		int answer = 0;
		parents = new int[num];

		pq = new PriorityQueue<>();
		makeSet(num);
		
		visited = new boolean[num][num];
		for (int i = 1; i < num; ++i) {
			for (int j = 1; j < num; ++j) {
				if(bridges[i][j] == 0) continue;
				if(visited[i][j]) continue;
				
				pq.offer(new Bridge(i,j,bridges[i][j]));
				visited[i][j] = true;
				visited[j][i] = true;
			}
		}
		
		check = new boolean[num];
		while(!pq.isEmpty()) {
			Bridge b = pq.poll();
			
			int x = b.x;
			int y = b.y;
			if(union(x,y)) {
				check[x] = true;
				check[y] = true;
				answer += b.length;
			}
		}
		for(int i = 1; i<num; ++i) {
			if(find(1)!=find(i)) answer = -1;
		}
		

		System.out.println(answer);

	}
}
