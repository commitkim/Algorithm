package problems.BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Algo_2961 {
	private static ArrayList<int[]> list;
	private static ArrayList<int[]> selected;
	private static int answer = Integer.MAX_VALUE;
	
	private static void solve(int start, int cnt, int max) {
		if(cnt == max) {
			int tmp = getDiff();
			answer = (answer<tmp)? answer : tmp;
			return;
		}
		for(int i = start; i<list.size(); ++i) {
			selected.add(list.get(i));
			solve(i+1,cnt+1,max);
			selected.remove(selected.size()-1);
		}
	}
	
	private static int getDiff() {
		int sin = 1;
		int ssn = 0;
		
		for(int i = 0 ; i<selected.size(); ++i) {
			sin *= selected.get(i)[0];
			ssn += selected.get(i)[1];
		}
		
		return Math.abs(sin - ssn);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		list = new ArrayList<int[]>();
		
		for(int i = 0; i<N; ++i) {
			String[] str = br.readLine().split(" ");
			
			list.add(new int[] {Integer.parseInt(str[0]),Integer.parseInt(str[1])} );
		}
		
		for(int i = 1; i<=N; ++i) {
			selected = new ArrayList<int[]>();
			solve(0,0,i);
		}
		
		System.out.println(answer);
	}
}
