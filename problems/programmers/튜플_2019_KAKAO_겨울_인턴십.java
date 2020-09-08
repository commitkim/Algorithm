package problems.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TupleInfo implements Comparable<TupleInfo>{
	String[] str;
	int length;
	public TupleInfo(String[] str, int length) {
		this.str = str;
		this.length = length;
	}
	@Override
	public int compareTo(TupleInfo o) {
		// TODO Auto-generated method stub
		return this.length - o.length;
	}
}

public class 튜플_2019_KAKAO_겨울_인턴십 {
	public int[] solution(String s) {
        Set<Integer> set = new HashSet<Integer>();
        
        List<TupleInfo> list = new ArrayList<>(); 
		String[] str = s.substring(2,s.length()-2).split("\\},\\{");
        for(int i = 0; i<str.length; ++i) {
        	String[] temp = str[i].split(",");
        	list.add(new TupleInfo(temp,temp.length));
        }
        list.sort(null);
        int[] answer = new int[list.get(list.size()-1).length];
        
        for(int i = 0; i<list.size(); ++i) {
        	String[] numbers = list.get(i).str;
        	for(int j = 0; j< numbers.length; ++j) {
        		if(!set.add(Integer.parseInt(numbers[j]))) 
        			continue;
        		
        		answer[i] = Integer.parseInt(numbers[j]);
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] a = new 튜플_2019_KAKAO_겨울_인턴십().solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
		System.out.println(Arrays.toString(a));
	}
}
