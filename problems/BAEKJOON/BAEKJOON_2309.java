package problems.BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BAEKJOON_2309 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
		int sum = 0;
		for (int i = 0; i < 9; ++i) {
			list.add(Integer.parseInt(br.readLine()));
			sum += list.get(i);
		}

		for (int i = 0; i < 9; ++i) {
			for (int j = i + 1; j < 9; ++j) {
				if (sum - list.get(i) - list.get(j) != 100)
					continue;
				list.remove(i);
				list.remove(j-1);
				Collections.sort(list);
				list.stream().forEach(e -> System.out.println(e));
				return;
			}
		}
	}
}
