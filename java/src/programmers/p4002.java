package programmers;

import java.util.*;

class p4002 {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        int[] visited = new int[n+1];
        int[] info =  new int[n+1];
        int cnt = 1;
        visited[1] = 1;
        Queue<Integer> que = new LinkedList<Integer>();
        
        for(int i=0; i<edge.length; i++){
            if(edge[i][0] == 1){
                que.add(edge[i][1]);
                info[edge[i][1]] = 1;
                visited[edge[i][1]] = 1;
                cnt++;
            }
            else if(edge[i][1] == 1){
                que.add(edge[i][0]);
                info[edge[i][0]] = 1;
                visited[edge[i][0]] = 1;
                cnt++;
            }
        }
        
        while(!(que.isEmpty())){
            int tmp = que.poll();
            for(int i=0; i<edge.length; i++){
                if(edge[i][0] == tmp && visited[edge[i][1]] == 0){
                    visited[edge[i][1]] = 1;
                    info[edge[i][1]] = info[tmp] + 1;
                    que.add(edge[i][1]);
                    
                }
                else if(edge[i][1] == tmp && visited[edge[i][0]] == 0){
                    visited[edge[i][0]] = 1;
                    info[edge[i][0]] = info[tmp] + 1;
                    que.add(edge[i][0]);
                }
            }
        }
        
        int max = 0;
        for(int i=1; i<=n; i++){
            if(max < info[i])
                max = info[i];
        }
        
        for(int i=1; i<=n; i++){
            if(info[i] == max)
                answer++;
        }
        
        return answer;
    }
}
