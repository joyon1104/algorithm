package programmers;
import java.util.*;

/*
 * [기능개발]
 */

class p200304_2 {
    static class Pair{
        int p;
        int s;
        public Pair(int p, int s){
            this.p = p;
            this.s = s;
        }
    }
    public int[] solution(int[] progresses, int[] speeds) {
        int day = 0;
        Queue<Pair> que = new LinkedList<Pair>();
        Queue<Integer> result = new LinkedList<Integer>();
        
        for(int i=0; i<progresses.length; i++)
            que.offer(new Pair(progresses[i],speeds[i]));
        
        while(!que.isEmpty()){
            day++;
            int cnt = 0;
            while(!que.isEmpty() && que.peek().p + day* que.peek().s >=100){
                cnt++;
                que.poll();
            }
            if(cnt>0)
                result.offer(cnt);
        }
        
        int[] answer = new int[result.size()];
        for(int i=0; i<answer.length; i++)
            answer[i] = result.poll();
        
        return answer;
    }
}