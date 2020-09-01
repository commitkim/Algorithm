package problems.SWExpertAcademy;

import java.util.Scanner;

public class Algo_9843 {
	public static void main(String[] args) {
		String data = "\r\n" + 
				"5\r\n" + 
				"1\r\n" + 
				"3\r\n" + 
				"6\r\n" + 
				"14\r\n" + 
				"762078456028";
		Scanner sc = new Scanner(data);
		int TC = sc.nextInt();
		
		for(int test_case = 1; test_case<=TC; ++test_case) {
			long N = sc.nextLong();
			long line = (long)Math.sqrt(N*2);
			if(line*(line+1)/2 != N) 
				line = -1;

			System.out.println("#" + test_case + " " + (line));
		}
		
	}
}
