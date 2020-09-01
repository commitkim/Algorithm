package problems.SWExpertAcademy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Algo_1223 {
	
	public static int getPriority(char c) {
		switch(c) {
		case '*': return 2;
		default: return 1;
		}
	}
	
	public static int calc(int num1, int num2, char c) {
		switch(c) {
		case '*': return (num1*num2);
		default: return (num1+num2);
		}
	}
	
	public static void main(String[] args) throws ScriptException, FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("input6.txt"));
		
		Stack<Character> s = new Stack<Character>();
		
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		//String infix = "3+2*(4+5)";
		
		
		int T = 10;
		for(int test_case = 1; test_case<=T; ++test_case) {
			int N = Integer.parseInt(sc.nextLine());
			String str = sc.nextLine();
			System.out.println(engine.eval(str));
//			
//			String result = "";
//			
//			for(int i = 0; i<N; ++i) {
//				switch(str.charAt(i)) {
//				case '+':
//				case '*':
//					if(!s.empty() && getPriority(s.peek()) >= getPriority(str.charAt(i))) {
//						switch(getPriority(str.charAt(i))){
//							case 1:
//								while(!s.empty()) {
//									result += s.pop();
//								}
//							case 2:
//								while(!s.empty() && getPriority(s.peek()) != 1) {
//									result += s.pop();
//								}
//						}
//					}
//					s.push(str.charAt(i));
//					break;
//				default :
//					result += str.charAt(i);
//				}
//			}
//			while(!s.empty()) {
//				result += s.pop();
//			}
//			
//			///////////////////////
//			
//			Stack<Integer> is = new Stack<Integer>();
//
//			for(int i = 0; i<result.length(); ++i) {
//				switch(result.charAt(i)) {
//				case '+':
//				case '*':
//					int num2 = is.pop();
//					int num1 = is.pop();
//					
//					is.push(calc(num1,num2,result.charAt(i)));	
//					break;
//				default :
//					is.push(result.charAt(i)-'0');
//				}
//			}
//			System.out.print("#" + test_case + " ");
//			System.out.println(is.pop());
		}
	}
}
