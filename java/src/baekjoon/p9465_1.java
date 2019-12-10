package baekjoon;
import java.util.*;

public class p9465_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int n = sc.nextInt();
			int[][] score = new int[3][100001];
			int[][] dp = new int[3][100001];
			
			for(int i=1; i<=2; i++) {
				for(int j=1; j<=n; j++)
					score[i][j] = sc.nextInt();
			}
			
			dp[1][1] = score[1][1];
			dp[1][2] = score[1][2];
			dp[2][1] = dp[1][2] + score[2][1];
			dp[2][2] = dp[1][1] + score[2][2];
			
			for(int i=3; i<=n; i++) {
				dp[1][i] = score[1][i] + Math.max(dp[2][i-1], dp[2][i-2]);
				dp[2][i] = score[2][i] + Math.max(dp[1][i-1], dp[1][i-2]);
			}
			
			System.out.println(Math.max(dp[1][n],dp[2][n]));
			
		}
	}

}
