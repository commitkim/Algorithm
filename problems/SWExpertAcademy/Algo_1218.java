package problems.SWExpertAcademy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Algo_1218 {
	public static void main(String[] args) throws FileNotFoundException {
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		int T = 10;
		
		for(int test_case = 1; test_case<=T; ++test_case) {
			int num = Integer.parseInt(sc.nextLine());
			String brackets = sc.nextLine();
			int answer = 1;
			
			Stack<Character> s = new Stack<Character>();
			
			for(int i = 0; i<num; ++i) {
				switch(brackets.charAt(i)) {
				case '(':
				case '[':
				case '{':
				case '<':
					s.push(brackets.charAt(i));
					break;
				case ')':
					if(s.empty() || s.peek() != '(') {
						answer = 0;
						break;
					}
					s.pop();
					break;
				case ']':
					if(s.empty() || s.peek() != '[') {
						answer = 0;
						break;
					}
					s.pop();
					break;
				case '}':
					if(s.empty() || s.peek() != '{') {
						answer = 0;
						break;
					}
					s.pop();
					break;
				case '>':
					if(s.empty() || s.peek() != '<') {
						answer = 0;
						break;
					}
					s.pop();
					break;
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}
