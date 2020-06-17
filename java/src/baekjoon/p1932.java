package baekjoon;
import java.util.*;

public class p1932 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=i; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int[][] dp = new int[N+1][N+1];
		dp[1][1] = map[1][1];
		for(int i=2; i<=N; i++) {
			for(int j=1; j<=i; j++) {
				if(j==1)
					dp[i][j] = dp[i-1][j] + map[i][j];
				else if(j==i)
					dp[i][j] = dp[i-1][j-1] + map[i][j];
				else
					dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + map[i][j];
			}
		}
		
		int result = 0;
		for(int i=1; i<=N; i++) {
			if(result < dp[N][i])
				result = dp[N][i];
		}
		System.out.println(result);
	}
}
