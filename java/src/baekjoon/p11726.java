package baekjoon;
import java.util.*;

public class p11726 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[1001];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3; i<=n; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%10007;	//미리 나머지 계산 해줄 것
		}
		System.out.println(dp[n]);
	}	
}
