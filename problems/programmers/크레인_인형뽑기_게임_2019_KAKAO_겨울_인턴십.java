package problems.programmers;

import java.util.Stack;

public class 크레인_인형뽑기_게임_2019_KAKAO_겨울_인턴십 {
	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		int seroSize = board.length;
		int garoSize = board[0].length;
		Stack<Integer>[] stack = new Stack[garoSize];
		
		for(int i = 0; i<garoSize; ++i) {
			stack[i] = new Stack<Integer>();
			for(int j = seroSize -1 ; j>=0 && board[j][i] != 0; --j) {
				stack[i].push(board[j][i]);
			}
		}
		
		Stack<Integer> bucket = new Stack<Integer>();
		
		for(int i = 0; i<moves.length; ++i) {
			int idx = moves[i] - 1; 
			if(stack[idx].isEmpty())
				continue;
			
			if(bucket.isEmpty())
				bucket.push(stack[idx].pop());
			else {
				if(bucket.peek() == stack[idx].peek()) {
					bucket.pop();
					stack[idx].pop();
					++answer;
				}
				else {
					bucket.push(stack[idx].pop());
				}
			}
			System.out.println(bucket.toString());
		}
		
		return answer*2;
	}
	public static void main(String[] args) {
		int i = new 크레인_인형뽑기_게임_2019_KAKAO_겨울_인턴십().solution(new int[][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int [] {1,5,3,5,1,2,1,4});
		System.out.println(i);
		
		/*
		 * [[0,0,0,0,0]
		 * ,[0,0,1,0,3]
		 * ,[0,2,5,0,1]
		 * ,[4,2,4,4,2]
		 * ,[3,5,1,3,1]]
		 */
	}
}
