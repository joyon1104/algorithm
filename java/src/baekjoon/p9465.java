package baekjoon;
import java.util.*;

public class p9465 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int[][] sticker = new int[2][N+1];
			int[][] dp = new int[2][N+1];
			
			for(int i=0; i<2; i++) {
				for(int j=1; j<=N; j++)
					sticker[i][j] = sc.nextInt();
			}
			dp[0][1] = sticker[0][1];
			dp[1][1] = sticker[1][1];
			
			for(int j=2; j<=N; j++) {
				dp[0][j] = sticker[0][j] + Math.max(dp[1][j-1], dp[1][j-2]);
				dp[1][j] = sticker[1][j] + Math.max(dp[0][j-1], dp[0][j-2]);
			}
			System.out.println(Math.max(dp[0][N], dp[1][N]));
		}
	}
}
