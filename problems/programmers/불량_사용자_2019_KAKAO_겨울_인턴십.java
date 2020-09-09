package problems.programmers;

public class 불량_사용자_2019_KAKAO_겨울_인턴십 {
	public int solution(String[] user_id, String[] banned_id) {
        int answer = 1;
        
        MATCH:
        for(int i = 0; i<banned_id.length; ++i) {       	String id = banned_id[i];
        	int count = 0;
        	
        	for(int j = 0; j<user_id.length; ++j) {
        		if(id.length() != user_id[j].length())
        			continue;
        		for(int k = 0; k<id.length(); ++k) {
        			if(id.charAt(k) == '*') continue;
        			if(id.charAt(k) != user_id[j].charAt(k)) continue MATCH;
        		}
        		++count;
        	}
        	answer *= count;
        }
        
        return answer;
    }
	public static void main(String[] args) {
		
	}
}
