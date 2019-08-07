package baekjoon;

import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 190807
 * 
 * 백준 9465번
 * -> 분류 : DP (Dynamic Programming)
 * 
 * => 틀림.
 * 정답참고 :  https://dundung.tistory.com/13
 */

public class p9465 {
	
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();
        
        for(int t=0; t<tc; t++) {
            int n = scan.nextInt();
            int [][] a = new int[2][n+1];
            int [][] dp = new int[n+1][3];
 
            for(int i=0; i<2; i++)
                for(int j=1; j<=n; j++)
                    a[i][j] = scan.nextInt();
            
            dp[1][0] = 0; //X X
            dp[1][1] = a[0][1]; //O X
            dp[1][2] = a[1][1]; //X O
            
            for(int i=2; i<=n; i++) {
                dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
                dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2])+a[0][i];
                dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1])+a[1][i];
            }
                    
            System.out.println(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));
        }
    }
 
}
