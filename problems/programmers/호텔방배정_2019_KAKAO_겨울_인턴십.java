package problems.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 호텔방배정_2019_KAKAO_겨울_인턴십 {
	public long[] solution(long k, long[] room_number) {
        int size = room_number.length;
        Map<Long,Long> map = new HashMap<>();
        
        long[] answer = new long[size];
        for(int i = 0; i<size; ++i) {
        	List<Long> list = new ArrayList<>();
        	long room = room_number[i];
        	
        	list.add(room);
    		while(true) {
    			if(!map.containsKey(room)) {
    				map.put(room,room+1);
    				break;
    			}
    			room = map.get(room);
    			list.add(room);
    		}
    		for(int j = 0; j<list.size(); ++j) {
    			map.replace(list.get(j),room+1);
    		}
    		answer[i] = room;
        }
        return answer;
    }
	public static void main(String[] args) {
		long[] arr = new 호텔방배정_2019_KAKAO_겨울_인턴십().solution(10L, new long[] {1,3,4,1,3,1});
		System.out.println(Arrays.toString(arr));
	}
}	
