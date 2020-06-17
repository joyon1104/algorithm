package SWEA;
import java.util.*;

public class p5656_1 {
	static class Pair{
		int i;
		int j;
		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	static void printmap(int[][] map) {
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("--------------------");
	}
	
	static int result;
	static int[][] moved = {{0,1},{1,0},{0,-1},{-1,0}};
	
	static int[][] rebuild(int[][] map, int[][] visited) {
		for(int i=0; i<visited.length; i++) {
			for(int j=0; j<visited[0].length; j++) {
				if(visited[i][j] > 0) {
					map[i][j] = 0;
				}
			}
		}
		
		int[][] result = new int[map.length][map[0].length];
		for(int j=0; j<map[0].length; j++) {
			Queue<Integer> qu = new LinkedList<>();
			for(int i=map.length-1; i>=0; i--) {
				if(map[i][j] > 0)
					qu.offer(map[i][j]);
			}
			int idx = map.length-1;
			while(!qu.isEmpty()) {
				result[idx--][j] = qu.poll();
			}
		}
		return result;
	}
	
	static void bfs(int[][] map, int[][] visited, Queue<Pair>que, int cnt, int N) {
		if(cnt > N) {
			int sum = 0;
			for(int i=0; i<map.length; i++) {
				for(int j=0; j<map[0].length; j++) {
					if(map[i][j] > 0)
						sum++;
				}
			}
			
			if(sum < result) {
				result = sum;
				printmap(visited);
			}
			
		}
		else {
			while(!que.isEmpty()) {
				Pair p = que.poll();
				for(int i=1; i<map[p.i][p.j]; i++) {
					for(int j=0; j<4; j++) {
						int next_i = p.i + moved[j][0]*i;
						int next_j = p.j + moved[j][1]*i;
						if(next_i>=0 && next_j>=0 && next_i<map.length && next_j<map[0].length) {
							if(visited[next_i][next_j] == 0 && map[next_i][next_j] > 0) {
								visited[next_i][next_j] = 1;
								que.offer(new Pair(next_i,next_j));
							}
						}
					}
				}
			}
			
			map = rebuild(map,visited);
			
			for(int j=0; j<map[0].length; j++) {
				for(int i=0; i<map.length; i++) {
					if(map[i][j] > 0) {
						Queue<Pair> tque = new LinkedList<>();
						tque.offer(new Pair(i,j));
						int[][] tvisited = new int[map.length][map[0].length];
						tvisited[i][j] = 1;
						bfs(map,tvisited,tque,cnt+1,N);
						break;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int W = sc.nextInt();
			int H = sc.nextInt();
			int[][] map = new int[H][W];
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++)
					map[i][j] = sc.nextInt();
			}
			
			result = 15*12;
			for(int j=0; j<W; j++) {
				for(int i=0; i<H; i++) {
					if(map[i][j] > 0) {
						Queue<Pair> que = new LinkedList<>();
						que.offer(new Pair(i,j));
						int[][] visited = new int[H][W];
						visited[i][j] = 1;
						bfs(map,visited,que,1,N);
						break;
					}
				}
			}
			
			System.out.println("#"+t+" "+result);
		}
	}
}
