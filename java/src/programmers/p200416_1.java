package programmers;

/*
 * [3xn 타일링]
 * -> 이해가 잘 안됨...ㅠㅠ
 */
class p200416_1 {

    int divisor = 1000000007;
    
    public int solution(int n) {
    	//큰 수를 다룰것이기 때문에 long 타입을 사용
        long[] dp = new long[n + 1];
        long add = 0;
        dp[0] = 1;
        dp[2] = 3;
        if (n == 2) return 3;
        if (n % 2 == 1) return 0;
        for (int i = 4; i <=n; i+= 2) {
            add += dp[i-4] * 2;
            dp[i] = dp[i-2] * 3 + add;
            dp[i] = dp[i] % divisor;
            add = add % divisor;
        }
        return (int) dp[n];
    }
}
