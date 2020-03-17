package programmers;
/*
 * [2*n 타일링]
 */

class p200317_2 {
	  public int solution(int n) {
	      int[] dp = new int[60001];
	      dp[1] = 1;
	      dp[2] = 2;
	      for(int i=3; i<=n; i++){
	          dp[i] = dp[i-1] + dp[i-2];
	          dp[i] %= 1000000007;
	      }
	      return dp[n];
	  }
	}