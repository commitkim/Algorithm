package problems.BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BEAKJOON_17471 {
	private static int N;
	private static int[] arr;
	private static boolean[][] graph;
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private static boolean nextPermutation(int[] arr, int N) {
		int i = N-1;
		while(i>0 && arr[i-1] >= arr[i]) --i;
		
		if(i==0) return false;
		
		int j = N-1;
		while(arr[i-1] >= arr[j]) --j;
		
		swap(arr,i-1,j);
		
		int k = N-1;
		while(k>i) {
			swap(arr,k--,i++);
		}
		
		return true;
	}
	
	private static boolean checkConnection(int[] selected) {
		int[] arr = selected.clone();
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0; i<arr.length; ++i) {
			if(arr[i] == 0) {
				q.offer(i);
				break;
			}
		}
		
		while(!q.isEmpty()) {
			int num = q.poll();
			
			if(arr[num] != 0) continue;
			arr[num] = 2;
			for(int i = 0; i<N; ++i) {
				if(graph[num][i]) q.offer(i);
			}
		}
		
		q.clear();
		for(int i = 0; i<arr.length; ++i) {
			if(arr[i] == 1) {
				q.offer(i);
				break;
			}
		}
		
		while(!q.isEmpty()) {
			int num = q.poll();
			
			if(arr[num] != 1) continue;
			arr[num] = 2;
			for(int i = 0; i<N; ++i) {
				if(graph[num][i]) q.offer(i);
			}
		}
		
		return Arrays.stream(arr).sum() == 2*arr.length;
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		graph = new boolean[N][N];
		int answer = Integer.MAX_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i<N; ++i) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			for(int j = 0; j<size; ++j) {
				graph[i][Integer.parseInt(st.nextToken())-1] = true;
			}
		}
		
		for(int i = 1; i<N; ++i) {
			int[] selected = new int[N];
			
			for(int j = N-1; j>=N-i; --j) selected[j] = 1;
			
			do {
				if(!checkConnection(selected)) continue;
				
				int A = 0,B = 0;
				for(int j = 0; j<N; ++j) {
					if(selected[j] == 0) {
						A += arr[j];
					}
					else {
						B += arr[j];
					}
				}
				answer = Math.min(answer, Math.abs(A-B));
				
			}while(nextPermutation(selected,N));
		}
		
		System.out.println(answer==Integer.MAX_VALUE? -1 : answer);
		
	}
}
