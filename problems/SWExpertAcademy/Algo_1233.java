package problems.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo_1233 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case<=10; ++test_case) {
			int N = Integer.parseInt(br.readLine());
			int answer = 1;
			int[] arr = new int[N+1];
			for(int i=1; i<=N; ++i) {
				arr[i] = -1;
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				st.nextToken();
				char tmp = st.nextToken().charAt(0);
				if(tmp>='0' && tmp<='9') {
					arr[i] = tmp = '0';
				}
			}
			
			for(int i=1; i<=N; ++i) {
				if(arr[i] != -1) {
					if(2*i <= N && arr[2*i] != -1) {
						answer = 0;
						break;
						
					}
					if((2*i)+1 <=N && arr[(2*i)+1] != -1) {
						answer = 0;
						break;
					}
						
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
			
		}
	}
}
