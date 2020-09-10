package problems.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 불량_사용자_2019_KAKAO_겨울_인턴십 {
	private int ans;
	private boolean[] user_visited;
	private boolean[] banned_visited;
	private Set<String> set;

	private boolean check(String user, String banned) {
		boolean flag = true;
		if (user.length() != banned.length())
			flag = false;
		for (int k = 0; k < banned.length() && flag; ++k) {
			if (banned.charAt(k) == '*')
				continue;
			if (banned.charAt(k) != user.charAt(k))
				flag = false;
		}

		return flag;
	}

	private void DFS(String[] user_id, String[] banned_id, List<String> list, int cnt) {
		if (cnt == banned_id.length) {
			String str = "";
			Collections.sort(list);
			
			for(int i = 0; i<list.size(); ++i) {
				str+=list.get(i);
			}
			if(set.add(str)) 
				++ans;
			
			return;
		}

		for (int i = 0; i < user_id.length; ++i) {
			if (user_visited[i])
				continue;

			String user = user_id[i];
			int idx = -1;
			for (int j = 0; j < banned_id.length; ++j) {
				if (banned_visited[j])
					continue;
				String banned = banned_id[j];

				if (check(user, banned)) {
					idx = j;
					break;
				}
			}

			if (idx == -1)
				continue;

			user_visited[i] = true;
			banned_visited[idx] = true;
			list.add(user);
			
			DFS(user_id, banned_id, list, cnt + 1);
			
			list.remove(user);
			user_visited[i] = false;
			banned_visited[idx] = false;
		}
	}

	public int solution(String[] user_id, String[] banned_id) {
		user_visited = new boolean[user_id.length];
		banned_visited = new boolean[banned_id.length];
		set = new HashSet<>();

		DFS(user_id, banned_id, new ArrayList<>(), 0);
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(
				new 불량_사용자_2019_KAKAO_겨울_인턴십().solution(new String[] { "frodo", "fradi", "crodo", "abc123", "frodoc" },
						new String[] { "fr*d*", "*rodo", "******", "******" }));
	}
}
