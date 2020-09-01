package problems.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Algo_1228_1229_1230 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case<=10; ++test_case) {
			int N = Integer.parseInt(br.readLine());
			
			LinkedList<String> ll = new LinkedList<String>();
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			for(int i = 0; i <N; ++i) {
				ll.add(st.nextToken());
			}
			br.readLine();

			st= new StringTokenizer(br.readLine()," ");
			int idx = 0;
			int cnt = 0;
			while(st.hasMoreTokens()) {
				switch(st.nextToken()) {
				case "I":
					idx = Integer.parseInt(st.nextToken());
					cnt = Integer.parseInt(st.nextToken());
					for(int i = 0; i<cnt; ++i) {
						ll.add(idx++,st.nextToken());
					}
					break;
				case "D":
					idx = Integer.parseInt(st.nextToken());
					cnt = Integer.parseInt(st.nextToken());
					
					for(int i = 0; i<cnt; ++i) {
						ll.remove(idx);
					}
					break;
				case "A":
					cnt = Integer.parseInt(st.nextToken());
					
					for(int i = 0; i<cnt; ++i) {
						ll.add(ll.size(),st.nextToken());
					}
				}
				
			}
			System.out.print("#" + test_case + " ");
			
			for(int i = 0; i<10; ++i) {
				System.out.print(ll.pollFirst() + " ");
			}
		}
		
	}
}
