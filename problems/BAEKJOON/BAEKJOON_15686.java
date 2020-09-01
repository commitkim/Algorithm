package problems.BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BAEKJOON_15686 {
	private static List<int[]> home;
	private static List<int[]> chicken;
	private static int[] selected;
	private static int M,N,answer;
	
	public static void C(int start, int cnt) {
		if(cnt == M) {
			answer = Math.min(run(), answer);
			return;
		}
		int size = chicken.size();
		for(int i = start; i<size; ++i) {
			selected[cnt] = i;
			C(i+1,cnt+1);
		}
	}
	
	public static int run() {
		int homeSize = home.size();
		int result = 0;
		for(int i = 0; i<homeSize; ++i) {
			int[] homePoint = home.get(i);
			int min = Integer.MAX_VALUE;
			for(int j = 0; j<M; ++j) {
				int[] chickenPoint = chicken.get(selected[j]);
				int distance = Math.abs(homePoint[0] - chickenPoint[0]) + Math.abs(homePoint[1] - chickenPoint[1]);
				min = Math.min(distance, min);			
			}
			result += min;
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		selected = new int[M];
		answer = Integer.MAX_VALUE;
		
		for(int i = 0; i<N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; ++j) {
				String str = st.nextToken();
				if(str.equals("1")) {
					home.add(new int[] {i,j});
				}
				if(str.equals("2")) {
					chicken.add(new int[] {i,j});
				}
			}
		}
		
		C(0,0);
		
		System.out.println(answer);
		
		
	}
}
