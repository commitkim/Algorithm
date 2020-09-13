package problems.programmers;

import java.util.HashMap;
import java.util.Map;

public class 캐시_2018_KAKAO_BLIND {
	public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        int size = cities.length;
        
        Map<String,Integer> map = new HashMap<>();
        
        for(int i = 0; i<size; ++i) {
        	String city = cities[i].toLowerCase();
        	if(map.containsKey(city)) {
        		++answer;
        		map.replace(city, i);
        		continue;
        	}

        	if(map.size() == cacheSize) {
        		int min = Integer.MAX_VALUE;
        		String key = "";
        		for(String str : map.keySet()) {
        			if(min > map.get(str)) {
        				min = map.get(str);
        				key = str;
        			}
        		}
        		map.remove(key);	
        	}
        	if(map.size() < cacheSize)
        		map.put(city, i);
        	
    		answer += 5;
        }
        
        return answer;
    }
}
