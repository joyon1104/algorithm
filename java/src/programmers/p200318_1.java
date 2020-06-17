package programmers;
/*
 * [디스크 컨트롤러]
 */
import java.util.*;
class p200318_1 {
    static class Pair implements Comparable<Pair> {
        int start;
        int time;
        
        public Pair(int start, int time){
            //super();
            this.start = start;
            this.time = time;
        }
        
        @Override
        public int compareTo(Pair target){
            if(this.time > target.time)
                return 1;
            else if(this.time < target.time)
                return -1;
            return 0;
        }
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] visited = new int[jobs.length];
        int cnt = 0;
        int t = 0;
        while(cnt<jobs.length){
            for(int i=0; i<jobs.length; i++){
                if(visited[i]==0 && jobs[i][0]<=t){
                    pq.add(new Pair(jobs[i][0],jobs[i][1]));
                    visited[i] = 1;
                }
            }
            if(pq.size()==0){
                t++;
                continue;
            }
            Pair tmp = pq.poll();
            cnt++;
            t += tmp.time;
            answer += t-tmp.start;
        }
        return answer/jobs.length;
    }
}