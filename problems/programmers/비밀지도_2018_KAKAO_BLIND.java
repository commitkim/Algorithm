package problems.programmers;

import java.util.Arrays;

public class 비밀지도_2018_KAKAO_BLIND {
	public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i<n; ++i) {
        	int and = arr1[i] | arr2[i];
        	int temp = 1 << n-1;
        	String str = "";
        	for(int j = 0; j<n; ++j) {
        		if((and & temp) == temp) str += "#";
        		else str += " ";
        		temp >>= 1;
        	}
        	answer[i] = str;
        }
        
        return answer;
    }
	public static void main(String[] args) {
		String[] arr = new 비밀지도_2018_KAKAO_BLIND().solution(5, new int[] {9,20,28,18,11}, new int[] {30,1,21,17,28});
		System.out.println(Arrays.toString(arr));
	}
}
