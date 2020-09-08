package problems.BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Point implements Comparable<Point>{
	int x, y, size,eatenCount ,count;

	Point(int x, int y, int size,int eatenCount, int count) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.eatenCount = eatenCount;
		this.count = count;
	}

	@Override
	public int compareTo(Point o) { 
		if(this.x == o.x) {
			return this.y - o.y;
		}
		return this.x - o.x;
	}
	
}

public class BAEKJOON_16236 {
	private static int N,answer;
	private static int[] moveX = { -1, 0, 0, 1 };
	private static int[] moveY = { 0, -1, 1, 0 };
	private static int[][] map;
	private static boolean[][] visited;
	private static Point shark;
	private static PriorityQueue<Point> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		answer = 0;
		map = new int[N][N];
		pq = new PriorityQueue<Point>();  //찾은 물고기 저장할 큐
		Queue<Point> q = new LinkedList<>(); //BFS에 사용할 큐

		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					shark = new Point(i, j, 2, 0 ,0);
					map[i][j] = 0;
				}
			}
		}

		q.offer(shark);
		
		while (!q.isEmpty()) { // 찾았다면 여기로
			visited = new boolean[N][N]; // 방문배열 초기화
			answer = q.peek().count;
			visited[q.peek().x][q.peek().y] = true;
			
			while (!q.isEmpty() ) {
				int s = q.size();
				
				for(int k = 0; k<s; ++k) {  //레벨별로 먹을 물고기를 찾았는지 확인
					Point p = q.poll();
					int x = p.x;
					int y = p.y;
					int size = p.size;
					int eatenCount = p.eatenCount;
					int count = p.count;
					
					for (int i = 0; i < 4; ++i) {
						int a = x + moveX[i];
						int b = y + moveY[i];
						if (a < 0 || b < 0 || a >= N || b >= N)
							continue;
						if (map[a][b] > size)
							continue;
						if (visited[a][b])
							continue;
						
						visited[a][b] = true;
						if (map[a][b] != 0 && map[a][b] < size) {
							++eatenCount;
							if (eatenCount == size) {
								eatenCount = 0;
								++size;
							}
							pq.offer(new Point(a, b, size, eatenCount, count+1)); //물고기 담기
						}
						q.offer(new Point(a, b, size, eatenCount, count+1));
					}
				}
				
				if(pq.size() != 0) { //물고기가 하나라도담겼으면
					q.clear();  
					Point p = pq.poll();  //젤 위, 젤 왼쪽 하나 뽑아서
					map[p.x][p.y] = 0; //먹고
					
					q.offer(p); //큐에 넣기
					pq.clear();
					break;
				}
			}
			
		}
		
		System.out.println(answer);

	}
}
