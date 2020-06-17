package baekjoon;
import java.util.*;

public class p15683 {
	
	static int min;
	static int[][] moved= {{-1,0},{0,1},{1,0},{0,-1}};
	
	static class Pair{
		int i;
		int j;
		int n;
		
		public Pair(int n, int i, int j) {
			this.n = n;
			this.i = i;
			this.j = j;
		}
	}
	
	public static int[][] rebuild(int[][] map,int x, int y, ArrayList<Integer> d){
		int[][] tmp = new int[map.length][map[0].length];
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		
		for(int j=0; j<d.size(); j++) {
			int xx = x;
			int yy = y;
			while(xx>=0 && yy>=0 && xx<map.length && yy<map[0].length) {
				if(tmp[xx][yy]==0) {
					tmp[xx][yy] = -1;
				}
				else if(tmp[xx][yy] == 6)
					break;
				xx+= moved[d.get(j)][0];
				yy+= moved[d.get(j)][1];
			}
		}
		
		return tmp;
	}
	
	public static void solve(int[][] map, ArrayList<Pair> arrlist, int[] turn) {
		int[][] tmp = new int[map.length][map[0].length];
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		
		for(int i=0; i<arrlist.size(); i++) {
			Pair p = arrlist.get(i);
			ArrayList<Integer> d = new ArrayList<>();
			if(p.n == 1) {
				d.add(turn[i]);
				tmp = rebuild(tmp,p.i,p.j,d);
			}
			else if(p.n == 2) {
				if(turn[i]==0) {
					d.add(0); d.add(2);
				}
				else {
					d.add(1); d.add(3);
				}
			}
			else if(p.n == 3) {
				if(turn[i]==0) {
					d.add(0); d.add(1);
				}
				else if(turn[i]==1) {
					d.add(1); d.add(2);
				}
				else if(turn[i]==2) {
					d.add(2); d.add(3);
				}
				else if(turn[i]==3) {
					d.add(3); d.add(0);
				}
			}
			else if(p.n == 4) {
				if(turn[i]==0) {
					d.add(0); d.add(1); d.add(2);
				}
				else if(turn[i]==1) {
					d.add(0); d.add(1); d.add(3);
				}
				else if(turn[i]==2) {
					d.add(0); d.add(2); d.add(3);
				}
				else if(turn[i]==3) {
					d.add(1); d.add(2); d.add(3);
				}
			}
			else if(p.n == 5) {
				d.add(0); d.add(1); d.add(2); d.add(3);
			}
			tmp = rebuild(tmp,p.i,p.j,d);
		}
		
		int cnt = 0;
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				if(tmp[i][j] == 0)
					cnt++;
			}
		}
		if(min > cnt) {
			min = cnt;
		}
	}

	
	public static void dfs(int[][] map, ArrayList<Pair> arrlist, int[] turn, int idx) {
		if(idx == turn.length) {
			solve(map,arrlist,turn);
		}
		else {
			int num = arrlist.get(idx).n;
			if(num==1 || num==3 || num==4) {
				for(int i=0; i<4; i++) {
					turn[idx] = i;
					dfs(map,arrlist,turn,idx+1);
				}
			}
			else if(num==2) {
				for(int i=0; i<2; i++) {
					turn[idx] = i;
					dfs(map,arrlist,turn,idx+1);
				}
			}
			else if(num==5) {
				turn[idx] = 0;
				dfs(map,arrlist,turn,idx+1);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		min = 65;
		int[][] map = new int[N][M];
		ArrayList<Pair> arrlist = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]>=1 && map[i][j]<=5)
					arrlist.add(new Pair(map[i][j],i,j));
			}
		}
		
		int[] turn = new int[arrlist.size()];
		dfs(map,arrlist,turn,0);
		
		System.out.println(min);
	}
}
