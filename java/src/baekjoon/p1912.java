package baekjoon;
import java.util.*;

public class p1912 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[100001];
		int[] dp = new int[100001];
		
		for(int i=1; i<=n; i++) {
			arr[i] = sc.nextInt();
			dp[i] = arr[i];
		}
		
		for(int i=1; i<=n; i++) {
			int sum = 0;
			for(int j=i; j<=n; j++) {
				sum += arr[j];
				if(dp[i] < sum)
					dp[i] = sum;
			}
		}
		
		int max = -1000;
		for(int i=1; i<=n; i++)
			max = Math.max(max, dp[i]);
		
		System.out.println(max);
			
	}
}
