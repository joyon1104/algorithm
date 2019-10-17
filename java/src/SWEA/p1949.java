package SWEA;

import java.util.*;

/*
 * SWEA
 * 1949번. 등산로 조성
 * 
 * 풀이방법 : DFS
 * 
 * <주의할 것>
 * 1. 한 곳의 지형만 깎을 수 있다.
 * 2. 최대 K까지 깎을 수 있으므로 1~K까지 깎는 경우를 모두 고려해야 한다.
 * 3. 한번 깎인 곳은 등산로 길이를 구할 때 까지 깎여있지만 새로운 봉우리 부터 시작할 때는 초기화 된다.
 * 
 * => 문제를 제대로 읽지 않아 헤맨 문제.. 문제 제대로 이해하고 넘어갈 것!
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

public class p1949 {
	
	static Scanner sc = new Scanner(System.in);
	static int T = 0;
	static int K = 0;
	static int N = 0;
	static int result = 0;
	static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void dfs(Pair p, int[][]map, int[][]visited, int cnt, boolean check) {
		
		if(result < cnt)
			result = cnt;
		
		for(int i=0; i<4; i++) {
			int next_i = p.i+move[i][0];
			int next_j = p.j+move[i][1];
			if(next_i >=0 && next_j >=0 && next_i < map.length && next_j < map.length) {
				if(visited[next_i][next_j] == 0) { 
					if(map[next_i][next_j] < map[p.i][p.j]) {
						visited[next_i][next_j] = 1;
						Pair tmp = new Pair(next_i,next_j);
						dfs(tmp,map,visited,cnt+1,check);
						visited[next_i][next_j] = 0;
					}
					else {
						if(check == true) {
							for(int k=K; k>=1; k--) {
								if(map[next_i][next_j]-k < map[p.i][p.j] && map[next_i][next_j]-k>=0) {
									map[next_i][next_j] = map[next_i][next_j]-k;
									visited[next_i][next_j] = 1;
									Pair tmp = new Pair(next_i,next_j);
									dfs(tmp,map,visited,cnt+1,false);
									map[next_i][next_j] = map[next_i][next_j]+k;
									visited[next_i][next_j] = 0;
								}
							}
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			result = 0;
			N = sc.nextInt();
			K = sc.nextInt();
			
			int[][] map = new int[N][N];
			int max = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
					if(max < map[i][j])
						max = map[i][j];
				}
			}
			
			Queue<Pair> que = new LinkedList<Pair>();
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(max == map[i][j]) {
						Pair p = new Pair(i,j);
						que.offer(p);
					}
				}
			}
			
			while(!(que.isEmpty())) {
				Pair tmp = que.poll();
				int[][] visited = new int[N][N];
				visited[tmp.i][tmp.j] = 1;
				dfs(tmp,map,visited,1,true);
			}

			System.out.println("#"+t+" "+ result);
		}
	}

}
