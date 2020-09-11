package problems.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_2382 {
	private static int[] moveX = {-1,1,0,0};
	private static int[] moveY = {0,0,-1,1};
	private static int[][] map;
	
	static class Microbe {
		int x, y, num, dir, pre;

		public Microbe(int x, int y, int num, int dir,int pre) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
			this.dir = dir;
			this.pre = pre;
		}

	}

	private static List<Microbe> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; ++test_case) {
			int answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			list = new ArrayList<>();
			
			for(int i = 0; i<N; ++i) {
				for(int j = 0; j<N; ++j) {
					map[i][j] = -1;
				}
			}
			
			for (int i = 0; i < K; ++i) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;
				
				list.add(new Microbe(x,y,num,dir,num));
				map[list.get(i).x][list.get(i).y] = i;
			}
			
			
			for(int i = 0; i<M; ++i) {
				for(int j = 0; j<K; ++j) {
					Microbe m = list.get(j);
					if(m.dir == -1) continue;
					map[m.x][m.y] = (map[m.x][m.y] != j)? map[m.x][m.y] : -1 ;
					
					int a = m.x + moveX[m.dir];
					int b = m.y + moveY[m.dir];
					
					list.get(j).x = a;
					list.get(j).y = b;
					
					if(a<=0 || b<=0 || a>=N-1 || b>=N-1) {
						switch(m.dir) {
						case 0: list.get(j).dir = 1; break; 
						case 1: list.get(j).dir = 0; break;
						case 2: list.get(j).dir = 3; break;
						case 3: list.get(j).dir = 2; break;
						}

						list.get(j).num /= 2;
						continue;
					}
					
					if(map[a][b] != -1) {  //가려는 곳에 누군가가 있으면
						if(map[a][b] < j) {   //이동을 끝마친 애였으면
							if(list.get(map[a][b]).pre < m.num) {  //부딪혀서 합쳐진 애의 이전에 컷던애보다 내가 크면
								m.num += list.get(map[a][b]).num;
								list.get(map[a][b]).dir = -1;
								map[a][b] = j;
							}
							else {
								list.get(map[a][b]).num += m.num;
								m.dir = -1;
							}
						}
						else {
							map[a][b] = j;
							
						}
					}
					else {
						map[a][b] = j;
						
					}
					
				}
				
				for(Microbe b :list) {
					if(b.dir == -1) continue;
					b.pre = b.num;
				}
			}
			answer = 0;
			
			for(Microbe b :list) {
				if(b.dir == -1) continue;
				answer += b.num;
			}
			System.out.println("#" + test_case + " " + answer);
			
			
		}
	}
}
