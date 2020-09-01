package problems.SWExpertAcademy;

import java.util.Scanner;

public class Algo_2805 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = Integer.parseInt(sc.nextLine());
		for(int test_case = 1; test_case<=T; ++ test_case) {
			int answer = 0;
			int N = Integer.parseInt(sc.nextLine());
			int[][] farm = new int[N][N]; 

			for(int i = 0; i<N; ++i) {
				String line = sc.nextLine();
				for(int j = 0; j<N; ++j) {
					farm[i][j] = line.charAt(j) - '0';
				}
			}
			int base = N/2;
			for(int space = 0; space<N/2+1; ++space) {
				int a = N/2+space;
				int b = N/2-space;
				for(int j = space; j<N-space; ++j) {
					answer += farm[a][j];
					farm[a][j] = 0;
					answer += farm[b][j];
					farm[b][j] = 0;
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
		
	}
}
