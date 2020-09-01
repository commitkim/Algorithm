package problems.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_3289 {
	private static int[] parents;
	
	private static void makeSet(int size) {
		for(int i = 1; i<=size; ++i) {
			parents[i] = i;
		}
	}
	private static int find(int c) {
//		p = parents[c];
//		while(p != parents[p]) {
//			p = parents[p];
//		}
//		return p;
		
		if(parents[c]==c) return c;
		return parents[c] = find(parents[c]);
	}
	
	private static void union(int a, int b) {
		int aParent = find(a);
		int bParent = find(b);
		
		if(aParent != bParent) 
			parents[bParent] = aParent;
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case<=T; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			parents = new int[n+1];
			
			makeSet(n);
			StringBuilder sb = new StringBuilder();
			sb.append("#" + test_case + " ");
			for(int i = 0; i<m; ++i) {
				st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				switch(command) {
				case 0:
					union(a,b);
					break;
				case 1:
					sb.append((find(a) == find(b))? "1" : "0");
					break;
				}
			}
			
			System.out.println(sb.toString());
		}
	}
}
