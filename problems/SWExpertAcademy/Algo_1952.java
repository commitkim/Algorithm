package problems.SWExpertAcademy;

import java.util.Scanner;

public class Algo_1952 {
	private static int[] plan;
	private static int dayPrice;
	private static int monthPrice;
	private static int threeMonthPrice;
	private static int yearPrice;
	
	private static int solve(int month , int price) {
		if(month > 12) {
			return price;
		}
		if(plan[month] == 0)
			solve(month+1,price);
		
		int dayStart = solve(month+1,price + plan[month]*dayPrice);
		int monthStart = solve(month+1,price + monthPrice);
		int threeMonthStart = solve(month+3, price + threeMonthPrice);
		int yearStart = solve(month+12, price + yearPrice);
		
		return Math.min(Math.min(dayStart, monthStart), Math.min(threeMonthStart, yearStart));
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		plan = new int[13];
		
		for(int test_case = 1; test_case<=T; ++test_case) {
			dayPrice = sc.nextInt();
			monthPrice = sc.nextInt();
			threeMonthPrice = sc.nextInt();
			yearPrice = sc.nextInt();
			
			for(int i = 1; i<=12; ++i) {
				plan[i] = sc.nextInt();
			}
			
			int answer = solve(1,0);
		
			System.out.println("#" + test_case + " " + answer);
		}
		
	}
}
