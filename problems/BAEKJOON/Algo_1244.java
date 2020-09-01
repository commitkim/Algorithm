package problems.BAEKJOON;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo_1244 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] s = new int[101];
		
		for(int i = 1; i<=N; ++i) {
			s[i] = sc.nextInt();
		}
		
		int people = sc.nextInt();

		for(int i = 0; i<people; ++i) {
			int sex = sc.nextInt();
			int number = sc.nextInt();
			
			switch(sex) {
			case 1:
				for(int j = 1; j<=N; ++j) {
					if(j%number == 0) {
						s[j] = (s[j] == 1)? 0 : 1;
					}
				}
				break;
			case 2:
				int leftIdx = number;
				int rightIdx = number;
				
				while(true) {
					--leftIdx;
					++rightIdx;
					if(leftIdx <= 0 || rightIdx > N || s[leftIdx] != s[rightIdx]) {			
						break;
					}
				}
				++leftIdx;
				--rightIdx;

				for(int j = leftIdx; j<=rightIdx; ++j) {
					s[j] = (s[j] == 1)? 0 : 1;
				}
				
				break;
			}
			
		}
		
		for(int i = 1; i<=N; ++i) {
			System.out.print(s[i] + " ");
			if(i%20 == 0)
				System.out.println();
		}

	}
}
