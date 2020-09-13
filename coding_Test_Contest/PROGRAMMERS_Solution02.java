package coding_Test_Contest;
public class PROGRAMMERS_Solution02 {
	public int[] solution(int n) {
        
        int[][] arr = new int[n][n];
        
        int number = 1;
        int count = 0;
        while(true) {
        	if(count*2>=n) break;
        	if(arr[count*2][count] != 0)
        		break;
        	for(int i = count*2; i<n-count; ++i) {
        		arr[i][count] = number++;
        	}
        	for(int i = count+1; i<n-(count*2); ++i) {
        		arr[n-count-1][i] = number++;
        	}
        	for(int i = 1; i<=n-(count+1)*2-count; ++i) {
        		arr[n-count-i-1][n-(count*2)-i-1] = number++;
        	}
        	++count;
        	
        }
        
        int[] answer = new int[number-1];
        int idx = 0;
        
        for(int i = 0; i<n; ++i) {
        	for(int j =0; j<n; ++j) {
        		if(arr[i][j] == 0)
        			break;
        		answer[idx++] = arr[i][j];
        	}
        }

        return answer;
    }
	public static void main(String[] args) {
		new PROGRAMMERS_Solution02().solution(4);
	}
}
