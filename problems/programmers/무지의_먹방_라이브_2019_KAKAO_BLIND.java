package problems.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Food implements Comparable<Food>{
	int num, remain;
	Food(int num, int remain){
		this.num = num;
		this.remain = remain;
	}
	@Override
	public int compareTo(Food o) {
		return this.remain - o.remain;
	}
}

public class 무지의_먹방_라이브_2019_KAKAO_BLIND {
	public int solution(int[] food_times, long k) {
        int answer = 0;
        int eaten = 1;
        int cursor = 0;
        int size = food_times.length;
        List<Food> list = new ArrayList<>();
        
        for(int i = 0; i<size; ++i) 
        	list.add(new Food(i,food_times[i]));
        
        
        while(k>-1) {
        	int min = Collections.min(list).remain;
	        if(k > min * list.size()) {
	        	eaten = min;
	        	k -= min * size;
	        	
	        	Iterator<Food> iter = list.iterator();
	        	
	        	while(iter.hasNext()) {
	        		Food food = iter.next();
	        		int remain = food.remain - eaten;
	        		if(remain == 0) iter.remove();
	        	}
	        }
	        else {
	        	Iterator<Food> iter = list.iterator();
	        	
	        	while(iter.hasNext() && k>-1) {
	        		--k;
	        		Food food = iter.next();
	        		int remain = food.remain - eaten;
	        		if(remain == 0) iter.remove();
	        		else {
	        			cursor = food.num;
	        		}
	        	}
	        	++eaten;
	        }
	        
        }
        answer = cursor+1;
        
        return answer;
    }
	
	public static void main(String[] args) {
		int a = new 무지의_먹방_라이브_2019_KAKAO_BLIND().solution(new int[] {3, 1,2},5);
		System.out.println(a);
		
	}
}
