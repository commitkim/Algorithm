package problems.SWExpertAcademy;

import java.util.Scanner;

public class Algo_1954 {
	private static int[] moveX = {0,1,0,-1};
	private static int[] moveY = {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case<=T; ++test_case) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			int direction = 0;

			int x = 0;
			int y = 0;
			
			for(int i = 1; i<=N*N; ++i) {
				arr[x][y] = i;
				
				int a = x + moveX[direction];
				int b = y + moveY[direction];
				
				if(i==N*N)
					break;
				
				if(a<0 || b<0 || a>=N || b>=N || arr[a][b] != 0) {
					direction = (direction+1)%4;
					--i;
					continue;
				}
				x = a;
				y = b;
			}
			System.out.println("#" + test_case);
			for(int i = 0; i<N; ++i) {
				for(int j = 0; j<N; ++j) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			
		}
		
		sc.close();
	}
}
