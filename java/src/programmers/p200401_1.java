package programmers;
/*
 * [배달]
 * -> 다익스트라 알고리즘!
 */
import java.util.*;
class p200401_1 {
    static int INF = 500000*50;
    static class Pair implements Comparable<Pair>{
        int idx;
        int dist;
        public Pair(int idx, int dist){
            this.idx = idx;
            this.dist = dist;
        }
        
        public int compareTo(Pair target){
            if(this.dist < target.dist)
                return -1;
            else if(this.dist > target.dist)
                return 1;
            else
                return 0;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        ArrayList<ArrayList<Pair>> arrlist = new ArrayList<>();
        for(int i=0; i<=N; i++)
            arrlist.add(new ArrayList<Pair>());
        
        for(int i=0; i<road.length; i++){
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            arrlist.get(a).add(new Pair(b,c));
            arrlist.get(b).add(new Pair(a,c));
        }
        
        int[] result = new int[N+1];
        Arrays.fill(result,INF);
        result[1] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(1,result[1]));
        
        while(!pq.isEmpty()){
            Pair current = pq.poll();
            if(current.dist > result[current.idx])
                continue;
            for(Pair p : arrlist.get(current.idx)){
                if(result[p.idx] > result[current.idx] + p.dist){
                    result[p.idx] = result[current.idx] + p.dist;
                    pq.offer(new Pair(p.idx, result[p.idx]));
                }
            }
        }
        
        for(int i=1; i<=N; i++){
            if(result[i] <= K)
                answer++;
        }

        return answer;
    }
}