package baekjoon;
import java.util.*;


public class p2665_X {
	static int min = 2500;
	
	static void dfs(int[][] room, int[][] visited, int i, int j, int n) {
		int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
		if(min < n)
			return;
		
		if(i == room.length-1 && j == room.length-1) {
			if(min > n)
				min = n; 
		}
		else {
			for(int k=0; k<4; k++) {
				int next_i = i + move[k][0];
				int next_j = j + move[k][1];
				
				if(next_i >=0 && next_j>=0 && next_i<room.length && next_j<room.length && visited[next_i][next_j] == 0) {
					visited[next_i][next_j] = 1;
					if(room[next_i][next_j] == 0)
						dfs(room, visited, next_i, next_j, n+1);
					else
						dfs(room, visited, next_i, next_j, n);
					visited[next_i][next_j] = 0;
				}
			}
			
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String N = sc.nextLine();
		int n = Integer.parseInt(N);
		int[][] room = new int[n][n];
		
		for(int i=0; i<n; i++) {
			String str = sc.nextLine();
			String[] arr;
			arr = str.split("");
			for (int j=0; j<n; j++) {
				room[i][j] = Integer.parseInt(arr[j]);
			}
		}
		
		int[][] visited = new int[n][n];
		visited[0][0] = 1;
		
		dfs(room,visited,0,0,0);
		System.out.println(min);
		
	}
}
