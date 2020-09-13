package coding_Test_Contest;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LINE_Solution02 {
	public int[] solution(int[] ball, int[] order) {
        int[] answer = new int[ball.length];
        int idx = 0;
        int left = 0;
        int right = ball.length-1;
        Set<Integer> set  = new HashSet<>();
        
        for(int i = 0; i<order.length; ++i){
        	if(order[i] == ball[left]) {
        		answer[idx++] = ball[left++];
        	}
        	else if(order[i] == ball[right]) {
        		answer[idx++] = ball[right--];
        	}
        	else {
        		set.add(order[i]);
        	}
        	
        	while(true) {
        		if(set.contains(ball[left])) {
        			set.remove(ball[left]);
            		answer[idx++] = ball[left++];
            		continue;
            	}
            	else if(set.contains(ball[right])) {
            		set.remove(ball[right]);
            		answer[idx++] = ball[right--];
            		continue;
            	}
        		break;
        	}
        }
        
        return answer;
    }
	public static void main(String[] args) {
		int[] arr = new LINE_Solution02().solution(new int[] {11, 2, 9, 13, 24}, new int[] {9, 2, 13, 24, 11});
		System.out.println(Arrays.toString(arr));
	}
}
