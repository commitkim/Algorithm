package problems.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 프렌즈4블록_2018_KAKAO_BLIND {
	private int[] moveX = {0,0,1,1};
	private int[] moveY = {0,1,0,1};
	
	public String[] down(int m, int n, String[] board) {
		String[] newBoard = new String[m];
		Arrays.fill(newBoard, "");
		
		for(int i = 0; i<n; ++i) {
			int idx = 0;
			for(int j = m-1; j>=0; --j) {
				if(board[j].charAt(i) == ' ') continue;
				else newBoard[m-1-idx++] += Character.toString(board[j].charAt(i));
			}
			for(int j = m-1-idx; j>=0; --j) {
				newBoard[j] += " ";
			}
		}
		return newBoard;
	}
	
	public void blockBreak(String[] board, List<int[]> list) {
		for(int i = 0; i<list.size(); ++i) {
			int arr[] = list.get(i);
			int x = arr[0];
			int y = arr[1];
			
			for(int j = 0; j<4; ++j) {
				int a = x + moveX[j];
				int b = y + moveY[j];
				
				board[a] = board[a].substring(0, b) + " " + board[a].substring(b+1, board[a].length()); 
			}
		}
	}
	
	public boolean blockCheck(String[] board, int x, int y) {
		char c = board[x].charAt(y);
		for(int i = 1; i<4; ++i) {
			int a = x + moveX[i];
			int b = y + moveY[i];
			
			if(board[a].charAt(b) != c)
				return false;
		}
		
		return true;
	}
	
	public int solution(int m, int n, String[] board) {
        int answer = 0;
        while(true) {
        	List<int[]> list = new ArrayList<>();
        	
        	for(int i = 0; i<m-1; ++i) {
        		for(int j = 0; j<n-1; ++j) {
        			if(board[i].charAt(j)!=' ' && blockCheck(board,i,j))
        				list.add(new int[] {i,j});
        		}
        	}
        	if(list.isEmpty()) break;
        	
        	blockBreak(board,list);
        	board = down(m,n,board);
        }
        
        for(int i = 0; i<m; ++i) {
        	for(int j = 0; j<n; ++j) {
        		if(board[i].charAt(j) == ' ') ++answer;
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int a = new 프렌즈4블록_2018_KAKAO_BLIND().solution(6, 6, new String[] {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA","TTMMMF","TMMTTJ"});
		System.out.println(a);
	}
}
