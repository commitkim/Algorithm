package coding_Test_Contest;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PROGRAMMERS_Solution01 {
	public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length * numbers.length];
        
        Set<Integer> set = new HashSet<>();
        int idx = 0;
        for(int i = 0; i<numbers.length; ++i) {
        	for(int j = 0; j<numbers.length; ++j) {
        		if(i!=j && set.add(numbers[i] + numbers[j])) {
        			answer[idx++] = numbers[i] + numbers[j];
        		}
        	}
        }
        
        answer = Arrays.copyOf(answer, idx);
        Arrays.sort(answer);
        
        return answer;
    }
}
