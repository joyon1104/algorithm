package programmers;
import java.util.*;
/*
 * [야근지수]
 * - 우선순위 큐를 이용한다.(내림차순)
 * - 가장 작업량이 많은 일부터 우선순위 큐에서 꺼낸다.
 * - 퇴근까지 남은 시간 n을 1감소시키고, 꺼낸 일도 1감소시킨 후 다시 우선순위 큐에 넣는다.
 * - n이 0이 될 때까지 반복 -> 만일 가장 작업량이 많은 일이 0이면 퇴근 전에 모든 일을 끝냈다는 뜻이므로 바로 0을 리턴한다.
 * - 우선순위큐에 남은 일들로 야근지수를 계산해서 리턴한다.
 */
class p200330_2 {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int x : works)
            pq.offer(x);
        
        while(n>0){
            int tmp = pq.poll();
            if(tmp == 0)
                return answer;
            pq.offer(tmp-1);
            n--;
        }
        
        while(!pq.isEmpty()){
            int tmp = pq.poll();
            answer += tmp * tmp;
        }
        return answer;
    }
}