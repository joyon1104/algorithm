package programmers;

import java.util.*;

class p4001 {
    static int num = 0;
    static Queue<Integer> que = new LinkedList<Integer>();
    public int solution(int n, int[][] computers) {
        
        int[] visited = new int[computers.length];
        que.add(0);
        BFS(n, computers, visited);
        
        return num;
    }
    
    public static void BFS(int n, int[][] computers, int[] visited){
        while(!(que.isEmpty())){
            int tmp = que.poll();
            visited[tmp] = 1;
            for(int i=0; i<n; i++){
                if(i!=tmp && computers[tmp][i] == 1 && visited[i] == 0)
                    que.add(i);
            }
        }
        num++;
        for(int k=0; k<n; k++){
            if(visited[k] == 0){
                que.add(k);
                BFS(n, computers, visited);
                break;
            }
        }
    }
}
