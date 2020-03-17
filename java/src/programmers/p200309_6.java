package programmers;
import java.util.*;

/*
 * [라면공장]
 * 1. 0일부터 k-1일 까지 밀가루 재고량을 확인해야 한다. (k일에는 기존 공장에서 공급받을 수 있기 때문)
 * 2. i일째 날일 때 받을 수 있는 밀가루는 우선순위 큐에 미리 저장한다.(우선순위큐 - 내림차순)
 * 3. 재고량이 0일 때, 우선순위큐의 가장 앞에 있는 밀가루(공급받을 수 있는 밀가루의 가장 많은 양의 밀가루)를 공급받는다. -> answer++
 *    =>우선순위큐에 있는 밀가루들은 처음에 기본으로 다 넣는 것이 아닌,밀가루 공급 시점에 추가하는 것
 */

class p200309_6 {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int idx = 0;
        for(int i=0; i<k; i++){ //k일에는 기존 밀가루 공장에서 공급 받으므로 k-1일까지만 확인하면 됨.
            if(idx<dates.length && i==dates[idx])
                pq.offer(supplies[idx++]);
            if(stock==0){
                stock+= pq.poll();
                answer++;
            }
            stock--;
        }
        
        return answer;
    }
}