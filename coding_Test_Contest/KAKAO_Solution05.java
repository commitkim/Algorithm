package coding_Test_Contest;

import java.util.Arrays;

public class KAKAO_Solution05 {
	
	public int makeSec(String str) {
		int time = 0;
		String[] strs = str.split(":");
		time += Integer.parseInt(strs[0])*3600;
		time += Integer.parseInt(strs[1])*60;
		time += Integer.parseInt(strs[2]);
		
		return time;
	}
	public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int playTime = makeSec(play_time);
        int advTime = makeSec(adv_time);
        
        
        Arrays.sort(logs);
//        System.out.println(Arrays.toString(logs));
        
        int idx = 0;
        int max = 0;
        
        {
        	int advStart = 0;
        	int advEnd = advStart + advTime;
        	int length = 0;
        	for(int j = 0; j<logs.length; ++j) {
        		String[] div = logs[j].split("-");
                int logStart = makeSec(div[0]);
                int logEnd = makeSec(div[1]);
                
        		if(advStart + advTime >= logStart) {
        			if(logEnd > advEnd) {
        				length += advEnd - logStart;
        			}
        			else {
        				length += logEnd - logStart;
        			}
        		}
        		else
        			break;
        	}
        	if(max < length) {
        		idx = -1;
        		max = length;
        	}
        }
        for(int i = 0; i<logs.length; ++i) {
        	int advStart = makeSec(logs[i].split("-")[0]);
            int advEnd = (advStart + advTime > playTime)? playTime : advStart + advTime;
        	int length = 0;
        	for(int j = 0; j<logs.length; ++j) {
        		String[] div = logs[j].split("-");
        		int logStart = makeSec(div[0]);
        		int logEnd = makeSec(div[1]);
        		if(i > j) {
        			if(advEnd > logEnd && logEnd > advStart) {
        				length += advStart + logEnd;
        			}
        		}
        		else {
        			if(advEnd >= logStart) {
        				if(logEnd > advEnd) {
        					length += advEnd - logStart;
        				}
        				else {
        					length += logEnd - logStart;
        				}
        			}
        			else
        				break;
        		}
                
        	}
        	if(max < length) {
        		idx = i;
        		max = length;
        	}
//        	System.out.println("[" + logs[i] + "]");
//        	System.out.println(length);
//        	System.out.println("[" + idx + "]");
//        	System.out.println(max);
//        	System.out.println("-------------------");
        }
        
        
        answer = idx != -1 ? logs[idx].split("-")[0] : "00:00:00";
        
        return answer;
    }
	public static void main(String[] args) {
		String str = new KAKAO_Solution05().solution("99:59:59", "25:00:00", new String[] {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"});
		System.out.println(str);
	}
}
