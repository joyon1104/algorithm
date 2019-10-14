package programmers;

import java.util.*;

class p5001 {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        Comparator<int[]> c1 = (a,b)->{ 
            return a[2]-b[2]; 
        }; 
        Arrays.sort(costs,c1);
        
        if(n==1)
            return costs[0][2];
        
        int[] visited = new int[n];
        visited[costs[0][0]] = 1;
        visited[costs[0][1]] = 1;
        int cnt = 2;
        answer += costs[0][2];
        
        while(cnt<n){
            for(int i=1; i<costs.length; i++){
                if(visited[costs[i][0]]==0 && visited[costs[i][1]]==1){
                    visited[costs[i][0]]=1;
                    answer += costs[i][2];
                    cnt++;
                    break;
                }
                else if(visited[costs[i][0]]==1 && visited[costs[i][1]]==0){
                    visited[costs[i][1]]=1;
                    answer += costs[i][2];
                    cnt++;
                    break;
                }
            }
        }
        
        return answer;
    }
}
