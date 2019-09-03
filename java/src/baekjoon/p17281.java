package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 190902
 * 
 * 백준 삼성 A형 기출 문제
 * 
 * 17281번 
 * [야구]
 * 
 * -> 실패
 * 
 * 문제 분류 : 완전탐색
 * 
 */

public class p17281 {

	static int N;
	static int max;
	
	static Scanner sc = new Scanner(System.in);
	
	static void Baseball(int[] output, int[][] board, int N) {
		ArrayList<Integer> arrlist = new ArrayList<Integer>();
		for(int i=0; i<output.length; i++) {
			arrlist.add(output[i]);
		}
		arrlist.add(0,0);
		arrlist.add(4,1);
		
		int start = 1;
		int score = 0;
		
		while(N>0) {
			int[] ground = new int[4];
			int out_cnt = 0;
			
			for(int i=start; i<arrlist.size(); i++) {
				if(arrlist.get(i)==0)
					out_cnt++;
				
				else if(arrlist.get(i) == 1) {
					for(int j=3; j>0; j--) {
						if(ground[j] == 1) {
							ground[j] = 0;
							if(j+1>3)	score++;
							else ground[j+1] = 1;
						}
					}
					ground[0] = 1;
				}
				
				else if(arrlist.get(i) == 2) {
					for(int j=3; j>0; j--) {
						if(ground[j] == 1) {
							ground[j] = 0;
							if(j+2>3)	score++;
							else ground[j+2] = 1;
						}
					}
					ground[1] = 1;
				}
				
				else if(arrlist.get(i) == 3) {
					for(int j=3; j>0; j--) {
						if(ground[j] == 1) {
							ground[j] = 0;
							if(j+3>3)	score++;
							else ground[j+3] = 1;
						}
					}
					ground[2] = 1;
				}
				
				else if(arrlist.get(i) == 4) {
					for(int j=3; j>=0; j--) {
						if(ground[j] == 1) {
							score++;
						}
					}
					score++;
				}
				
				if(out_cnt == 3) {
					start = i+1;
					if(i+1>9) 
						start = 0;
					break;
				}
				
				if(i+1 >9)
					i = -1;
			}//for
			
			N--;
		}//while
		
		if(max < score)
			max = score;
		
	}
	
	static void perm(int[] arr, int[] output, boolean[] visited, int[][] board, int depth, int n) {
	    if(depth == n) {
	    	Baseball(output,board,N);
	        return;
	    }
	 
	    for(int i=0; i<n; i++) {
	        if(visited[i] != true) {
	            visited[i] = true;
	            output[depth] = arr[i];
	            perm(arr, output, visited, board, depth + 1, n);       
	            output[depth] = 0; // 이 줄은 없어도 됨
	            visited[i] = false;;
	        }
	    }
	}
 
	public static void main(String[] args) {
	
		N = sc.nextInt();
		
		int start = 1;
		
		int[] turn = new int[10];
		turn[4] = 1;
		
		int[][] board = new int[N+1][10];
		
		for(int i=1; i<=N ;i++) {
			for(int j=1; j<=9; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		int[] arr = {2,3,4,5,6,7,8,9};
		boolean[] visited = new boolean[8];
		int[] output = new int[8];
		
		perm(arr,output,visited,board,0,8);
		
		System.out.println(max);
		
		
	}
}
