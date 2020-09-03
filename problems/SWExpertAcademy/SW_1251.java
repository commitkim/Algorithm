package problems.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int x, y, idx;
	double distance;

	Node(int x, int y, int idx, double distance) {
		this.x = x;
		this.y = y;
		this.idx = idx;
		this.distance = distance;
	}

	@Override
	public int compareTo(Node o) {
		return (this.distance - o.distance >= 0) ? 1 : -1;
	}
}

public class SW_1251 {
	private static int N;
	private static double rate;
	private static double answer;
	private static List<int[]> unSelected;
	private static boolean[] visited;
	private static PriorityQueue<Node> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; ++test_case) {
			N = Integer.parseInt(br.readLine());
			unSelected = new ArrayList<int[]>();
			visited = new boolean[N];
			pq = new PriorityQueue<Node>();
			answer = 0;
			StringTokenizer X = new StringTokenizer(br.readLine());
			StringTokenizer Y = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; ++i) {
				unSelected.add(new int[] { Integer.parseInt(X.nextToken()), Integer.parseInt(Y.nextToken()), i });
			}
			
			rate = Double.parseDouble(br.readLine());
			pq.offer(new Node(unSelected.get(0)[0], unSelected.get(0)[1], 0, 0));

			for (int i = 0; i < N; ++i) {
				Node n = pq.poll();
				if(visited[n.idx]) {
					--i;
					continue;
				}
				visited[n.idx] = true;
				answer += n.distance;
				for (int j = 0; j < N; ++j) {
					if (visited[j])
						continue;
					int[] temp = unSelected.get(j);
					double distance = Math.pow(n.x - temp[0], 2) + Math.pow(n.y - temp[1], 2);
					
					distance *= rate;
					pq.add(new Node(temp[0], temp[1], temp[2], distance));
				}
			}
			System.out.println("#" + test_case + " " + Math.round(answer));
		}
	}
}
