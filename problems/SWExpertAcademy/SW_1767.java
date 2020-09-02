package problems.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_1767 {
	private static int N, count, answer;
	private static int[] moveX = { -1, 0, 1, 0 };
	private static int[] moveY = { 0, 1, 0, -1 };

	private static int[][] map;
	private static List<int[]> list;

	private static void DFS(int idx, int cnt, int ans) {
		if(list.size() == idx) {
			if(count < cnt) {
				count = cnt;
				answer = ans;
			}
			else if (count == cnt){
				answer = Math.min(answer, ans);
			}
			return;
		}
		
		
		int arr[] = list.get(idx);
		DFS(idx+1, cnt, ans);
		for (int k = 0; k < 4; ++k) {
			int a = arr[0];
			int b = arr[1];
			boolean flag = true;

			while (true) {
				a += moveX[k];
				b += moveY[k];

				if (a < 0 || b < 0 || a >= N || b >= N)
					break;

				if (map[a][b] != 0) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				int line = paint(arr[0],arr[1],k,2);
				DFS(idx+1, cnt +1, ans + line);
				paint(arr[0],arr[1],k,0);
			}
		}
	}
	
	private static int paint(int i, int j, int dir, int line) {
		int a = i;
		int b = j;
		int count = 0;
		while (true) {
			a += moveX[dir];
			b += moveY[dir];

			if (a < 0 || b < 0 || a >= N || b >= N)
				break;
			
			map[a][b] = line;
			++count;
		}
		
		return count;
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; ++test_case) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			list = new ArrayList<>();
			answer = 0;
			count = 0;

			for (int i = 0; i < N; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i!=0 && j!=0 && i!=N-1 && j!=N-1 && map[i][j] != 0)
						list.add(new int[] { i, j });
				}
			}

			DFS(0,0,0);

			System.out.println("#" + test_case + " " + answer);
		}
	}
}
