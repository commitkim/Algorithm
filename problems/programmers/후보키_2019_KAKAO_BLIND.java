package problems.programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 후보키_2019_KAKAO_BLIND {

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public boolean nextPermutation(int[] arr, int N) {
		int i = N - 1;
		while (i > 0 && arr[i - 1] >= arr[i])
			--i;

		if (i == 0)
			return false;

		int j = N - 1;
		while (arr[i - 1] >= arr[j])
			--j;

		swap(arr, i - 1, j);

		int k = N - 1;
		while (k > i) {
			swap(arr, i++, k--);
		}

		return true;
	}

	public int solution(String[][] relation) {
		int answer = 0;
		int size = relation[0].length;
		List<int[]> list = new ArrayList<>();
		
		for (int i = 1; i <= size; ++i) {
			int[] selected = new int[size];
			for (int j = size - 1; j >= size - i; --j)
				selected[j] = 1;
			
			
			do {
				Set<String> set = new HashSet<>();
				boolean flag = true;
				
				for(int j = 0; j<list.size(); ++j) {
					int[] arr = list.get(j);
					int sameCount = 0;
					int oneCount = 0;
					for(int k = 0; k<arr.length; ++k) {
						oneCount = (arr[k] == 1)? oneCount+1 : oneCount;
						sameCount = (selected[k] + arr[k] == 2)? sameCount+1:sameCount;
					}
					if(oneCount == sameCount) {
						flag = false;
						break;
					}
				}
				
				for (int j = 0; j < relation.length && flag; ++j) {
					String str = "";
					for (int k = 0; k < relation[j].length; ++k) {
						if (selected[k] == 1) {
							str += relation[j][k];
						}
					}
					if(!set.add(str))
						flag = false;
				}
				if(flag) {
					list.add(selected.clone());
					++answer;
				}

			}while (nextPermutation(selected, size));

		}
		return answer;
	}

	public static void main(String[] args) {
		int a = new 후보키_2019_KAKAO_BLIND().solution(new String[][] {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}});
		System.out.println(a);
	}
}
