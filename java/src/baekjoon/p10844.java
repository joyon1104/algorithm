package baekjoon;
import java.util.*;

public class p10844 {
	static long result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		long[][] dp = new long[101][10];
		for(int i=1; i<=9; i++)
			dp[1][i] = 1;
		
		for(int i=2; i<=N; i++) {
			for(int j=0; j<=9; j++) {
				if(j==0)
					dp[i][j] = dp[i-1][j+1];
				else if(j==9)
					dp[i][j] = dp[i-1][j-1];
				else {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
				}
				dp[i][j] %= 1000000000;
			}
		}
		
		long result = 0;
		for(int j=0; j<=9; j++) {
			result +=dp[N][j];
			result %= 1000000000;
		}
		System.out.println(result);
		
	}
}
