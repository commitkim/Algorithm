package problems.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_M_2117 {
	private static int N, M, answer;
	private static int[][] map;

	private static void run(int x, int y, int size) {
		--size;
		for(int i = 0; i<=size; ++i) {
			for(int j = y-size+i; j<=y+size-i; ++j) {
				if(x+i < 0 || j<0 || x+i>=N || j>=N) {}
				else {
					if(map[x+i][j] == 1) map[x+i][j] = 2;
				}
				
				if(x-i < 0 || j<0 ||x-i>=N || j>=N) {}
				else {
					if(map[x-i][j] == 1) map[x-i][j] = 2;
				}
				
			}
		}
	}

	private static int check(int K) {
		int result = 0;
		int cost = K * K + (K - 1) * (K - 1);
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if(map[i][j] == 2) {
					++result;
					map[i][j] = 1;
				}
			}
		}

		return (result * M >= cost) ? result : 0;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			answer = 0;

			map = new int[N][N];
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int size = N + 1;
			
			for(int i = 0; i<N; ++i) {
				for(int j = 0; j<N; ++j) {
					
					for(int k = 1; k<=size; ++k) {
						run(i,j,k);
						answer = Math.max(check(k), answer);
					}
				}
			}

			System.out.println("#" + test_case + " " + answer);

		}
	}
}
