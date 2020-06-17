package programmers;
/*
 * [정수 삼각형]
 */
import java.util.*;
class p200318_4 {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle[triangle.length-1].length];
        dp[0][0] = triangle[0][0];
        for(int i=0; i<triangle.length-1; i++){
            for(int j=0; j<triangle[i].length; j++){
                dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j] + triangle[i+1][j]);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j] + triangle[i+1][j+1]);
            }
        }
        for(int i=0; i<dp[0].length; i++){
            if(answer < dp[dp.length-1][i])
                answer = dp[dp.length-1][i];
        }
        return answer;
    }
}