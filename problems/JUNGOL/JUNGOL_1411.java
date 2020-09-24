package problems.JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JUNGOL_1411 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1];
		
		arr[1] = 1;
		arr[2] = 3;
		
		for(int i = 3; i<=N; ++i) {
			arr[i] = (arr[i-1] + arr[i-2]*2)%20100529;
		}
		System.out.println(arr[N]);
	}
}
