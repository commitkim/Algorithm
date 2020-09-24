package problems.BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEKJOON_11053 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] answer = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i<N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i<N; ++i) {
			int idx = i;
			int max = 0;
			
			for(int j = i-1; j>=0; --j) {
				if(arr[i] <= arr[j]) continue;
				
				if(max < answer[j]) {
					idx = j;
					max = answer[j];
				}
			}
			answer[i] = answer[idx] + 1;
		}
		Arrays.stream(answer).forEach(e->System.out.print(e + " "));
		System.out.println(Arrays.stream(answer).max().getAsInt());
	}
}
