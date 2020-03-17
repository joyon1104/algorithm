package programmers;
import java.util.*;

/*
 * [더 맵게]
 */

class p200307_2 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x : scoville)
            pq.offer(x);
        
        while(pq.peek()<K){
            if(pq.size() == 1){
                answer = -1;
                break;
            }
            int first = pq.poll();
            int second = pq.poll();
            
            int result = first + (second*2);
            pq.offer(result);
            answer++;
        }
        
        return answer;
    }
}