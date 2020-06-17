package programmers;

/*
 * [이중우선순위큐]
 */
import java.util.*;
class p200319_2 {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        int cnt = 0;
        for(String x : operations){
            String[] word = x.split(" ");
            if(word[0].equals("I")){
                pq1.offer(Integer.parseInt(word[1]));
                pq2.offer(Integer.parseInt(word[1]));
                cnt++;
            }
            else if(cnt>0){
                if(word[1].equals("-1"))
                    pq1.poll();
                else
                    pq2.poll();
                cnt--;
                if(cnt==0){		// 큐가 비어있게 되면 최대큐, 최소큐 모두 초기화!
                    pq1.clear();
                    pq2.clear();
                }
            }
        }
        int max = 0;
        int min = 0;
        if(cnt>0){
            min = pq1.peek();
            max = pq2.peek();
        }
        int[] answer = {max,min};
        return answer;
    }
}