package problems.BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_2578 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = 0;
		int[][] bingo = new int[25][2];
		for(int i = 0; i<5; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<5; ++j) {
				bingo[Integer.parseInt(st.nextToken())-1] = new int[] {i,j};
			}
		}
		int[] col = {5,5,5,5,5};
		int[] row = {5,5,5,5,5};
		int[] cross = {5,5};
		
		for(int i = 1; i<=5; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=5; ++j) {
				int[] arr = bingo[Integer.parseInt(st.nextToken())-1];
				count = (--col[arr[0]] == 0)? count + 1 : count;
				count = (--row[arr[1]] == 0)? count + 1 : count;
				
				if(arr[0] == arr[1]) {
					count = (--cross[0] == 0)? count + 1 : count;
					if(arr[0]==2)
						count = (--cross[1] == 0)? count + 1 : count;
				}
				if(arr[0] != arr[1] && arr[0] + arr[1] == 4) 
					count = (--cross[1] == 0)? count + 1 : count;
				
				if(count>=3) {
					System.out.println(5*(i-1) + j);
					return;
				}
			}
		}
		
	}
}
