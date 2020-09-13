package coding_Test_Contest;
import java.util.Arrays;

public class LINE_Solution03 {
	public int makeSum(String num,int middle) {
		int num1 = Integer.parseInt(num.substring(0, middle));
		int num2 = Integer.parseInt(num.substring(middle, num.length()));
		
		return num1+num2;
	}
	
	public int[] solution(int n) {
        int[] answer = new int[] {0,0};
        while(n>=10) {
        	++answer[0];
        	String num = String.valueOf(n);
        	
        	int middle = num.length()/2;
        	int left = middle, right = middle;
        	while(left>0 && num.charAt(--left) == '0');
        	while(right<=num.length() && num.charAt(right++) == '0');
        	
        	if(right-1 == num.length()) {
        		n = makeSum(num,left);
        	}
        	else if(left == 0) {
        		n = makeSum(num,right-1);
        	}
        	else {
        		n = Math.min(makeSum(num,left), makeSum(num,right-1));
        	}
        }
        
        answer[1] = n;
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new LINE_Solution03().solution(73425)));
	}
}
