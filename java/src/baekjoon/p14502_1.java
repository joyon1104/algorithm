package baekjoon;
import java.util.*;

public class p14502_1 {
	static int max;
	static int[][] moved = {{0,1},{1,0},{0,-1},{-1,0}};
	static class Pair{
		int i;
		int j;
		public Pair(int i,int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	public static void solve(int[][] map, ArrayList<Pair> reslist) {
		int[][] tmp = new int[map.length][map[0].length];
		for(int i=0; i<tmp.length; i++) {
			for(int j=0; j<tmp[0].length; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		
		for(Pair p : reslist) {
			tmp[p.i][p.j] = 1;
		}
		for(int i=0; i<tmp.length; i++) {
			for(int j=0; j<tmp[0].length; j++) {
				if(tmp[i][j] == 2) {
					Queue<Pair> que = new LinkedList<>();
					que.offer(new Pair(i,j));
					while(!que.isEmpty()) {
						Pair p = que.poll();
						tmp[p.i][p.j] = 3;
						for(int k=0; k<4; k++) {
							int next_i = p.i + moved[k][0];
							int next_j = p.j + moved[k][1];
							if(next_i>=0 && next_j>=0 && next_i<tmp.length && next_j<tmp[0].length) {
								if(tmp[next_i][next_j] == 0 || tmp[next_i][next_j] == 2)
									que.offer(new Pair(next_i,next_j));
							}
							
						}
						
					}
				}
			}
		}
		int sum = 0;
		for(int i=0; i<tmp.length; i++) {
			for(int j=0; j<tmp[0].length; j++) {
				if(tmp[i][j] == 0)
					sum++;
			}
		}
		if(sum > max) {
			max = sum;
		}
	}
	
	public static void dfs(int[][] map, ArrayList<Pair> arrlist, ArrayList<Pair> reslist, int idx, int cnt) {
		if(cnt == 3) {
			solve(map,reslist);
		}
		else {
			for(int i=idx; i<=arrlist.size()-(3-cnt); i++) {
				reslist.add(arrlist.get(i));
				dfs(map,arrlist,reslist,i+1,cnt+1);
				reslist.remove(reslist.size()-1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		max = 0;
		int[][] map = new int[N][M];
		ArrayList<Pair> arrlist = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 0)
					arrlist.add(new Pair(i,j));
			}
		}
		ArrayList<Pair> reslist = new ArrayList<>();
		dfs(map,arrlist,reslist,0,0);
		System.out.println(max);
	}
}
