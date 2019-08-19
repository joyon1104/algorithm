package SWEA;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 190813
 * 
 * SW Expert Academy
 * [모의 SW 역량테스트] 벌꿀채취
 * 
 * ->성공
 * 
 * 완전 탐색?  
 * 
 */

public class p2115 {

	static Scanner sc = new Scanner(System.in);
	
	static int N,M,C;
	static int[][] board;
	static int result;
	
	static void compute(ArrayList<Integer> first, ArrayList<Integer> second) {
		int max_1 =0;
		int max_2 =0;
		
		// check : 벌통 개수, mult : 수익 
		int check1 = 0;
		int mult1 = 0;
		int check2 = 0;
		int mult2 = 0;
		
		// 비트연산 -> 모든 경우의 수 계산 
		for(int i=0; i < 1<<M; i++) {
	        for(int j=0; j<M; j++) {
	            if((i & 1<<j) != 0) {
	                check1 += first.get(j);
	                mult1 += first.get(j) * first.get(j);
	                check2 += second.get(j);
	                mult2 += second.get(j) * second.get(j);
	            }
	        }
	        if(check1 <= C) {
	        	if(max_1 < mult1)
	        		max_1 = mult1;
	        }
	        if(check2 <= C) {
	        	if(max_2 < mult2)
	        		max_2 = mult2;
	        }
	        check1=0;
	        mult1=0;
	        check2=0;
	        mult2=0;
	    }
		
		if(result < max_1 + max_2)	// result : 양봉인1과 2가 얻은 총 수익 
			result = max_1 + max_2;
	}
	
	public static void main(String[] args) {
		int T = sc.nextInt();
		int[] results = new int[T];
		
		for(int t=0; t<T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();
			
			board = new int[N][N];
			result = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			
			ArrayList<Integer> first = new ArrayList<Integer>();	// 양봉인1
			ArrayList<Integer> second = new ArrayList<Integer>();	// 양봉인2 
			
			int ckpt =0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(j+M-1 < N) {	
						for(int jj=j; jj<=j+M-1; jj++) {
							first.add(board[i][jj]);
							ckpt = jj;	// ckpt : 양봉인 1이 꿀 채취한 영역의 가장 마지막 열 좌표값 
						}
						// 양봉인 1과 2가 같은 행에서 채취할 때
						if(ckpt+M < N) {	// ckpt+M : 양봉인 2가 양봉인1과 같은 행에서 채취할 때의 영역의 가장 마지막 열 좌표값 (N보다 작으면 같은 행에 있다는 뜻) 
							ckpt = ckpt+M;
							while(ckpt<N) {
								for(int c=0; c<M; c++) {
									second.add(board[i][ckpt-c]);
								}
								compute(first,second);
								second.clear();
								++ckpt;
							}
						}	
						if(i+1<N) {	//양봉인 1과 2가 다른 행에서 채취할 때
							for(int ii=i+1; ii<N; ii++) {	
								for(int jj=0; jj<N; jj++) {
									if(jj+M-1<N) {
										for(int k=jj; k<=jj+M-1; k++) {
											second.add(board[ii][k]);
										}
										compute(first,second);
										second.clear();
									}
								}
							}
						}	
					}
					first.clear();
				}
			}// for문 끝
			results[t] = result;
		}
		for(int t=0; t<T; t++) {
			System.out.println("#" + (t+1) + " " +results[t]);
		}
	}
}
