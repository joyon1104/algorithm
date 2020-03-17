package programmers;
/*
 * [네트워크]
 */
import java.util.*;
class p200317_4 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] visited = new int[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(computers[i][j]==1 && visited[i]==0 && visited[j]==0){
                    Queue<Integer> que = new LinkedList<>();
                    que.add(i);
                    visited[i] = 1;
                    while(!que.isEmpty()){
                        int tmp = que.poll();
                        for(int k=0; k<n; k++){
                            if(tmp==k)
                                continue;
                            if(computers[tmp][k]==1 && visited[k]==0){
                                que.add(k);
                                visited[k] = 1;
                            }
                        } 
                    }
                    answer++;
                }
            }
        }
        return answer;
    }
}