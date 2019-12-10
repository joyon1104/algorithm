package baekjoon;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[10001];
		int[][] dp = new int[10001][2];
		
		for(int i=1; i<=n; i++) {
			arr[i] = sc.nextInt();
		}
		
		dp[1][0] = 0;
		dp[1][1] = arr[1];
		dp[2][0] = dp[1][1];
		dp[2][1] = dp[1][1]+arr[2];
		
		for(int i=3; i<=n; i++) {
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
			dp[i][1] = Math.max(dp[i-2][1], dp[i-2][0]+arr[i-1]) + arr[i];
		}
		
		System.out.println(Math.max(dp[n][0], dp[n][1]));
		
	}	
}
