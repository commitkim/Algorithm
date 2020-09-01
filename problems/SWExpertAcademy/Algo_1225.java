package problems.SWExpertAcademy;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo_1225 {
	public static void main(String[] args) {
		String data = "1\r\n" + 
				"9550 9556 9550 9553 9558 9551 9551 9551 \r\n" + 
				"2\r\n" + 
				"2419 2418 2423 2415 2422 2419 2420 2415 \r\n" + 
				"3\r\n" + 
				"7834 7840 7840 7835 7841 7835 7835 7838 \r\n" + 
				"4\r\n" + 
				"4088 4087 4090 4089 4093 4085 4090 4084 \r\n" + 
				"5\r\n" + 
				"2945 2946 2950 2948 2942 2943 2948 2947 \r\n" + 
				"6\r\n" + 
				"670 667 669 671 670 670 668 671 \r\n" + 
				"7\r\n" + 
				"8869 8869 8873 8875 8870 8872 8871 8873 \r\n" + 
				"8\r\n" + 
				"1709 1707 1712 1712 1714 1710 1706 1712 \r\n" + 
				"9\r\n" + 
				"10239 10248 10242 10240 10242 10242 10245 10235 \r\n" + 
				"10\r\n" + 
				"6580 6579 6574 6580 6583 6580 6577 6581 \r\n" + 
				"";
		Scanner sc = new Scanner(data);
//		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case<=10; ++test_case) {
			int T = sc.nextInt();
			Queue<Integer> q = new LinkedList<Integer>();
			for(int i = 0; i<8; ++i) {
				q.offer(sc.nextInt());
			}
			int count = 0;
			int tmp = -1;
			while(tmp != 0) {
				tmp = q.peek() - (count++%5 + 1);
				q.poll();
				q.offer((tmp<=0)? 0 : tmp);
			}
			
			System.out.print("#"+test_case + " ");
			
			Iterator<Integer> it = q.iterator();
			
			while(it.hasNext()) {
				System.out.print(it.next() + " ");
			}
			System.out.println();
			
		}
	}
}
