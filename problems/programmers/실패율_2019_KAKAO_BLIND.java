package problems.programmers;

import java.util.Arrays;

class Stage implements Comparable<Stage>{
    int num;
    double failRate;
    Stage(int num, double failRate){
        this.num = num;
        this.failRate = failRate;
    }

	@Override
	public int compareTo(Stage o) {
		if(this.failRate - o.failRate == 0) {
			return (this.num - o.num > 0)? 1 : -1;
		}
		return (this.failRate - o.failRate < 0)? 1 : -1;
	}
}

class Solution1 {
    public int[] solution(int N, int[] stages) {
    	int[] answer = new int[N];
        Stage[] stageInfo = new Stage[N];
        int[] stopped = new int[N+2];
        
        for(int stage : stages){
            ++stopped[stage];
        }
        
        double challenge = stopped[N+1];
        for(int i = N; i>0; --i){
            challenge += stopped[i];
            stageInfo[i-1] = new Stage(i,(challenge == 0)? 0 : stopped[i]/challenge);
        }
        
        Arrays.sort(stageInfo);
        
        for(int i = 0; i<N; ++i) {
        	answer[i] = stageInfo[i].num;
        }
        System.out.println(Arrays.toString(answer));
        
        return answer;
    }
}

public class 실패율_2019_KAKAO_BLIND {
	public static void main(String[] args) {
		new Solution1().solution(5, new int[] {2,1,2,6,2,4,3,3});
	}
}
