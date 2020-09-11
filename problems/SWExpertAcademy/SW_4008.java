package problems.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_4008 {
	private static int[] nums;
	private static char[] opers, selected;
	private static int[] opersNum;
	private static int plus, minus, mul, div, N, maximum, minimum;

	private static void P(int start, int cnt) {
		if (cnt == 4) {
			int result = calc();
			maximum = Math.max(result, maximum);
			minimum = Math.min(result, minimum);
			return;
		}
		if(opersNum[cnt] == 0) P(0,cnt+1);
		else {
			opersNum[cnt] -= 1;
			for (int i = start; i < selected.length; ++i) {
				if (selected[i] != 0)
					continue;
				
				selected[i] = opers[cnt];
				P(i+1, cnt);
				selected[i] = 0;
			}
			opersNum[cnt] += 1;
		}
	}

	private static int calc() {
		int idx = 0;
		int storedNum = nums[idx++];
		for (int i = 0; i < selected.length; ++i) {
			switch (selected[i]) {
			case '+': storedNum += nums[idx++]; break;
			case '-': storedNum -= nums[idx++]; break;
			case '*': storedNum *= nums[idx++]; break;
			case '/': storedNum /= nums[idx++]; break; 
			}
		}
		return storedNum;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; ++test_case) {
			N = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());
			plus = Integer.parseInt(st.nextToken());
			minus = Integer.parseInt(st.nextToken());
			mul = Integer.parseInt(st.nextToken());
			div = Integer.parseInt(st.nextToken());
			
			opers = new char[] {'+','-','*','/'};
			selected = new char[plus + minus + mul + div];
			opersNum = new int[] {plus,minus,mul,div};

			maximum = Integer.MIN_VALUE;
			minimum = Integer.MAX_VALUE;

			nums = new int[N];
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; ++i) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			P(0, 0);
			System.out.println("#" + test_case + " " + (maximum - minimum));
		}
	}
}
