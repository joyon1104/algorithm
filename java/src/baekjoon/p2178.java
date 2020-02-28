package baekjoon;
import java.util.*;

public class p2178 {
	static int N;
	static int M;
	static int[][] map;
	static int[][] visited;
	static int[][] moved = {{0,1},{1,0},{0,-1},{-1,0}};
	static int min;
	
	static void dfs(int x, int y, int cnt) {
		visited[x][y] = cnt;
		for(int k=0; k<4; k++) {
			int next_x = x + moved[k][0];
			int next_y = y + moved[k][1];
			
			if(next_x >=1 && next_y>=1 && next_x<=N && next_y<=M) {
				if(map[next_x][next_y] == 1) {
					// 재귀 생성을 최소화 하기위해 재귀 생성 전에 if문으로 처리.
					if(visited[next_x][next_y] > cnt+1 || visited[next_x][next_y] == 0) {
						dfs(next_x,next_y,cnt+1);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String[] sarr = line.split(" ");
		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);
		map = new int[N+1][M+1];
		visited = new int[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			String ss = sc.nextLine();
			for(int j=1; j<=M; j++) {
				map[i][j] = Integer.parseInt(ss.substring(j-1,j));
			}
		}
		
		dfs(1,1,1);
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				System.out.print(visited[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(visited[N][M]);
	}
}
