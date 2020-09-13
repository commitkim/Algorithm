package coding_Test_Contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class KAKAO_Solution02 {

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
		swap(arr,i-1,j);
		int k = n - 1;
		
		while(i<k) {
			swap(arr,i++,k--);
		}
		
		return true;
	}

	public String[] solution(String[] orders, int[] course) {
		List<String> answer = new ArrayList<String>();
		Map<String,Integer> map = new HashMap<>();
		
		for(int i = 0; i < course.length; ++i) {
			int num = course[i];
			
			for(int j = 0; j < orders.length; ++j) {
				int size = orders[j].length(); 
				if(num > size)
					continue;
				
				int idx = size - 1;
				int[] arr = new int[size];
				while(idx >= size-num) arr[idx--] = 1;
				
				do {
					System.out.println(Arrays.toString(arr));
					List<Character> list = new ArrayList<>();
					for(int k = 0; k<size; ++k) {
						if(arr[k] == 1) {
							list.add(orders[j].charAt(k));
						}
					}
					
					Collections.sort(list);
					String str = "";
					for(int k = 0; k<num; ++k) {
						str += Character.toString(list.get(k));
					}
					if(map.containsKey(str)) {
						map.replace(str, map.get(str) + 1);
					}
					else {
						map.put(str, 1);
					}
					
				}while(nextPermutation(arr,size));
			}
			Queue<String> q = new LinkedList<>();
			int max = 0;
			for(String key : map.keySet()) {
				if(max < map.get(key)) {
					q.clear();
					max = map.get(key);
					q.offer(key);
				}
				else if (max == map.get(key)) {
					q.offer(key);
				}
			}
			if(max >= 2){
				int size = q.size();
				for(int k = 0; k<size; ++k) {
					answer.add(q.poll());
				}
			}
			map.clear();
		}
		String[] result = new String[answer.size()];
		Collections.sort(answer);
		
		for(int i = 0; i<result.length; ++i) {
			result[i] = answer.get(i);
		}
		
		
		return result;
	}

	public static void main(String[] args) {
		String[] str = new KAKAO_Solution02().solution(new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[] {2,3,4});
		System.out.println(Arrays.toString(str));
	}
}
