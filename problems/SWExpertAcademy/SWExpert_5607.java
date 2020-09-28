package problems.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWExpert_5607 {
	
	/*
	 *  a^p %p = a%p
	 *  a^(p-1) %p = 1
	 * 
	 *  nCr = n! / r!(n-r)! -> n! * {r!(n-r)!}^-1
	 *  nCr % p = [n! * {r!(n-r)!}^-1] % p * 1
	 *  		= [n! * {r!(n-r)!}^-1] % p * [{r!(n-r)!}^(p-1)] %p
	 *  		= [n! * {r!(n-r)!}^-1 * {r!(n-r)!}^(p-1) ] %p
	 *  		= [n! * {r!(n-r)!}^(p-2)] % p
	 *  		  -----------------------
	 *  			ㄴ얘만 구하면 풀 수 있다.
	 *  
	 *  a^n = {a^(n/2)}^2
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case<=T; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int MOD = 1234567891;
			
			long n = 1;
			for(int i = 1; i<=N; ++i) {
				n *= i;
				n %= MOD;
			}
			
			long r = 1;
			for(int i = 1; i<=R; ++i) {
				r *= i;
				r %= MOD;
			}
			
			long k = r;
			for(int i = 1; i<=N-R; ++i) {
				k *= i;
				k %= MOD;
			}
			
			
			
			int POW = MOD-2;
			while(POW>=1) {
				if(POW%2 == 1)
					n = (n*k)%MOD;
				k = (k*k)%MOD;
				POW/=2;
				
			}
			System.out.println("#" + test_case + " " + n);
			
		}
	}
}
