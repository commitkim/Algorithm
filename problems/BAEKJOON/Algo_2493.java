package problems.BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Algo_2493 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		StringBuilder sb = new StringBuilder();
		
		Stack<int[]> s = new Stack<int[]>();
		
		for(int i = 0; i<N; ++i) {
			int height = Integer.parseInt(st.nextToken());
			
			while(!s.empty() && s.peek()[0] < height) {
				s.pop();
			}
			sb.append((s.empty())? "0" : s.peek()[1]).append(" ");
			s.push(new int[] {height,i+1});
		}
		System.out.println(sb.toString());
		
	}
}
