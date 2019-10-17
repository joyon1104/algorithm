package baekjoon;

import java.util.*;

/*
 * 백준 A형 기출문제 
 * [색종이 붙이기]
 * => 실패
 * 
 */

class Pair{
	int i;
	int j;
	public Pair(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class p17136 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int[][] board = new int[10][10];
		Queue<Pair> que = new LinkedList<Pair>();
		int cnt = 0;
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				board[i][j] = sc.nextInt();
				if(board[i][j] == 1) {
					Pair p = new Pair(i,j);
					que.offer(p);
				}
			}
		}
		
		int[] page = {0,5,5,5,5,5};
		
		while(!(que.isEmpty())) {
			Pair p = que.poll();
			
			int n=1;
			for(n=1; n<=4; n++) {
				if(page[n+1]>0 && p.i+1<=9 && p.j+1<=9) {
					boolean check = true;
					for(int x=p.i+1; x>=0; x--) {
						if(board[x][p.j+1] == 0) {
							check = false;
							break;
						}
					}
					if(check == false)
						break;
					for(int y=p.j+1; y>=0; y--) {
						if(board[p.i+1][y] == 0) {
							check = false;
							break;
						}
					}
					if(check == false)
						break;
				}
			}
			
			for(int x=p.i; x<p.i+n; x++) {
				for(int y=p.j; y<p.j+n; y++) {
					board[x][y] = 2;
				}
			}
			page[n] = page[n]-1;
			cnt++;
				
		}
		
		for(int i=0; i<=9; i++) {
			for(int j=0; j<=9; j++) {
				if(board[i][j] == 1)
					cnt = -1;
			}
		}
		
		System.out.println(cnt);
		
	}
}
