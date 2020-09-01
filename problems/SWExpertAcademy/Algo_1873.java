package problems.SWExpertAcademy;

import java.util.Scanner;

public class Algo_1873 {
	public static void main(String[] args) {
		String data = "1\r\n" + 
				"3 7\r\n" + 
				"***....\r\n" + 
				"*-..#**\r\n" + 
				"#<.****\r\n" + 
				"23\r\n" + 
				"SURSSSSUSLSRSSSURRDSRDS";
		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(data);

		int T = Integer.parseInt(sc.nextLine());

		for (int test_case = 1; test_case <= T; ++test_case) {
			String[] tmp = sc.nextLine().split(" ");
			int H = Integer.parseInt(tmp[0]);
			int W = Integer.parseInt(tmp[1]);
			int x = 0;
			int y = 0;

			char[][] map = new char[H][W];

			for (int i = 0; i < H; ++i) {
				String line = sc.nextLine();
				for (int j = 0; j < W; ++j) {
					map[i][j] = line.charAt(j);

					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						x = i;
						y = j;
					}
				}
			}
			sc.nextLine();
			String command = sc.nextLine();

			for (int i = 0; i < command.length(); ++i) {
				switch (command.charAt(i)) {
				case 'U':
					map[x][y] = '.';
					if (x - 1 >= 0 && map[x - 1][y] == '.')
						--x;

					map[x][y] = '^';
					break;
				case 'D':
					map[x][y] = '.';
					if (x + 1 < H && map[x + 1][y] == '.')
						++x;

					map[x][y] = 'v';
					break;
				case 'L':
					map[x][y] = '.';
					if (y - 1 >= 0 && map[x][y - 1] == '.')
						--y;

					map[x][y] = '<';
					break;
				case 'R':
					map[x][y] = '.';
					if (y + 1 < W && map[x][y + 1] == '.')
						++y;

					map[x][y] = '>';
					break;
				case 'S':
					switch (map[x][y]) {
					case '^':
						for (int a = x; a >= 0; --a) {
							if (map[a][y] == '*') {
								map[a][y] = '.';
								break;
							}

							if (map[a][y] == '#') {
								break;
							}
						}
						break;
					case 'v':
						for (int a = x; a < H; ++a) {
							if (map[a][y] == '*') {
								map[a][y] = '.';
								break;
							}

							if (map[a][y] == '#') {
								break;
							}
						}
						break;
					case '<':
						for (int a = y; a >= 0; --a) {
							if (map[x][a] == '*') {
								map[x][a] = '.';
								break;
							}

							if (map[x][a] == '#') {
								break;
							}
						}
						break;

					case '>':
						for (int a = y; a < W; ++a) {
							if (map[x][a] == '*') {
								map[x][a] = '.';
								break;
							}

							if (map[x][a] == '#') {
								break;
							}
						}
						break;
					}
				}
			}
			System.out.print("#" + test_case);
			for (int i = 0; i < H; ++i) {
				for (int j = 0; j < W; ++j) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			
			
		}

	}
}
