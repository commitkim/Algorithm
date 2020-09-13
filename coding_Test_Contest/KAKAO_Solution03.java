package coding_Test_Contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KAKAO_Solution03 {
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public boolean nextPermutation(int[] arr, int n) {
		int i = n - 1;
		while (i > 0 && arr[i - 1] >= arr[i])
			--i;
		if (i == 0)
			return false;

		int j = n - 1;
		while (arr[i - 1] >= arr[j])
			--j;
		swap(arr, i - 1, j);
		int k = n - 1;

		while (i < k) {
			swap(arr, i++, k--);
		}

		return true;
	}

	public int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		int size = info.length;
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < size; ++i) {
			String[] str = info[i].split(" ");
			for (int j = 1; j <= 4; ++j) {
				int[] arr = new int[4];

				int idx = 4;
				while (idx >= 4 - j)
					arr[idx--] = 1;

				do {
					String[] temp = str.clone();
					for(int k = 0; k<4; ++k) {
						if(arr[k] == 1) {
							temp[k] = "-";
						}
					}
					String allStr = "";
					for(int k =0; k<4; ++k) {
						allStr += temp[k];
					}
					if(map.containsKey(allStr)) {
						map.replace(allStr, map.get(allStr) +1);
					}
					else {
						map.put(allStr,1);
					}
				} while (nextPermutation(arr, 4));

			}
		}

		for (int i = 0; i < query.length; ++i) {
			String[] str = query[i].split(" ");
		}

		return answer;
	}

	public static void main(String[] args) {
		int[] a = new KAKAO_Solution03().solution(
				new String[] { "java backend junior pizza 150", "python frontend senior chicken 210",
						"python frontend senior chicken 150", "cpp backend senior pizza 260",
						"java backend junior chicken 80", "python backend senior chicken 50" },
				new String[] { "java and backend and junior and pizza 100",
						"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
						"- and backend and senior and - 150", "- and - and - and chicken 100",
						"- and - and - and - 150" });
		System.out.println(Arrays.toString(a));
	}
}
