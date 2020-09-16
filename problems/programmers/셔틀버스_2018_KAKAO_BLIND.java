package problems.programmers;

import java.util.Arrays;

public class 셔틀버스_2018_KAKAO_BLIND {
	
	public String calcTime(int HH, int MM, int interval) {
		return (MM+interval >= 60)? (HH+1)+":"+(MM+interval%60) : (HH)+":"+(MM+interval); 
	}
	public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        Arrays.sort(timetable);
        
        int idx = 0;
        int busHH = 9;
        int busMM = 0;
        for(int i = 0; i<=n; ++i) {
        	int in = 0;
        	
        	while(in != m && idx<timetable.length) {
        		String[] time = timetable[idx].split(":");
        		int crewHH = Integer.parseInt(time[0]);
        		int crewMM = Integer.parseInt(time[1]);
        		
        		if(crewHH < busHH || (crewHH == busHH && crewMM <= busMM)) {
        			answer = timetable[idx];
        			++idx;
        			++in;
        		}
        		else break;
        	}
        	
        	if(in < m)
        		answer = String.format("%02d", busHH) + ":" + String.format("%02d", busMM);
        	else if(in == m) {
        		String[] time = answer.split(":");
        		int ansHH = Integer.parseInt(time[0]);
        		int ansMM = Integer.parseInt(time[1]);
        		
        		if(ansMM<1)
        			answer = String.format("%02d", ansHH-1) + ":" + String.format("%02d", 59);
        		else
        			answer = String.format("%02d", ansHH) + ":" + String.format("%02d", ansMM-1);
        	}

        	String[] time = calcTime(busHH,busMM,t).split(":");
        	busHH = Integer.parseInt(time[0]);
        	busMM = Integer.parseInt(time[1]);
        }
        
        return answer;
    }
	public static void main(String[] args) {
		String a = new 셔틀버스_2018_KAKAO_BLIND().solution(2, 10, 2, new String[] {"09:10", "09:09", "08:00"});
		System.out.println(a);
	}
}
