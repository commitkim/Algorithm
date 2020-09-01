package problems.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public String[] solution(String[] record) {
        List<String> list = new ArrayList<>();
    	
        HashMap<String,String> map = new HashMap<>();
        for(String str : record) {
        	String[] messages = str.split(" ");
        	switch(messages[0]) {
        	case "Enter":
        		map.put(messages[1], messages[2]);
        		list.add(messages[1] + "/" + "님이 들어왔습니다.");
        		break;
        	case "Leave":
        		list.add(messages[1] + "/" + "님이 나갔습니다.");
        		break;
        	case "Change":
        		map.replace(messages[1], messages[2]);
        		break;
        	}
        }

        int size = list.size();
        
        for(int i = 0; i<size; ++i) {
        	String[] messages = list.get(i).split("/");
        	messages[0] = map.get(messages[0]);
        	list.set(i, messages[0]+messages[1]);
        }
        
        String[] answer = new String[list.size()]; 
		list.toArray(answer);
        
        return answer;
    }
}

public class 오픈채팅방_2019_KAKAO_BLIND {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution().solution(new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"})));
	}
}
