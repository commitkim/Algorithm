package problems.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class SW_M_5658 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1;test_case<=T;++test_case) {
			Set<Integer> set = new HashSet<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			char[] arr = new char[N];
			
			String str =  br.readLine();
			for(int i = 0; i<N; ++i) {	
				arr[i] = str.charAt(i);
			}
			
			for(int turn = 0; turn <N/4; ++turn) {
				for(int i = 0; i<N; i+=N/4) {
					String num = "";
					for(int j = 0; j<N/4; ++j)
						num += arr[i+j];
					
					set.add(Integer.parseInt(num, 16));
				}
				char tmp = arr[N-1];
				System.arraycopy(arr, 0, arr, 1, N-1);
				arr[0] = tmp;
			}
			
			ArrayList<Integer> list = new ArrayList<Integer>(set);
			Collections.sort(list, Collections.reverseOrder());
			
			
			sb.append("#" + test_case + " " + list.get(K-1) + "\n");
		}
		System.out.println(sb.toString());

	}

}
