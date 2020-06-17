package baekjoon;
import java.util.*;

public class p1149 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] color = new int[N+1][3];
		for(int i=1; i<=N; i++) {
			for(int j=0; j<3; j++)
				color[i][j] = sc.nextInt();
		}
		
		int[][] dp = new int[1001][3];
		dp[1][0] = color[1][0];
		dp[1][1] = color[1][1];
		dp[1][2] = color[1][2];
		
		for(int i=2; i<=N; i++) {
			for(int j=0; j<3; j++) {
				if(j==0) {
					dp[i][j] = Math.min(dp[i-1][j+1], dp[i-1][j+2]) + color[i][j];
				}
				else if(j==1) {
					dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j+1]) + color[i][j];
				}
				else {
					dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j-2]) + color[i][j];
				}
			}
		}
		
		System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]),dp[N][2]));
		
	}

}
