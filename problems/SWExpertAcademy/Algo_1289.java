package problems.SWExpertAcademy;
import java.util.Scanner;
import java.io.FileInputStream;

class Algo_1289 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			String bits;
			int idx = 0;
			int answer = 0;
			bits = sc.next();
			char bit = '0';

			for (int i = 0; i < bits.length(); ++i) {
				if (bits.charAt(idx++) == bit) {
					continue;
				}
				else {
					bit = (bit=='0')? '1' : '0';
					++answer;
				}
					
			}
			
			System.out.println("#"+test_case + " " + answer);
		}
	}
}