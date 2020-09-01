package problems.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_M_4013 {
	private static int K,answer;
	private static int[][] magnet;
	
	private static void rotate(int num, int dir) {
		int idx = 8;
		
		int temp = magnet[num][idx%8];
		for(int i = idx; i<idx+8 && i>idx-8; i+=dir) {
			int tmp = magnet[num][(i + dir)%8];
			magnet[num][(i + dir)%8] = temp;
			temp = tmp;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case<=T; ++test_case) {
			K = Integer.parseInt(br.readLine());
			answer = 0;
			magnet = new int[5][8];
			for(int i = 1; i<=4; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<8; ++j) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i<K; ++i) {
				List<int[]> list = new ArrayList<>();
				StringTokenizer st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				int cnt = 1;
				
				list.add(new int[] {num,dir});
				for(int j = num+1; j<=4; ++j) {
					if(magnet[j-1][2] != magnet[j][6]) {
						list.add(new int[] {j,dir*(int)Math.pow(-1, cnt++)});
						
					}
					else break;
				}
				cnt = 1;
				for(int j = num-1; j>=1; --j) {
					if(magnet[j+1][6] != magnet[j][2]){
						list.add(new int[] {j,dir*(int)Math.pow(-1, cnt++)});
						
					}
					else break;
				}
				for(int[] arr : list) {
					rotate(arr[0],arr[1]);
				}
			}
			
			
			for(int i = 1; i<=4; ++i) {
				if(magnet[i][0] == 1) answer += (int)Math.pow(2, i-1);
			}
		
			System.out.println("#" + test_case + " " + answer);
		}
	}
}
