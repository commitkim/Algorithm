package problems.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class SWExpert_1247 {
	private static int N, answer;
	private static Point[] clients;
	private static int[] selected;
	private static Point start, end;

	public static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	private static boolean nextPermutation(int[] numbers, int N) {
		int i = N - 1;

		// step01. 꼭대기 찾기
		while (i > 0 && numbers[i - 1] >= numbers[i])
			--i;
		if (i == 0)
			return false; // 만들 수 있는 가장 큰 순열이 이미 만들어짐

		// step02. i-1위치와 교환할 다음 단계 큰 수 뒷쪽에서 찾기
		int j = N - 1;
		while (numbers[i - 1] >= numbers[j])
			--j;

		// step03. i-1 위치값과 j 위치값 교환
		swap(numbers, i - 1, j);

		// step04. i위치부터 맨 뒤까지 오름차순 정렬
		int k = N - 1;
		while (i < k) {
			swap(numbers, i++, k--);
		}

		return true;
	}
	
	private static void DFS() {
		
	}

	private static int solve() {
		int x = start.x;
		int y = start.y;
		int distance = 0;

		for (int i = 0; i < N; ++i) {
			Point client = clients[selected[i]];
			distance += Math.abs(x - client.x) + Math.abs(y - client.y);
			if (distance >= answer)
				return Integer.MAX_VALUE;

			x = client.x;
			y = client.y;
		}

		Point home = end;
		distance += Math.abs(x - home.x) + Math.abs(y - home.y);
		if (distance >= answer)
			return Integer.MAX_VALUE;

		return distance;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; ++test_case) {
			N = Integer.parseInt(br.readLine());

			selected = new int[N];
			answer = Integer.MAX_VALUE;
			clients = new Point[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			for (int i = 0; i < N; ++i) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				clients[i] = new Point(x, y);
				selected[i] = i;
			}

			do {
				answer = Math.min(solve(), answer);

			} while (nextPermutation(selected, N));

			System.out.println("#" + test_case + " " + answer);

		}
	}
}
