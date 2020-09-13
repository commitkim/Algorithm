package coding_Test_Contest;

import java.util.regex.Pattern;

public class KAKAO_Solution01 {
	public String solution(String new_id) {
		String answer = "";
		String pattern = "^[0-9a-z\\-\\_\\.]*$";

		new_id = new_id.toLowerCase();
		for (int i = 0; i < new_id.length(); ++i) {
			String str = Character.toString(new_id.charAt(i));
			if (!Pattern.matches(pattern, str)) {
				continue;
			}
			answer += str;
		}
		new_id = answer;
		answer = "";
		for (int i = 0; i < new_id.length(); ++i) {
			String str = Character.toString(new_id.charAt(i));
			if (i>0 && str.equals(".") && new_id.charAt(i - 1) == '.') {
				continue;
			}
			answer += str;
		}
		if (answer.length() != 0 && answer.charAt(0) == '.')
			answer = answer.substring(1, answer.length());
		if (answer.length() != 0 && answer.charAt(answer.length() - 1) == '.')
			answer = answer.substring(0, answer.length() - 1);
		if (answer.length() == 0)
			answer = "a";

		if(answer.length() >= 16) {
			answer = answer.substring(0,15);
			if(answer.charAt(answer.length()-1) == '.')
				answer = answer.substring(0,14);
		}
		if(answer.length() <= 2) {
			for(int i = answer.length(); i<3; ++i)
				answer += Character.toString(answer.charAt(answer.length()-1));
		}

		return answer;
	}

	public static void main(String[] args) {
		String str = new KAKAO_Solution01().solution("...!@BaT#*..y.abcdefghijklm");
		System.out.println(str);
	}
}
