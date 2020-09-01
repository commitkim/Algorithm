package problems.SWExpertAcademy;

import java.util.LinkedList;
import java.util.Scanner;

public class Algo_4112 {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		
		String data = "\r\n" + 
				"3\r\n" + 
				"5 2\r\n" + 
				"13 32\r\n" + 
				"100 1000";
		
		Scanner sc = new Scanner(data);
		
		int T  = sc.nextInt();
		for(int test_case = 1; test_case<=T; ++test_case) {
			int minji = sc.nextInt();
			int treasure = sc.nextInt();
			int answer = 0;
			
			int start = (minji<=treasure)? minji : treasure;
			int target = (minji>treasure)? minji : treasure;
			
			int line = 1;
			int left = 1;
			int right =1;
			
			int startLine = 0;
			int targetLine = 0;
			
			while(startLine == 0 || targetLine == 0) {
				if(left <= start && right>= start) 
					startLine = line;
				
				if(left <= target && right>= target) {
					targetLine = line;
				}
					
				
				left += line;
				right += (line + 1);
				
				++line;
			}
			
			//System.out.println(startLine + " " + targetLine);
			
			left = start;
			right = start;
			line = startLine;
			
			while(answer == 0) {
				if(targetLine == line) {
					if(left<=target && right>=target) {
						answer = targetLine - startLine;
					}
					else {
						answer = targetLine - startLine + Math.min(Math.abs(target - left),Math.abs(right - target));
					}
					break;
				}
				//System.out.println(left);
				
				left += line;
				right += (line + 1);
				
				++line;
				
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}
