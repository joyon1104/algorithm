package SWEA;

import java.util.*;

/*
 * SWEA
 * 보호필름
 * 
 * - film 약품처리 해준 후 꼭 다시 restore 해줘야 함!
 * - 시간초과를 잡는 것이 관건!
 * 
 * 1. 최솟값 이상의 주입 횟수 시 굳이 test할 필요 없음
 * 2. K가 1인 경우 min은 무조건 0!
 */

public class p2112 {

	static Scanner sc = new Scanner(System.in);
	static int D = 0;
	static int W = 0;
	static int K = 0;
	static int min = 0;

	static void test(int[][] film, int[] drug, int k) {
		
		int[][] tmp = new int[D][W];
		
		for(int i=0; i<D; i++) {
			for(int j=0; j<W; j++) {
				tmp[i][j] = film[i][j];
			}
		}
		
		for(int i=0; i<D; i++) {
			if(drug[i] == 0) {
				for(int w=0; w<W; w++) {
					film[i][w] = 0;
				}
			}
			else if(drug[i] == 1) {
				for(int w=0; w<W; w++) {
					film[i][w] = 1;
				}
			}
		}
		
		boolean check = false;
		
		for(int w=0; w<W; w++) {
			int cnt = 1;
			int start = film[0][w];
			check = false;
			
			for(int d=1; d<D; d++) {
				if(film[d][w] != start) {
					start = film[d][w];
					cnt = 1;
					continue;
				}
				else {
					cnt++;
					if(cnt>=K) {
						check = true;
						break;
					}
				}
			}
			
			if(check == false)
				break;
			else
				continue;
		}
		
		if(check == true) {
			if(min > k)
				min = k;
		}
		
		for(int i=0; i<D; i++) {
			for(int j=0; j<W; j++) {
				film[i][j] = tmp[i][j];
			}
		}
		
		
	}
	
	static void dfs(int[][] film, int[] drug, int i, int cnt, int k) {
		if(min == 1) {
			return;
		}
		if(cnt == drug.length) {
			// 최솟값보다 작은 경우만 돌려야 시간초과 안남!
			if(k<=K && k<min) {
				test(film,drug,k);
			}
			else
				return;
		}
		
		else {
			drug[i] = 0;
			dfs(film,drug,i+1,cnt+1,k+1);
			drug[i] = 1;
			dfs(film,drug,i+1,cnt+1,k+1);
			drug[i] = 2;
			dfs(film,drug,i+1,cnt+1,k);
		}
	}
	
	public static void main(String[] args) {
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			min = K+1;
			
			int[][] film = new int[D][W];
			
			for(int i=0; i<D; i++) {
				for(int j=0; j<W; j++) {
					film[i][j] = sc.nextInt();
				}
			}
			
			int[] drug = new int[D];
			
			//와 이 조건으로 마지막 테스트케이스까지 패스!!!
			if(K == 1)
				min = 0;
			else
				dfs(film, drug, 0, 0, 0);
			
			System.out.println("#" + t + " " + min);
		}
	}
}
