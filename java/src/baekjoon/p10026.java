package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 190812
 * 
 * 백준 9466번
 * -> 분류 : DFS
 * 
 * [ 적록색약 ]
 * 
 * => 성공
 */


public class p10026 {

	static Scanner sc = new Scanner(System.in);
	static int N;
	static char [][] map;
	static int[][] visited;
	static int cnt;
	static int cnt_rg;
	
	//dfs 구현
	static void dfs(int i, int j) {
		visited[i][j] = 1;
		
		if(i-1>=0 && map[i][j] == map[i-1][j]  && visited[i-1][j] == 0)
			dfs(i-1, j);
		if(i+1<N && map[i][j] == map[i+1][j] && visited[i+1][j] ==0)
			dfs(i+1, j);
		if(j-1>=0 && map[i][j] == map[i][j-1] && visited[i][j-1] ==0)
			dfs(i, j-1);
		if(j+1<N && map[i][j] == map[i][j+1] && visited[i][j+1] ==0)
			dfs(i, j+1);
	}
	
	public static void main(String[] args) {
		N = sc.nextInt();
		map = new char[N][N];
		
		for(int i=0; i<N; i++) {
			String str = sc.next();
			char[] ch = str.toCharArray();
			for(int j=0; j<N; j++) {
				map[i][j] = ch[j];
			}
		}
		
		// 방문 여부 표시
		visited = new int[N][N];
		
		// 구역 수 구하기 (적록색약 X)
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j] == 0) {	// 방문하지 않은 곳 -> dfs -> 구역 수 증가
					dfs(i,j);
					cnt++;
				}
			}
		}
		
		// 초기화 
		visited = new int[N][N];
		
		// 적록색약 (G -> R 로 바꿈)
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 'G')
					map[i][j] = 'R';
			}
		}
		
		// 구역 수 구하기 (적록색약 O)
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j] == 0) {	// 방문하지 않은 곳 -> dfs -> 구역 수 증가
					dfs(i,j);
					cnt_rg++;
				}
			}
		}
		
		System.out.println(cnt + " " + cnt_rg);
		
	}
}
