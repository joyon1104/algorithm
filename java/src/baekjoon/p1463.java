package baekjoon;

import java.util.Arrays;
import java.util.Scanner;


/*
 * 190806
 * 
 * 백준 1463번
 * -> 분류 : DP (Dynamic Programming)
 * 
 */
public class p1463 {

	static int X;
	static int[] memory;
	static Scanner sc = new Scanner(System.in);
	
	// 내가 푼 것 (재귀 : top-down 방식)
	static int make_one (int X){
		if(X == 1) {
			memory[X] = 0;	
		}
		else if(memory[X] != -1) {	//배열 안에 이미 계산한 값이면 해당 값을 리턴 
			return memory[X];
		}	
		else {	
			int n = 0;				// n에 우선 2로 나눌 때와 3으로 나눌 때 중 더 작은 값을 저장한다.
			if(X%2 == 0 && X%3 !=0) {
				n = make_one(X/2);
			}
			else if(X%3 == 0 && X%2 !=0)
				n = make_one(X/3);
			else if(X%3 != 0 && X%2 !=0)
				n = make_one(X-1);
			else if(X%3 == 0 && X %2 ==0) {
				if(make_one(X/3) < make_one(X/2)){
					n = make_one(X/3);
				}
				else
					n = make_one(X/2);
			}
			if(make_one(X-1)< n)		// 1을 뺄 때와 n을 비교하여 더 작은 값을 선택하여, 1을 더해준 뒤 memory[X]에 저장
				memory[X] = 1 + make_one(X-1);
			else
				memory[X] = n + 1;
		}
		return memory[X];
	}
	
	// 더 간단한 top-down 재귀 코드
	static int resolve(int n,int[] dp)
    {
        if( n == 1) return 0;
        if (dp[n] > 0)
        {
            return dp[n];
        }
        dp[n] = resolve(n-1,dp)+1;

        if(n%3 == 0)
        {
           Math.min(dp[n],resolve(n/3,dp)+1);
        }
        if(n%2 == 0)
        {
            Math.min(dp[n],resolve(n/2,dp)+1);
        }
        return dp[n];
    }
	
	/*
	 * 재귀를 쓰지 않는 bottom-up 방식 코드
	 * : 0일때부터 시작해서 입력한 값의 답을 찾을때까지 무한루프를 도는 방식
	 *  
		public class p1463 {
		    public static void main(String[] args) {
		        Scanner sc = new Scanner(System.in);
		        int n = sc.nextInt();
		        int dp[] = new int[n + 1];
		        dp[0] = dp[1] = 0;
		        for (int i = 2; i <= n; i++) {	
		            dp[i] = dp[i - 1] + 1;
		            if (i % 2 == 0)
		                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
		            if (i % 3 == 0)
		                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
		        }
		        System.out.println(dp[n]);
		        sc.close();
		    }
		}
	 */
	
	
	public static void main(String[] args) {
		X = sc.nextInt();
		memory = new int[X+1];
		Arrays.fill(memory, -1);
		
		System.out.println(make_one(X));
	}
}
