package baekjoon;
import java.util.*;

public class p1912_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] dp = new int[N][2];
		for(int i=0; i<N; i++) {
			dp[i][0] = sc.nextInt();
			if(i==0) {
				dp[i][1] = dp[i][0];
				continue;
			};
			dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]) + dp[i][0];
		}
		int max = -1000;
		for(int i=0; i<N; i++) {
			for(int j=0; j<2; j++) {
				if(max < dp[i][j])
					max = dp[i][j];
			}
		}
		System.out.println(max);
	}
}
