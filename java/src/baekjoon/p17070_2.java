package baekjoon;

import java.util.*;

public class p17070_2 {
	
	static Scanner sc = new Scanner(System.in);
	static int N = 0;
	static int cnt = 0;
	static int[][] move = {{1,0},{0,1},{1,1}};
	
	
	static void dfs(int[][] map, int i, int j, int status) {
		if(i==N && j==N) {
			cnt++;
			return;
		}
		else {
			
			if(status == 0) {
				if(j+1<=N && map[i][j+1] == 0)
					dfs(map,i,j+1,0);
				if(i+1<=N && j+1<=N && map[i+1][j+1] == 0 && map[i][j+1] == 0 && map[i+1][j] == 0)
					dfs(map,i+1,j+1,2);
			}
			else if(status == 1) {
				if(i+1<=N && map[i+1][j] == 0)
					dfs(map,i+1,j,1);
				if(i+1<=N && j+1<=N && map[i+1][j+1] == 0 && map[i][j+1] == 0 && map[i+1][j] == 0)
					dfs(map,i+1,j+1,2);
			}
			else if(status == 2) {
				if(i+1<=N && map[i+1][j] == 0)
					dfs(map,i+1,j,1);
				if(j+1<=N && map[i][j+1] == 0)
					dfs(map,i,j+1,0);
				if(i+1<=N && j+1<=N && map[i+1][j+1] == 0 && map[i][j+1] == 0 && map[i+1][j] == 0)
					dfs(map,i+1,j+1,2);
			}
		}
	}
	
	public static void main(String[] args) {
		N = sc.nextInt();
		int[][] map = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for( int j=1; j<=N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		dfs(map,1,2,0);
		
		System.out.println(cnt);
	}

}
