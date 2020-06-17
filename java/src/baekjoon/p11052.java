package baekjoon;
import java.util.*;

public class p11052 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] P = new int[N+1];
		int[] dp = new int[N+1];
		for(int i=1; i<=N; i++) {
			P[i] = sc.nextInt();
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=i; j++) {
				dp[i] = Math.max(P[j]+dp[i-j],dp[i]);
			}
		}
		System.out.println(dp[N]);
	}
}
