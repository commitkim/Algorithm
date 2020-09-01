package problems.BAEKJOON;

import java.util.Scanner;

public class Algo_5585 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = 1000 - sc.nextInt();
		
		int answer = 0;
		
		answer += M/500;
		answer += (M%500)/100;
		answer += ((M%500)%100)/50;
		answer += (((M%500)%100)%50)/10;
		answer += ((((M%500)%100)%50)%10)/5;
		answer += (((((M%500)%100)%50)%10)%5);
		
		System.out.println(answer);
	}
}
