package baekjoon;

import java.util.Scanner;

/*
 * 190828
 * 
 * 백준 삼성 SW 역량 테스트 기출 문제
 * 
 * 13458번 
 * [시험 감독]
 * 
 * -> 반 성공 
 * 
 * < 주의할 것 >
 * - 매우 쉬운 문제이지만, 자료형 때문에 틀림.
 * - 감독관의 수(cnt)가 최대 1,000,000 * 1,000,000 이 될 수 있으므로 int형 -> long형 이어야 함.
 * 
 * */

public class p13458 {

	static Scanner sc = new Scanner(System.in);
	static int N,B,C;
	static long cnt;	// *** 자료형 제일 중요!!!
	
	
	public static void main(String[] args) {
		int N = sc.nextInt();
		int[] room = new int[N];
		cnt = 0;
		
		for(int i=0; i<N; i++) {
			room[i] = sc.nextInt();
		}
		
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		for(int i =0; i<N; i++) {
			int num = room[i];
			cnt++;
			if(num <= B)
				continue;
			else {
				int submaster = (num-B)/C;
				cnt += submaster;
				if((num-B)%C != 0)
					cnt++;
			}
		}
		
		System.out.println(cnt);
		
		
	}
}
