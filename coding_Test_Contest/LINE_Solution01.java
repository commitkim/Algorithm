package coding_Test_Contest;

import java.util.HashSet;
import java.util.Set;

public class LINE_Solution01 {
	public int solution(int[][] boxes) {
        int count = 0;
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<boxes.length; ++i){
            if(!set.add(boxes[i][0])){
                set.remove(boxes[i][0]);
                ++count;
            }
            if(!set.add(boxes[i][1])){
                set.remove(boxes[i][1]);
                ++count;
            }
        }
        
        return boxes.length-count;
    }
}
