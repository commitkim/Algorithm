package problems.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo_9229 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case<=TC; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int weight = -1;
			
			Arrays.sort(arr);
			
			for(int i = 0; i<N; ++i) {
				for(int j = i+1; j<N; ++j) {
					if(arr[i] + arr[j] <= M) {
						weight = (arr[i] + arr[j] < weight)? weight : arr[i] + arr[j];
					}
				}
			}
			
			System.out.println("#" + test_case + " " + weight);
		}
	}
}
