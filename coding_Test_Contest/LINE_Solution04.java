package coding_Test_Contest;
public class LINE_Solution04 {
	private int[] moveX = {-1,0,1,0};
	private int[] moveY = {0,1,0,-1};
	
	public boolean leftCheck(int[][] maze, int x, int y, int position) {
		int a = x + moveX[position];
		int b = y + moveY[position];
		
		if(a<0 || b<0 || a>=maze.length || b>=maze.length)
			return true;
		
		return maze[a][b] == 1;
	}
	
	public int solution(int[][] maze) {
        int answer = 0;
        int n = maze.length;
        int x = 0,y = 0;
        int position = 0;
        while(x!=n-1 || y!=n-1) {
        	if(leftCheck(maze,x,y,position)) {
        		int a = x + moveX[(position+1)%4];
        		int b = y + moveY[(position+1)%4];
        		
        		if(a<0 || b<0 || a>=n || b>=n || maze[a][b] == 1) {
        			position = (position+1)%4;
        			continue;
        		}
        		x = a;
        		y = b;
        		System.out.println(x + " " + y);
        		++answer;
        	}
        	else {
        		position = (position == 0)? 3 : position-1;
        		x += moveX[(position+1)%4];
        		y += moveY[(position+1)%4];
        		System.out.println(x + " " + y);
        		++answer;
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		int a = new LINE_Solution04().solution(new int[][] {{0, 1, 0, 1}, {0, 1, 0, 0}, {0, 0, 0, 0}, {1, 0, 1, 0}});
		System.out.println(a);
	}
}
