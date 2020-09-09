package kgw.ssafy.study;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class PROGRAMMERS_뉴스클러스터링 {

	public int solution(String str1, String str2) {
		int answer = 0;
		
		Map<String,Integer> str1Map = new HashMap<>();
		Map<String,Integer> str2Map = new HashMap<>();
		
		String pattern = "^[a-zA-Z]*$";

		for (int i = 0; i < str1.length() - 1; ++i) {
			String str = str1.substring(i, i + 2).toLowerCase();
			if (!Pattern.matches(pattern, str))
				continue;

			if(!str1Map.containsKey(str)) {
				str1Map.put(str, 1);
			}
			else {
				str1Map.replace(str, str1Map.get(str) + 1);
			}
		}

		for (int i = 0; i < str2.length() - 1; ++i) {
			String str = str2.substring(i, i + 2).toLowerCase();
			if (!Pattern.matches(pattern, str))
				continue;
			
			if(!str2Map.containsKey(str)) {
				str2Map.put(str, 1);
			}
			else {
				str2Map.replace(str, str2Map.get(str) + 1);
			}
		}
		
		int union = 0;
		int inter = 0;
		
		for(String str : str1Map.keySet()) {
			if(str2Map.containsKey(str)) {
				inter += Math.min(str1Map.get(str),str2Map.get(str));
				union += Math.max(str1Map.get(str),str2Map.get(str));
				
				str2Map.remove(str);
			}
			else {
				union += str1Map.get(str);
			}
		}
		
		for(String str : str2Map.keySet()) {
			union += str2Map.get(str);
		}
		
		if(union == 0 ) return 65536;
		
		answer = (int)( (double) inter / (double)union * 65536);
		
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(new PROGRAMMERS_뉴스클러스터링().solution("aa1+aa2","AAAA12" ));
	}
}
