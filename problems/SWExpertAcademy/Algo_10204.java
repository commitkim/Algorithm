package problems.SWExpertAcademy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

import javax.sound.sampled.ReverbType;

public class Algo_10204 {
	public static void main(String[] args) {
		String data = "3\r\n" + 
				"3\r\n" + 
				"20 10\r\n" + 
				"20 20\r\n" + 
				"20 30\r\n" + 
				"3\r\n" + 
				"30 30\r\n" + 
				"10 10\r\n" + 
				"20 20\r\n" + 
				"6\r\n" + 
				"1 1000000000\r\n" + 
				"1 1000000000\r\n" + 
				"1 1000000000\r\n" + 
				"1 1000000000\r\n" + 
				"1 1000000000\r\n" + 
				"1 1000000000";
		Scanner sc = new Scanner(data);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case<=T; ++test_case) {
			int N = sc.nextInt();
			int[][] arr = new int[N][2];
			long jungHappy = 0;
			long yongHappy = 0;

			for(int i = 0; i<N; ++i) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}
//			Arrays.sort(arr,Comparator.comparingInt(o1 -> o1[0]+o1[1]));
//			
//			Arrays.sort(arr, new Comparator<int[]>() {
//			    @Override
//			    public int compare(int[] o1, int[] o2) {
//			        return Integer.compare(o2[0] + o2[1], o1[0] + o1[1]);
//			    }
//			});
			
			Arrays.sort(arr, (int[] o1, int[] o2) -> (o2[0]+o2[1]) - (o1[0]+o1[1])); // 뒤에꺼에서 앞에꺼 빼면 내림차순
			
//			Arrays.sort(arr, Comparator.comparingInt(o1 -> o1[0]+o1[1]).reversed());
			
			System.out.println(Arrays.deepToString(arr));
			for(int i = 0; i<N; ++i) {
				if((i+1)%2 == 1) {
					jungHappy += arr[i][0];
					
				}
				else {
					yongHappy += arr[i][1];
				}
			}
			
			System.out.println("#" + test_case + " " + (jungHappy-yongHappy));
			
		}
	}
}
