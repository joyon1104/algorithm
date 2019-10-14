package programmers;

import java.util.*;

class p2002 {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        dp[1][0] = dp[0][0] + triangle[1][0];
        dp[1][1] = dp[0][0] + triangle[1][1];
        
        for(int i=2; i<triangle.length; i++){
            for(int j=0; j<=i; j++){
                if(j==0){
                    dp[i][j] = triangle[i][j] + dp[i-1][0];
                }
                else if(j==i){
                    dp[i][j] = triangle[i][j] + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1],dp[i-1][j]);
                }
            }
        }
        
        int answer = 0;
        for(int i=0; i<triangle.length; i++){
            if(answer < dp[triangle.length-1][i])
                answer = dp[triangle.length-1][i];
        }
        
        return answer;
    }
}