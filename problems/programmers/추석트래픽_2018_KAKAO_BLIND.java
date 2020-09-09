package kgw.ssafy.study;

import java.util.ArrayList;
import java.util.List;

class Request{
	int startTime;
	int endTime;
	
	Request(int startTime, int endTime){
		this.startTime = startTime;
		this.endTime = endTime;
	}
}

public class PROGRAMMERS_추석트래픽 {
	public int solution(String[] lines) {
        int answer = 0;
        
        List<Request> list = new ArrayList<>();
        for(int i = 0 ; i<lines.length; ++i) {
        	String[] str = lines[i].split(" ");
        	String[] arriveTime = str[1].split(":");
        	int hh = Integer.parseInt(arriveTime[0])*3600*1000;
        	int mm = Integer.parseInt(arriveTime[1])*60*1000;
        	int ss = (int)(Double.parseDouble(arriveTime[2])*1000);
        	
        	int processingTime = (int)(Double.parseDouble(str[2].replace("s", "")) * 1000);
        	int endTime = hh+mm+ss;
        	int startTime = endTime - processingTime + 1;
        	list.add(new Request(startTime,endTime));
        }
        
        for(int i = 0; i<list.size(); ++i) {
        	double start = list.get(i).endTime;
        	int count = 1;
        	
        	for(int j = i+1; j<list.size(); ++j) {
                if(list.get(j).startTime  - start < 1000)
                    ++count;
        	}
        	answer  = Math.max(count, answer);
        }
        		
        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(new PROGRAMMERS_추석트래픽().solution(new String[] {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"}));
	}
}
