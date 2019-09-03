package baekjoon;

import java.util.Scanner;

/*
 * 190828
 * 
 * 백준 삼성 SW 역량 테스트 기출 문제
 * 
 * 14501번 
 * [퇴사]
 * 
 * -> 실패 (stack overflow)
 * 
 */

public class p14501 {

	static int N, max;
	static int[][] schedule;
	
	static Scanner sc = new Scanner(System.in);
	
	static void compute (int[][] schedule, int i, int[] check, int sum) {
		
		if(sum > max)
			max = sum;
		
		if(i>N) 
			return;
		
		if(schedule[i][0] != 0) {
			check[i] = 1;
			compute(schedule, i+schedule[i][0]-1, check, sum+schedule[i][1]);
		}
		
		check[i] = 0;
		compute(schedule, i+1, check, sum);
		
		
	}
	
	public static void main(String[] args) {
		
		N = sc.nextInt();
		schedule = new int[N+1][2];
		int[] check = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			int t = sc.nextInt();
			int p = sc.nextInt();
			
			if(i+t-1<=N) {
				schedule[i][0] = t;
				schedule[i][1] = p;
			}
		}
		
		compute(schedule,1,check,0);
		System.out.println(max);
		
	}
}
