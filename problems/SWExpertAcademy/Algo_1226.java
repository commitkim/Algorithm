package problems.SWExpertAcademy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Algo_1226 {
	private static int[] moveX = {-1,1,0,0};
	private static int[] moveY = {0,0,-1,1};
	private static int[][] map;
	private static boolean answer = false;
	
	private static void DFS(int x, int y) {
		if(x == 13 && y == 13) {
			answer = true;
			return;
		}
		map[x][y] = 1;
			
		for(int i=0; i<4; ++i) {
			int a = x + moveX[i];
			int b = y + moveY[i];
			
			if(a<0 || b<0 || a>=16 || b>=16)
				continue;
			
			if(map[a][b] != 1) {
				DFS(a,b);
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		//Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case<=10; ++test_case) {
			sc.nextLine();
			map = new int[16][16];
			
			for(int i = 0; i<16; ++i) {
				String line = sc.nextLine();
				for(int j = 0; j<16; ++j) {
					map[i][j] = line.charAt(j) - '0';
				}
			}
			DFS(1,1);
			
			System.out.println("#" + test_case + " " + ((answer)? "1" : "0"));
			answer = false;
			
		}
	}
}
