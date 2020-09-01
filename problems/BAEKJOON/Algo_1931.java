package problems.BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Algo_1931 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<int[]> list = new ArrayList<int[]>(); 
		for(int i = 0; i <N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			list.add(new int[] { start, end });
			
		}
		
		list.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return (o1[1] == o2[1])? o1[0] - o2[0] : o1[1] - o2[1];
			}
		});
		
		int count = 0;
		int[] room = new int[N];
		int[] answer = new int[N];
		++answer[count];
		room[count++] = list.get(0)[1];
		
		//list.stream().forEach(ar -> System.out.println(ar[0] + " " + ar[1]));
		
		main:
		for(int i = 1; i<N; ++i) {
			int[] plan = list.get(i);
			
			for(int j = 0; j<count; ++j) {
				if(room[j] <= plan[0] ) {
					room[j] = plan[1];
					++answer[j];
					continue main;
				}
			}
			room[count++] = plan[1];
		}
		
		System.out.println(Arrays.stream(answer).max().getAsInt());
	}
}
