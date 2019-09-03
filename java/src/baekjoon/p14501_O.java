package baekjoon;

import java.util.*;
 
/*
 * 190828
 * 
 * 백준 삼성 SW 역량 테스트 기출 문제
 * 
 * 14501번 
 * [퇴사]
 * 
 * -> 정답 (참고 : https://bcp0109.tistory.com/8)
 * 
 * 문제 분류 : DP
 * 
 */

public class p14501_O {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] T = new int[N+2];
        int[] P = new int[N+2];
        int[] dp = new int[N+2];
 
        for(int i=1; i<=N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }
        
        // dp 시작
        for(int i=N; i>0; i--) {
            int day = i + T[i];     // i번째 날의 상담기간
 
            if(day <= N+1) 
                dp[i] = Math.max(P[i] + dp[day], dp[i+1]);
            else
                // 상담일 초과
                dp[i] = dp[i+1];
        }
 
         System.out.println(dp[1]);
    }
}
