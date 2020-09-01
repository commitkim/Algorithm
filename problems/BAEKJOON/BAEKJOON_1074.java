package problems.BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_1074 {
	private static int N,r,c,arrSize,answer,result;
	
	public static void solve(int x, int y, int size) {
		if(size == 1) {
			++result;
			if(x == r && y == c) answer = result;
			return;
		}
		size /= 2;
		solve(x,y,size);
		solve(x,y+size,size);
		solve(x+size,y,size);
		solve(x+size,y+size,size);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arrSize = (int)Math.pow(2, N);
		result = 0;
		
		solve(0,0,arrSize);
		
		System.out.println(answer-1);
	}
}
