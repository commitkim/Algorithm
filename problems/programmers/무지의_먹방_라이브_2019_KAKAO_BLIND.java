package problems.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Food {
	int num;
	long remain;

	Food(int num, long remain) {
		this.num = num;
		this.remain = remain;
	}
}

public class 무지의_먹방_라이브_2019_KAKAO_BLIND {
	public int solution(int[] food_times, long k) {
		int answer = 0;
		long eaten = 0;
		long sum = 0;
		int size = food_times.length;
		List<Food> list = new ArrayList<>();

		for (int i = 0; i < size; ++i) {
			list.add(new Food(i + 1, food_times[i]));
			sum += food_times[i];
		}
		if (sum <= k)
			return -1;

		Collections.sort(list, (o1, o2) -> (int)(o1.remain - o2.remain) * -1);

		while (true) {
			size = list.size();
			if (k > (list.get(size - 1).remain - eaten) * size) {
				k -= (list.get(size - 1).remain - eaten) * size;
				eaten = list.get(size - 1).remain;
				list.remove(size-1);
			} else
				break;
		}

		Collections.sort(list, (o1, o2) -> o1.num - o2.num);
		answer = list.get((int) (k % list.size())).num;

		return answer;
	}

	public static void main(String[] args) {
		int a = new 무지의_먹방_라이브_2019_KAKAO_BLIND().solution(new int[] { 3, 1, 2 }, 5);
		System.out.println(a);

	}
}
