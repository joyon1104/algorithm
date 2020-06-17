package SWEA;
import java.util.*;

public class p2105_1 {
	static int max;
	static int[][] moved = {{1,1},{1,-1},{-1,-1},{-1,1}};
	
	static class Pair{
		int i;
		int j;
		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	public static boolean check(int[][] map, ArrayList<Pair> arrlist, int next_i, int next_j) {
		boolean result = true;
		if(arrlist.get(0).i == next_i && arrlist.get(0).j == next_j)
			return true;
		else {
			for(Pair p : arrlist) {
				if(map[p.i][p.j] == map[next_i][next_j]) {
					result = false;
					break;
				}
			}
		}
		return result;
	}
	
	public static void solve(int[][]map, ArrayList<Pair> arrlist, Pair p, int d, int sum) {
		if(arrlist.get(0).i == p.i && arrlist.get(0).j == p.j ) {
			sum -= 1;
			if(sum > max) {
				max = sum;
				/*
				for(Pair pp : arrlist) {
					System.out.print(pp.i+"/"+pp.j+"("+map[pp.i][pp.j]+")"+"->");
				}System.out.println();
				*/
			}
		}
		else {
			int next_d = d;
			for(int k=0; k<2; k++) {
				int next_i = p.i + moved[next_d][0];
				int next_j = p.j + moved[next_d][1];
				if(next_i>=arrlist.get(0).i && next_j>=0 && next_i<map.length&& next_j<map.length && check(map,arrlist,next_i,next_j)) {
					Pair next_p = new Pair(next_i,next_j);
					arrlist.add(next_p);
					solve(map,arrlist,next_p,next_d,sum+1);
					arrlist.remove(arrlist.size()-1);
				}
				if(d==0)
					next_d = 1;
				else if(d==1)
					next_d = 2;
				else if(d==2)
					next_d = 3;
				else if(d==3)
					next_d = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			max = -1;
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++)
					map[i][j] = sc.nextInt();
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++){
					int sum = 1;
					ArrayList<Pair> arrlist = new ArrayList<>();
					arrlist.add(new Pair(i,j));
					int next_i = i+1;
					int next_j = j+1;
					if(next_i>=0 && next_j>=0 && next_i<N && next_j<N && map[i][j] != map[next_i][next_j]) {
						Pair p = new Pair(next_i,next_j);
						arrlist.add(p);
						solve(map,arrlist,p,0,sum+1);
					}
				}
			}
			
			System.out.println("#"+t+" "+max);
		}
	}

}
