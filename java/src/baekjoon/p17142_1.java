package baekjoon;
import java.util.*;

public class p17142_1 {

	static class Pair{
		int i;
		int j;
		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	static void printmap(int[][] map) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++)
				System.out.print(map[i][j]+" ");
			System.out.println();
		}
		System.out.println("================");
	}
	
	static int N,M,min,cnt;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		min = Integer.MAX_VALUE;
		map = new int[N][N];
		ArrayList<Pair> arrlist = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==2)
					arrlist.add(new Pair(i,j));
				else if(map[i][j]==0)
					cnt++;
			}
		}
		if(cnt==0) {
			System.out.println(0);
			return;
		}
		
		int[][] virous = new int[M][2];
		for(int i=0; i<=arrlist.size()-M; i++) {
			virous[0][0] = arrlist.get(i).i;
			virous[0][1] = arrlist.get(i).j;
			dfs(arrlist,virous,i,1);
		}
		
		if(min==Integer.MAX_VALUE)
			min = -1;
		System.out.println(min);
	}
	
	static void dfs(ArrayList<Pair> arrlist, int[][] virous, int idx, int cnt) {
		if(cnt == M) {
			solve(virous);
		}
		else {
			for(int i=idx+1; i<=arrlist.size()-(M-cnt); i++) {
				virous[cnt][0] = arrlist.get(i).i;
				virous[cnt][1] = arrlist.get(i).j;
				dfs(arrlist,virous, i, cnt+1);
			}
		}
	}
	
	static void solve(int[][] virous) {
		int[][] visited = new int[N][N];
		Queue<Pair> que = new LinkedList<>();
		for(int i=0; i<M; i++) {
			que.add(new Pair(virous[i][0],virous[i][1]));
			visited[virous[i][0]][virous[i][1]] = 1;
		}
		
		int count = 0;
		int[][] move = {{-1,0},{0,-1},{0,1},{1,0}};
		while(!que.isEmpty()) {
			Pair p = que.poll();
			for(int k=0; k<4; k++) {
				int next_i = p.i + move[k][0];
				int next_j = p.j + move[k][1];
				if(next_i<0 || next_j<0 || next_i>=N || next_j>=N)
					continue;
				
				if(visited[next_i][next_j] == 0) {
					if(map[next_i][next_j] == 0) {
						count++;
						visited[next_i][next_j] = visited[p.i][p.j]+1;
						que.add(new Pair(next_i,next_j));
					}
					else if(map[next_i][next_j] == 2) {
						visited[next_i][next_j] = visited[p.i][p.j]+1;
						que.add(new Pair(next_i,next_j));
					}
				}
			}
		}
		if(count == cnt) {
//			printmap(visited);
			int tmp = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(tmp < visited[i][j] && map[i][j]==0)
						tmp = visited[i][j];
				}
			}
			tmp--;
			if(min > tmp)
				min = tmp;
		}
	}
}
