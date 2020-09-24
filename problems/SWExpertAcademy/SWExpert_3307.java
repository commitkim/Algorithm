package problems.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWExpert_3307 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case<=T; ++test_case) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] answer = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < N; ++i) {
				int idx = i;
				int max = 0;

				for (int j = i - 1; j >= 0; --j) {
					if (arr[i] <= arr[j])
						continue;

					if (max < answer[j]) {
						idx = j;
						max = answer[j];
					}
				}
				answer[i] = answer[idx] + 1;
			}
			System.out.println("#" + test_case + " " +Arrays.stream(answer).max().getAsInt());
		}
		
	}
}
