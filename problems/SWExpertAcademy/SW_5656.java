package problems.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_5656 {
	private static int[] moveX = {-1,1,0,0};
	private static int[] moveY = {-0,0,-1,1};
	
	private static int[] selected,top,topCopy;
	private static int[][] map,copy;
	private static int N,W,H,minimum;
	
	private static void P(int cnt) {
		if(cnt == N) {
//			System.out.println(Arrays.toString(selected));
			minimum = Math.min(minimum, run());
//			System.out.println("answer = " + run());
			return;
		}
		
		for(int i = 0; i<W; ++i) {
			selected[cnt] = i;
			P(cnt+1);
		}
	}
	
	private static int run() {
		int result = 0;
		for(int i = 0; i<N; ++i) {
			if(top[selected[i]] < 0 || top[selected[i]] >= H) continue;
			breakBlocks(top[selected[i]],selected[i]);
//				for(int k = 0; k<H; ++k) {
//					for(int l = 0; l<W; ++l) {
//						System.out.print(map[k][l] + " ");
//					}
//					System.out.println();
//				}
//				System.out.println("----------------------------");
//				
//			System.out.println(Arrays.toString(top));
			downBlocks();
			
//			for(int k = 0; k<H; ++k) {
//				for(int l = 0; l<W; ++l) {
//					System.out.print(map[k][l] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("----------------------------");
		}
		
		
		result = countBlocks(); 
		
		return result;
	}
	
	private static void breakBlocks(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int[] target = q.poll();
			
			for(int i= 0; i<4; ++i) {
				int a = target[0];
				int b = target[1];
				
				for(int j = 0; j<map[target[0]][target[1]] - 1; ++j) {
					a += moveX[i];
					b += moveY[i];
					
					if(a<0 || b<0 || a>=H || b>=W) break;
					
					q.offer(new int[] {a,b});
				}
			}
			map[target[0]][target[1]] = 0;
		}
	}
	
	private static void downBlocks() {
		int[] info;
		for(int i = 0; i<W; ++i) {
			int idx = 0;
			info = new int[H];
			for(int j = H-1; j>=0; --j) 
				if(map[j][i] != 0) info[idx++] = map[j][i];
			
			top[i] = H - idx;
			
			for(int j = H-1,k = 0; j>=0; --j, ++k) 
				map[j][i] = info[k];
		}
	}
	
	private static int countBlocks() {
		int cnt = 0;
		
		for(int i = 0; i<H; ++i) {
			for(int j =0; j<W; ++j) {
				cnt = (map[i][j] != 0)? cnt+1 : cnt;
				map[i][j] = copy[i][j];
			}
		}
		
		for(int i = 0; i<W; ++i)
			top[i] = topCopy[i];
		
		return cnt;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T =  Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case<=T; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			map = new int[H][W];
			copy = new int[H][W];
			selected = new int[N];
			top = new int[W];
			topCopy = new int[W];
			minimum = Integer.MAX_VALUE;
			
			for(int i = 0; i<W; ++i) {
				top[i] = Integer.MAX_VALUE;
				topCopy[i] = top[i];
			}
			
			for(int i =0; i<H; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					copy[i][j] = map[i][j];
					top[j] = (map[i][j] != 0)? Math.min(i, top[j]) : top[j];
					topCopy[j] = top[j];
				}
			}
			
			P(0);
			
//			selected = new int[] {2,2,6};
//			System.out.println("answer = " + run());
			
			System.out.println("#" + test_case + " " + minimum);
			
		}
	}
}
