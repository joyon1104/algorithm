package baekjoon;
import java.util.Scanner;


public class p14501 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] T = new int[N+2];	// 기간	
		int[] P = new int[N+2];	// 가격
		int[] dp = new int[N+2];// 최대금액
		
		for(int i=1; i<=N; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		
		for(int i=N; i>0; i--) {
			int day = i + T[i];
			if(day <= N+1)	//ex) N이 7일 때 7일째날 기간이 1인 상담은 7일 하루동안 할 수 있으므로 N+1
				dp[i] = Math.max(dp[day]+P[i], dp[i+1]);	// ex) 5일째 요금 + 7일째 최대 금액 과 (5일날 일하지 않을 때) 6일날 최대금액 사이의 최대값!
			else
				dp[i] = dp[i+1];
		}
		System.out.println(dp[1]);
	}
}
