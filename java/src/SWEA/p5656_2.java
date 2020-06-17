package SWEA;
import java.util.*;

/*
 * [벽돌깨기]
 * - 성공
 */

public class p5656_2 {
	
	static class Pair{
		int i;
		int j;
		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	static void printmap(int[][]map) {
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++)
				System.out.print(map[i][j]+" ");
			System.out.println();
		}
		System.out.println("----------------");
	}
	
	static int[][] copy(int[][]map) {
		int[][] tmp = new int[map.length][map[0].length];
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++)
				tmp[i][j] = map[i][j];
		}
		return tmp;
	}
	
	static int[][] rebuild(int[][]map) {
		int[][] tmp = new int[map.length][map[0].length];
		for(int j=0; j<map[0].length; j++) {
			ArrayList<Integer> arrlist = new ArrayList<>();
			for(int i=0; i<map.length; i++) {
				if(map[i][j] == 0)
					continue;
				arrlist.add(map[i][j]);
			}
			
			int idx = H-1;
			for(int i=arrlist.size()-1; i>=0; i--) {
				tmp[idx--][j] = arrlist.get(i);
			}
		}
		return tmp;
	}
	
	static int count(int[][]map) {
		int cnt=0;
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				if(map[i][j] > 0)
					cnt++;
			}
		}
		return cnt;
	}

	static int N,W,H;
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			min = Integer.MAX_VALUE;
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			int[][] map = new int[H][W];
			
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++)
					map[i][j] = sc.nextInt();
			}
			
			int[] turn = new int[N];
			for(int i=0; i<W; i++) {
				turn[0] = i;
				dfs(map,turn,0,1);
			}
			
			System.out.println("#"+t+" "+min);
		}
	}
	
	static void dfs(int[][]map, int[] turn, int idx, int cnt) {
		if(cnt == N) {
			solve(map,turn);
		}
		else {
			for(int i=0; i<W; i++) {
				turn[idx+1] = i;
				dfs(map,turn,idx+1,cnt+1);
			}
		}
	}
	
	static void solve(int[][] map, int[] turn) {
		int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
		int[][] tmp = copy(map);
		for(int j=0; j<N; j++) {
			int k = turn[j];
			int[][] visited = new int[H][W];
			int i = 0;
			for(i=0; i<H; i++) {
				if(tmp[i][k] !=0)
					break;
			}
			if(i>=H)
				break;
			Queue<Pair> que = new LinkedList<>();
			que.offer(new Pair(i,k));
			visited[i][k] = 1;
			while(!que.isEmpty()) {
				Pair p = que.poll();
				int d = tmp[p.i][p.j];
				tmp[p.i][p.j] = 0;
				for(int m=0; m<4; m++) {
					for(int n=1; n<d; n++) {
						int next_i = p.i+move[m][0]*n;
						int next_j = p.j+move[m][1]*n;
						if(next_i<0 || next_j<0 || next_i>=H || next_j>=W)
							continue;
						if(visited[next_i][next_j]!=1 && tmp[next_i][next_j]>=1) {
							que.add(new Pair(next_i,next_j));
							visited[next_i][next_j] = 1;
						}
					}
				}
			}
			tmp = rebuild(tmp);
		}//for
		
		int result = count(tmp);
		if(min > result)
			min = result;
	}
}
