package baekjoon;
import java.util.*;

public class p17142 {

	static int N,M,min,cnt;
	static int[][] map;
	static int[][] visited;
	
	static class Pair{
		int i;
		int j;
		int t;
		
		public Pair(int i, int j, int t) {
			this.i = i;
			this.j = j;
			this.t = t;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		min = Integer.MAX_VALUE;
		map = new int[N][N];
		visited = new int[N][N];
		ArrayList<Pair> arrlist = new ArrayList<>();
		
		cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==0)
					cnt++;
				else if(map[i][j]==2) {
					arrlist.add(new Pair(i,j,0));
				}
				else {
					visited[i][j] = -1;
				}
			}
		}
		int[] virous = new int[M];
		dfs(arrlist,virous,0,0);
		
		if(min==Integer.MAX_VALUE)
			min = -1;
		System.out.println(min);
	}
	
	static void dfs(ArrayList<Pair>arrlist, int[] virous, int idx, int cnt ) {
		if(cnt==M) {
			bfs(arrlist,virous);
		}
		else {
			for(int i=idx; i<=arrlist.size()-(M-cnt); i++) {
				virous[cnt] = i;
				dfs(arrlist,virous,i+1,cnt+1);
			}
		}
	}
	
	static void bfs(ArrayList<Pair> arrlist, int[] virous) {
		int[][] tmp = copy(visited);
		int[][] moved = {{0,1},{1,0},{0,-1},{-1,0}};
		Queue<Pair> que = new LinkedList<Pair>();
		
		for(int i=0; i<virous.length; i++) {
			Pair p = arrlist.get(virous[i]);
			tmp[p.i][p.j] = -2;
			que.offer(p);
		}
		int maxtime = 0;
		int sum = 0;
		while(!que.isEmpty()) {
			Pair p = que.poll();
			if(tmp[p.i][p.j]>=0 && tmp[p.i][p.j] != p.t)	// 갱신 이전 값이면 생략
				continue;
			
			for(int k=0; k<4; k++) {
				int next_i = p.i + moved[k][0];
				int next_j = p.j + moved[k][1];
				if(next_i<0 || next_j<0 || next_i>=N || next_j>=N)
					continue;
				if(tmp[next_i][next_j] == 0) {
					if(map[next_i][next_j] == 0)	// 비활성 바이러스가 있었으면 count하지 않는다.
						sum++;
					tmp[next_i][next_j] = p.t+1;
					que.offer(new Pair(next_i,next_j,p.t+1));
				}
				else if(tmp[next_i][next_j] > 0) {
					if(tmp[next_i][next_j] > p.t+1) {	// 기존 time값 보다 최소 값일 경우 갱신
						tmp[next_i][next_j] = p.t+1;
						que.offer(new Pair(next_i,next_j,p.t+1));
					}
					else continue;
				}
				if(tmp[next_i][next_j]>0 && map[next_i][next_j] == 0 && maxtime < tmp[next_i][next_j])	// 바이러스가 감염된 시간 중 최대값 -> 모든 바이러스가 감염된 시간
					maxtime = tmp[next_i][next_j];
			}
			if(cnt == sum && min > maxtime) {	//모든 바이러스가 감염된 시간 중 최소값 찾기
				min = maxtime;
				break;
			}
		}
		//printmap(tmp);
		
	}
	
	static int[][] copy(int[][]map){
		int[][] tmp = new int[map.length][map[0].length];
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++)
				tmp[i][j] = map[i][j];
		}
		return tmp;
	}
	
	static void printmap(int[][]map){
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++)
				System.out.print(map[i][j]+" ");
			System.out.println();
		}
		System.out.println("-------------");
	}
}
