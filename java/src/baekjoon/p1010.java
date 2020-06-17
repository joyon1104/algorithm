package baekjoon;
import java.util.*;

/*
 * [다리 놓기]
 * - dp문제
 * - 성공!
 */

public class p1010 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			long result = 0;
			long[][] dp = new long[N+1][M+1];
			if(N==0)
				System.out.println(result);
			else {
				for(int m=1; m<=M-(N-1); m++) {
					dp[1][m] = 1;
				}
				for(int n=2; n<=N; n++) {
					for(int m=n; m<=M-(N-n); m++) {
						int tmp = 0;
						for(int k=1; k<=m-1; k++) {
							tmp += dp[n-1][k];
						}
						dp[n][m] = tmp;
					}
				}
				
				for(int m = 1; m<=M; m++) {
					result += dp[N][m];
				}
				System.out.println(result);
			}
		}
	}
}
