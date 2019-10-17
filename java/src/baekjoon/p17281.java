package baekjoon;

import java.util.*;

/*
 * 191016
 * 
 * 백준 삼성 A형 기출 문제
 * 
 * 17281번 
 * [야구]
 * 
 * 
 * 문제 분류 : 완전탐색
 * -> 성공
 * <주의할것>
 * 1. 야구 타석은 1루,2루,3루 총 3개이다... (4개아님...)
 * 2. 점수별 홈으로 들어오고 base 초기화 잘 해주기!
 * 
 */

public class p17281 {
	
	static Scanner sc = new Scanner(System.in);
	static int N = 0;
	static int max = 0;
	
	public static void playGame(int[][] score, int[] player, int result) {
		int i = 1;
		int start = 1;
		while(i<=N) {
			int[] base = new int[3];
			int out = 0;
			while(out<3) {
				for(int j=start; j<=9; j++) {
					if(score[i][player[j]] == 1) {
						if(base[2]>0)
							result++;
						for(int k=1; k>=0; k--) {
							base[k+1] = base[k];
						}
						base[0] = player[j];
					}
					else if(score[i][player[j]] == 2) {
						if(base[2]>0)
							result++;
						if(base[1]>0)
							result++;
						base[2] = base[0];
						base[1] = player[j];
						base[0] = 0;
					}
					else if(score[i][player[j]] == 3) {
						if(base[2]>0)
							result++;
						if(base[1]>0)
							result++;
						if(base[0]>0)
							result++;
						base[2] = player[j];
						base[1] = 0;
						base[0] = 0;
					}
					else if(score[i][player[j]] == 4) {
						if(base[2]>0)
							result++;
						if(base[1]>0)
							result++;
						if(base[0]>0)
							result++;
						result++;
						for(int k=0; k<3; k++) {
							base[k] = 0;
						}
					}
					else if(score[i][player[j]] == 0) {
						out++;
						if(out >= 3) {
							start = j+1;
							if(start>9)
								start = 1;
							break;
						}
					}
					if(j == 9)
						j = 0;
				}
			}
			i++;
		}
		if(max<result) {
			max = result;
		}
	}
			
	public static void dfs(int[][] score, int[] player,int[] visited, int n, int cnt) {
		if(cnt == 9) {
			playGame(score,player,0);
		}
		else if(n == 4) {
			dfs(score,player,visited,n+1,cnt);
		}
		else {
			for(int i=1; i<=9; i++) {
				if(visited[i] == 0) {
					player[n] = i;
					visited[i] = 1;
					dfs(score, player,visited,n+1, cnt+1);
					player[n] = 0;
					visited[i] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		N = sc.nextInt();
		
		int[][] score = new int[N+1][10];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=9; j++) {
				score[i][j] = sc.nextInt();
			}
		}
		
		int[] player = new int[10];
		int[] visited = new int[10];
		player[4] = 1;
		visited[1] = 1;
		
		dfs(score,player,visited, 1, 1);
		
		System.out.println(max);
		
	}
	
}
