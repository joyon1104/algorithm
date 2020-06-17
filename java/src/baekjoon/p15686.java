package baekjoon;
import java.util.*;

public class p15686 {
	
	static int min;
	
	static class Pair{
		int i;
		int j;
		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	public static void solve(int[][] map, Pair[] turn) {
		ArrayList<Pair> home = new ArrayList<>();
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length; j++) {
				if(map[i][j] == 1)
					home.add(new Pair(i,j));
			}
		}
		int[] result = new int[home.size()];
		int sum = 0;
		for(int i=0; i<home.size(); i++) {
			Pair p = home.get(i);
			for(int j=0; j<turn.length; j++) {
				int dist = Math.abs(p.i-turn[j].i) + Math.abs(p.j-turn[j].j);
				if(result[i]==0)
					result[i] = dist;
				else
					result[i] = Math.min(result[i], dist);
			}
			sum += result[i];
		}
		if(min > sum)
			min = sum;
		
	}
	
	public static void dfs(int[][] map, ArrayList<Pair> arrlist, Pair[] turn, int idx, int cnt) {
		if(cnt==turn.length) {
			solve(map,turn);
		}
		else {
			for(int i=idx+1; i<arrlist.size(); i++) {
				turn[cnt] = arrlist.get(i);
				dfs(map,arrlist,turn,i,cnt+1);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][N];
		min = Integer.MAX_VALUE;
		
		ArrayList<Pair> arrlist = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 2)
					arrlist.add(new Pair(i,j));
			}
		}
		
		Pair[] turn = new Pair[M];
		for(int i=0; i<=arrlist.size()-M; i++) {
			turn[0] = arrlist.get(i);
			dfs(map,arrlist,turn,i,1);
		}
		System.out.println(min);
	}
}
