package baekjoon;
import java.util.*;

/*
 * 자료형 유의하기!
 * dp배열의 자료형이 int이면 범위를 초과함 -> long으로 바꿔줘야함.
 */

public class p9461 {
	static int N;
	static long[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			N = sc.nextInt();
			dp = new long[101];
			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 1;
			dp[4] = 2;
			dp[5] = 2;
			for(int j=6; j<=N; j++) {
				dp[j] = dp[j-1] + dp[j-5];
			}
			System.out.println(dp[N]);
		}
	}
}
