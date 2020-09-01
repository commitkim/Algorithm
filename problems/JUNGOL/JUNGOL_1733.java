package problems.JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL_1733 {
	private static int answer, answerX, answerY;
	private static int[][] omok;
	private static int[] moveX = { -1, -1, 0, 1, 1, 1, 0, -1 };
	private static int[] moveY = { 0, 1, 1, 1, 0, -1, -1, -1 };

	private static void check(int x, int y, int color) {
		for (int i = 0; i < 8; ++i) {
			int count = 1;
			int a = x;
			int b = y;
			int tmpX = a - moveX[i];
			int tmpY = b - moveY[i];
			
			if (tmpX >= 0 && tmpY >= 0 && tmpX < 19 && tmpY < 19) {
				if(omok[tmpX][tmpY] == color)
					continue;
			}
				
			while (true) {
				
				a += moveX[i];
				b += moveY[i];

				if (a < 0 || b < 0 || a >= 19 || b >= 19 )
					break;
				if (omok[a][b] != color)
					break;

				++count;
				if (b < y) {
					x = a;
					y = b;
				}
			}

			if (count == 5) {
				answer = color;
				answerX = x;
				answerY = y;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		answer = 0;
		answerX = -1;
		answerY = -1;

		omok = new int[19][19];
		for (int i = 0; i < 19; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; ++j) {
				omok[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		OUTER: for (int i = 0; i < 19; ++i) {
			for (int j = 0; j < 19; ++j) {
				check(i, j, omok[i][j]);
				if (answer != 0)
					break OUTER;
			}
		}

		System.out.println(answer);
		if (answer != 0)
			System.out.println((answerX + 1) + " " + (answerY + 1));
	}
}
