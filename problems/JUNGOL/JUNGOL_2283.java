package problems.JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_2283 {
	private static int N;
	private static int[] cost = new int[3];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] before = cost.clone();
			for(int j = 0; j<3; ++j) 
                cost[j] = Integer.parseInt(st.nextToken()) + Math.min(before[(j+1)%3], before[(j+2)%3]);
		}
		
		System.out.println(Math.min(cost[0], Math.min(cost[1], cost[2])));
	}
}
