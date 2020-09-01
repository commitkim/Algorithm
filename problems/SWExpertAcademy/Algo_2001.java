package problems.SWExpertAcademy;

import java.util.Scanner;

public class Algo_2001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case<=T; ++test_case) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] arr = new int[N][N];
			
			for(int i = 0; i<N; ++i) {
				for(int j = 0; j<N; ++j) {
					arr[i][j] = sc.nextInt();
				}
			}
			int answer = 0;
			
			for(int i = 0; i<N; ++i) {
				if(i>N-M)
					break;
				for(int j = 0; j<N; ++j) {
					if(j>N-M)
						break;
					int sum = 0;
					for(int k = i; k< i+M; ++k) {
						for(int l = j; l<j+M; ++l) {
							sum += arr[k][l];
						}
					}
					answer = Math.max(answer,sum );
					
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
		sc.close();
	}
}
