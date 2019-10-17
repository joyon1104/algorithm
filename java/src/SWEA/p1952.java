package SWEA;

import java.util.*;

//참고 : https://2youngjae.tistory.com/72

public class p1952 {
	static Scanner sc = new Scanner(System.in);
	static int T = 0;
	static int min = 0;
	
	public static void main(String[] args) {
		T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int[] tickets = new int[4];
			int[] plan = new int[13];
			tickets[0] = sc.nextInt();
			tickets[1] = sc.nextInt();
			tickets[2] = sc.nextInt();
			tickets[3] = sc.nextInt();
			
			for(int i=1; i<=12; i++) {
				plan[i] = sc.nextInt();
			}
			
			int[] dMonth = new int[13];
			int[] dp = new int[13];
			
			// 최솟값 갱신 -> min(일수*1일권, 한달권)
			for(int i=1; i<13; i++) {
				dMonth[i] = Math.min(plan[i]*tickets[0], tickets[1]);
			}
			
			// 3달권 포함 최솟값 갱신
			for(int i=1; i<13; i++) {
				dp[i] = dp[i-1] + dMonth[i];
				if(i-3>=0) {
					dp[i] = Math.min(dp[i], dp[i-3] + tickets[2]);
				}
			}
			
			if(dp[12] > tickets[3])
				dp[12] = tickets[3];
			
			System.out.println("#"+t+" "+dp[12]);
						
		}
	}

}
