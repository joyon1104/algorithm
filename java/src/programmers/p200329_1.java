package programmers;

/*
 * [¸Ö¸® ¶Ù±â]
 * -> dp
 */
class p200329_1 {
	  public long solution(int n) {
	      long answer = 0;
	      long[] dp = new long[2001];
	      dp[0] = 1;
	      dp[1] = 1;
	      
	      for(int i=2; i<=n; i++)
	          dp[i] = (dp[i-1] + dp[i-2])%1234567;
	      
	      answer = dp[n];
	      return answer;
	  }
}