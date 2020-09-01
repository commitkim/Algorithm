package problems.SWExpertAcademy;

import java.util.Arrays;
import java.util.Scanner;

public class Algo_1210 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		
		for(int test_case = 1; test_case <= T; ++test_case) {
			int num = sc.nextInt();
			int[] box = new int[100];
			int diff = 0;
			
			for(int i=0; i<100; ++i) {
				box[i] = sc.nextInt();
			}
			
			for(int i = 0; i<num; ++i) {
				Arrays.sort(box);
				--box[99];
				++box[0];
				
				Arrays.sort(box);
				diff = box[99] - box[0];
				if(diff == 0 || diff == 1)
					break;
			}
			
			System.out.println("#" + test_case + " " + diff);
			
		}
	}
}
