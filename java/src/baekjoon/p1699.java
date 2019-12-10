package baekjoon;
import java.util.*;

public class p1699 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[100001];
		
		dp[1] = 1; dp[2] = 2; dp[3] = 3;
		for(int i = 4; i<=n ; i++) {
			dp[i] = 100001;
			for(int j=1; j*j<=i; j++) {
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);
			}
		}
		System.out.println(dp[n]);
	}
}
