package baekjoon;

import java.util.*;

/*
 * 백준 A형 기출문제 
 * [색종이 붙이기]
 * => 정답
 * 
 */


public class p17136_O {

	static Scanner sc = new Scanner(System.in);
	static int[][] board = new int[10][10];
	static int[] page = {0,5,5,5,5,5};
	static int min = 100;
	
	
	static class Pair{
		int i;
		int j;
		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	public static void fill(int r, int c, int len , int status) {
		for(int i=r; i<r + len; i++) {
            for(int j=c; j<c + len; j++)
                board[i][j] = status;
		}
	}
	
	public static boolean check (int r, int c, int len) {
		if(r + len > 10 || c + len > 10) 
			return false;
		
        for(int i=r; i<r + len; i++) {
            for(int j=c; j<c + len; j++) {
                if(board[i][j] == 0) 
                	return false;
            }
        }
        
        return true;
	}
	
	public static void dfs(int idx, int cnt) {
		if(idx == 100) {
			min = Math.min(min, cnt);
			return;
		}
		int r = idx/10;	//행 
        int c = idx%10;	//열 
        
        if(min <= cnt) return;
        
        if(board[r][c] == 1) {
            for(int i=5; i>0; i--) {
                if(page[i] > 0) {
                    if(check(r, c, i)) {
                        fill(r, c, i, 0);
                        page[i]--;
                        dfs(idx+1, cnt+1);
                        fill(r, c, i, 1);
                        page[i]++;
                    }
                }
            }
        } 
        else
        	dfs(idx+1, cnt);
			
	}
	
	public static void main(String[] args) {
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		dfs(0, 0);
        System.out.println(min == 100 ? -1 : min);
		
	}
}
