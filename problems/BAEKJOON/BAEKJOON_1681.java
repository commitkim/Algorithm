package problems.BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_1681 {
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		String L = st.nextToken();
		
		int num = 1;
		for(; N!=0; ++num) {
			if(String.valueOf(num).contains(L)) continue;
			else --N;
		}
		System.out.println(num-1);

	}
}
