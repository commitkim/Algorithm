package problems.SWExpertAcademy;

import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SW_M_2112 {
	private static int D,W,K;
	private static boolean result;
	private static int[][] protectedFilm,copy;
	private static int[] selected;
	private static int[] Aselected;
	private static int[] Bselected;
	
	public static void C(int start, int cnt, int max) {
		if(cnt == max) {
			for(int i = 0; i<=max; ++i) {
				Aselected = new int[i];
				Bselected = new int[max-i];
				
				select(0,0,i);
			}
			return;
		}
		
		for(int i = start; i<D; ++i) {
			selected[cnt] = i;
			C(i+1,cnt+1,max);
		}
	}
	
	public static void select(int start, int cnt, int max) {
		if(cnt == max) {
			int Bidx = 0;
			
			for(int i = 0; i<Aselected.length + Bselected.length; ++i) {
				boolean flag = true;
				for(int j = 0; j<Aselected.length; ++j)
					if(Aselected[j] == selected[i]) flag = false; 
					
				if(flag)
					Bselected[Bidx++] = selected[i];
			}
			
			insert(1,Aselected);
			insert(0,Bselected);
			
			result = check()||result;
			init();
			return;
		}
		
		for(int i = start; i<Aselected.length + Bselected.length; ++i) {
			Aselected[cnt] = selected[i];
			select(i+1,cnt+1,max);
		}
	}
	
	public static void insert(int type, int[] selected) {
		for(int i = 0; i<selected.length; ++i) {
			for(int j = 0; j<W; ++j) {
				protectedFilm[selected[i]][j] = type;
			}
		}
	}
	
	public static boolean check() {
		for(int i = 0; i<W; ++i) {
			int type = protectedFilm[0][i];
			int count = 1;
			for(int j = 1; j<D; ++j) {
				if(count >= K) break;
				if(protectedFilm[j][i] == type)
					++count;
				else {
					type = protectedFilm[j][i];
					count = 1;
				}
			}
			if(count < K) return false;
		}
		return true;
	}
	
	public static void init() {
		for(int i = 0; i<D; ++i) {
			for(int j = 0; j<W; ++j) {
				protectedFilm[i][j] = copy[i][j];
			}
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <=T; ++test_case) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			result = false;
			
			protectedFilm = new int[D][W];
			copy = new int[D][W];
			selected = new int[D];
			
			for(int i = 0; i<D; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<W; ++j) {
					protectedFilm[i][j] = Integer.parseInt(st.nextToken());
					copy[i][j] = protectedFilm[i][j];
				}
			}

			result = check();
			int answer;
			for(answer = 0; answer<D; ++answer) {
				C(0,0,answer);
				if(result) break;
			}
			
			System.out.println("#" + test_case + " " + answer);
			
		}
	}
}
