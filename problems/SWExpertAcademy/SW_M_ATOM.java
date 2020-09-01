package problems.SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
import java.io.FileInputStream;

public class SW_M_ATOM 
{
    private static double[] moveX = { 0, 0, -1, 1 };  
    private static double[] moveY = { 1, -1, 0, 0 };
    private static int N;
 
    static class Atom {
    	int x, y, dir, k;

        Atom(int x, int y, int dir, int k) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.k = k;
        }
    }
 
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[][] map = new int[4001][4001];
        
 
        for (int test_case = 1; test_case <= T; ++test_case) {
            N = Integer.parseInt(br.readLine());
            Atom[] arr = new Atom[N+1];
            int idx = 1;
            
            for (int i = 0; i < N; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine());
 
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                
                map[x*2+2000][y*2+2000] = idx;
                arr[idx++] = new Atom(x*2+2000, y*2+2000, dir, k);
                
                
            }
 
            int answer = 0;
            Set<Integer> set = new HashSet<Integer>();
            
           	 for(int turn = 0; turn<=4000; ++turn) {
            	for(int i = 1; i<arr.length; ++i) {
            		if(arr[i].dir == -1)
            			continue;
            		
            		map[arr[i].x][arr[i].y] = (map[arr[i].x][arr[i].y] == i)? 0 : map[arr[i].x][arr[i].y] ;
            		
            		arr[i].x += moveX[arr[i].dir];
            		arr[i].y += moveY[arr[i].dir];
            		
            		if(arr[i].x < 0 || arr[i].x >= 4001 || arr[i].y<0 || arr[i].y>= 4001) {
            			arr[i].dir = -1;
            			continue;
            		}
            		///////////
            		
            		if(map[arr[i].x][arr[i].y] > 0 && map[arr[i].x][arr[i].y] < i) {
            			set.add(map[arr[i].x][arr[i].y]);
            			answer += arr[i].k;
            			arr[i].dir = -1;
            			//System.out.println(i + " ");
            		}
            		
            		else if (map[arr[i].x][arr[i].y] == 0){
            			map[arr[i].x][arr[i].y] = i;
            		}
            	}
            	
            	for(Integer i : set) {
            		answer += arr[i].k;
            		arr[i].dir = -1;
            		map[arr[i].x][arr[i].y] = 0;
            	}
            	
            	set.clear();
            }
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}