package problems.SWExpertAcademy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Algo_1861 {
	private static int[] moveX = {-1,1,0,0};
	private static int[] moveY = {0,0,-1,1};
	private static int[][] arr;
	private static int N;
	private static int cnt = 1;
	
	private static void DFS(int x, int y) {
		for(int i= 0; i<4; ++i) {
			int a = x + moveX[i];
			int b = y + moveY[i];
			
			if(a<0 || b<0 || a>=N || b>=N) {
				continue;
			}
			if(arr[x][y] + 1 == arr[a][b]) {
				++cnt;
				DFS(a,b);
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("input4.txt"));
		int T = sc.nextInt();
		for(int test_case = 1; test_case<=T ; ++test_case) {
			N = sc.nextInt();
			int answer = 0;
			int number = Integer.MAX_VALUE;
			
			arr = new int[N][N];
			int[][] roomCnt = new int[N][N];
			
			for(int i = 0; i<N; ++i) {
				for(int j = 0; j<N; ++j) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i<N; ++i) {
				for(int j = 0; j<N; ++j) {
					cnt = 1;
					DFS(i,j);
					roomCnt[i][j] = cnt;
					if(answer <= cnt){
						answer = cnt;
					}
				}
			}
			
			for(int i = 0; i<N; ++i) {
				for(int j = 0; j<N; ++j) {
					if(roomCnt[i][j] == answer) {
						number = (arr[i][j] > number)? number : arr[i][j];
					}
				}
			}
			
			System.out.println("#" + test_case + " " + number + " " + answer);
			
		}
	}
}
