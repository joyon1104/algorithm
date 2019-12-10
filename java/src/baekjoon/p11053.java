package baekjoon;
import java.util.*;

public class p11053 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[1001];
		int[][] dp = new int[1001][2];
		
		for(int i=1; i<=n; i++)
			arr[i] = sc.nextInt();
		
		dp[1][0] = arr[1];
		dp[1][1] = 1;
		
		for(int i=2; i<=n; i++) {
			if(dp[i-1][0] < arr[i]) {
				dp[i][1] = dp[i-1][1] + 1;
				dp[i][0] = arr[i];
			}
			else {
				dp[i][1] = dp[i-1][1];
				dp[i][0] = dp[i-1][0];
			}
		}
		
		System.out.println(dp[n][1]);
	}
}
