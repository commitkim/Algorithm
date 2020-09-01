package problems.SWExpertAcademy;

import java.util.Scanner;

public class Algo_3499 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case<=T; ++test_case) {
			int N = sc.nextInt();
			sc.nextLine();
			int half = (N%2 == 0)? N/2 : N/2+1;
			String[] deck = sc.nextLine().split(" ");
			
			int leftIdx = 0;
			int rightIdx = half;
			
			System.out.print("#" + test_case + " ");
			
			for(int i = 1; i<=N; ++i) {
				System.out.print(((i%2 == 1)? deck[leftIdx] : deck[rightIdx]) + " ");
				
				if(i%2 == 1) ++leftIdx;
				else ++rightIdx;
			}
			System.out.println();
		}
		sc.close();
	}
}
