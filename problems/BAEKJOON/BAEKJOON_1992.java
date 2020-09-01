package problems.BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_1992 {
	private static int[][] grayScaleImage;
	private static String answer;
	
	
	private static void solve(int x, int y, int size) {
		if(size == 1) {
			answer += String.valueOf(grayScaleImage[x][y]);;
			return;
		}
		if(!check(x,y,size)) {
			answer += "(";
			size /= 2;
			solve(x,y,size);
			solve(x,y+size,size);
			solve(x+size,y,size);
			solve(x+size,y+size,size);
			answer += ")";
		}
		else {
			answer += String.valueOf(grayScaleImage[x][y]);
		}
	}
	
	private static boolean check(int x, int y, int size) {
		int type = grayScaleImage[x][y];
		for(int i = x; i<x+size; ++i) {
			for(int j = y; j<y+size; ++j) {
				if(grayScaleImage[i][j] != type) return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		grayScaleImage = new int[N][N];
		answer = "";
		
		for(int i = 0; i<N; ++i) {
			String line = br.readLine();
			for(int j = 0; j<N; ++j) {
				grayScaleImage[i][j] = line.charAt(j) - '0';
			}
		}
		solve(0,0,N);
		
		System.out.println(answer);
	}
}
