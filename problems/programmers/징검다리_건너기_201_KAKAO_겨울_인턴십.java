package problems.programmers;

import java.util.Arrays;

public class 징검다리_건너기_201_KAKAO_겨울_인턴십 {
	public int solution(int[] stones, int k) {
		int answer = 0;
		int size = stones.length;
		
		int min = 1;
		int max = Arrays.stream(stones).max().getAsInt();
		
		while (min!=max && min<max) {
			int middle = (min+max)/2;
			boolean flag = true;
			int count = 0;
			
			for(int i =0; i<size; ++i) {
				if(stones[i] - middle <= 0) {
					++count;
				}
				else {
					count = 0;
				}
				if(count == k) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				min = middle+1;
			}
			else {
				max = middle;
			}
		}
		
		answer = max;

		return answer;
	}
	public static void main(String[] args) {
		int a = new 징검다리_건너기_201_KAKAO_겨울_인턴십().solution(new int[] {2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3);
		System.out.println(a);
	}
}
