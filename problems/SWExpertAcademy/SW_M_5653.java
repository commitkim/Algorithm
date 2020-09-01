package problems.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Cell{
	int x,y;
	int X;
	boolean state = false;
	boolean alive = true;
	int activeCnt;
	
	Cell(int x, int y, int X){
		this.x = x;
		this.y = y;
		this.X = X;
		this.activeCnt = X;
	}
}

public class SW_M_5653 {
	private static int[] moveX = {-1,1,0,0};
	private static int[] moveY = {0,0,-1,1};
	
	private static Cell[][] copy;
	private static Cell[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case<=T; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			copy = new Cell[701][701];
			map = new Cell[701][701];
			
			int NLimit = (N%2 == 0)? 351 + N/2 : 352 + N/2;
			int MLimit = (M%2 == 0)? 351 + M/2 : 352 + M/2;
			
			List<Cell> q = new ArrayList<Cell>();
			List<Cell> qCopy = new ArrayList<Cell>();
			
			for(int i = 351-N/2; i<NLimit; ++i) {
				st = new StringTokenizer(br.readLine());
				
				for(int j = 351-M/2; j<MLimit; ++j) {
					int X = Integer.parseInt(st.nextToken());
					if(X == 0) continue;
					
					map[i][j] = new Cell(i,j,X);
					copy[i][j] = map[i][j];
					q.add(new Cell(i,j,X));
				}
			}
			
			
			for(int time = 0; time<K; ++time) {
				int size = q.size();
				for(int idx = 0; idx <size; ++idx) {
					Cell c = q.get(idx);
					int i = c.x;
					int j = c.y;
					int X = c.X;
					
					if(map[i][j].state) {
						for(int k = 0; k<4; ++k) {
							int a = i + moveX[k];
							int b = j + moveY[k];
							
							if(a<0 || b<0 || a>=700 || b>=700) continue;
							
							if(map[a][b] == null) {
								map[a][b] = new Cell(a,b,X);
								qCopy.add(map[a][b]);
							}
						}
					}
					
					--map[i][j].activeCnt;
					if(map[i][j].activeCnt == 0) {
						if(!map[i][j].state) {
							map[i][j].state = true;
							map[i][j].activeCnt = map[i][j].X;
						}
						else {
							map[i][j].alive = false;
							continue;
						}
					}
					
					qCopy.add(map[i][j]);
				}
				
				q = new ArrayList<>(qCopy);
				q.sort((o1,o2) -> (o1.X - o2.X) * -1);
				qCopy.clear();
			}
			
			
			System.out.println("#" + test_case + " " + q.size());
		}
	}
}
