package coding_Test_Contest;
public class LINE_Solution05 {
	public int solution(int[] cards) {
        int answer = 0;
        int idx = 0;
        
        while(idx<cards.length) {
        	try {
        		int open = 0;
        		int dealerSum = 0;
        		int playerSum = 0;
        		
        		int dealerOne = 0;
        		int playerOne = 0;
        		
        		if(cards[idx] == 1)
        			++playerOne;
        		playerSum += (cards[idx] > 10)? 10 : cards[idx];
        		++idx;
        		
        		if(cards[idx] == 1)
        			++dealerOne;
        		dealerSum += (cards[idx] > 10)? 10 : cards[idx];
        		++idx;
        		
        		if(cards[idx] == 1)
        			++playerOne;
        		playerSum += (cards[idx] > 10)? 10 : cards[idx];
        		++idx;
        		
        		open = cards[idx];
        		if(cards[idx] == 1)
        			++dealerOne;
        		dealerSum += (cards[idx] > 10)? 10 : cards[idx];
        		++idx;
        		
        		if(playerOne > 0) {
        			if(playerSum + 10 == 21) {
        				playerSum += 10;
        				--playerOne;
        			}
        		}
        		
        		if(open == 1 || open >= 7) {
        			while(playerSum<17) {
        				if(playerOne > 0) {
        					if(playerSum + 10 >= 17 || playerSum + 10 == 21) {
        						playerSum += 10;
        						--playerOne;
        						break;
        					}
        				}
        				if(cards[idx] == 1)
        					++playerOne;
        				playerSum += (cards[idx] > 10)? 10 : cards[idx];
        				++idx;
        			}
        			//17
        		}
        		else if(open == 2 || open == 3) {
        			//12
        			while(playerSum<12) {
        				if(playerOne > 0) {
        					if(playerSum + 10 >= 12 || playerSum + 10 == 21) {
        						playerSum += 10;
        						--playerOne;
        						break;
        					}
        				}
        				if(cards[idx] == 1)
        					++playerOne;
        				playerSum += (cards[idx] > 10)? 10 : cards[idx];
        				++idx;
        			}
        		}
        		
        		if(playerSum == 21) {
    				answer += 3;
    				continue;
    			}
        		else if(playerSum > 21) {
        			answer -= 2;
        			continue;
        		}
        		
        		while(dealerSum<17) {
        			if(dealerOne > 0) {
        				if(dealerSum + 10 >= 17 || dealerSum + 10 == 21) {
        					dealerSum += 10;
        					--dealerOne;
        					break;
        				}
        			}
        			if(cards[idx] == 1)
        				++dealerOne;
        			dealerSum += (cards[idx] > 10)? 10 : cards[idx];
        			++idx;
        		}
        		
        		if(dealerSum > 21) {
        			answer += 2;
        			continue;
        		}
        		else {
        			int dealer = Math.abs(21-dealerSum);
        			int player = Math.abs(21-playerSum);
        			if(dealer < player) {
        				answer -= 2;
        			}
        			else if(dealer > player) {
        				answer += 2;
        			}
        		}
        		
        	}catch(Exception e) {
        		return answer;
        	}
        }
        
        return answer;
    }
	public static void main(String[] args) {
		System.out.println(new LINE_Solution05().solution(new int[] {1, 4, 10, 6, 9, 1, 8, 13}));
	}
}
