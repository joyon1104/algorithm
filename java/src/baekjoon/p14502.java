package baekjoon;
import java.util.*;
/*
 * [연구소]
 * 
 */
public class p14502 {
	static int N,M;
	static int[][] map;
	static ArrayList<Pair> arrlist;
	static int max = 0;
	static int[][] moved = {{1,0},{0,1},{-1,0},{0,-1}};
	
	static public class Pair{
		int i;
		int j;
		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	public static int solve(int[][] map) {
		int sum = 0;
		for(int i=0; i<map.length; i++) {
			for(int j = 0; j<map[0].length; j++) {
				if(map[i][j] == 2) {
					Queue<Pair> que = new LinkedList<>();
					map[i][j] = 3;
					que.offer(new Pair(i,j));
					while(!que.isEmpty()) {
						Pair tmp = que.poll();
						for(int p=0; p<4; p++) {
							int next_i = tmp.i + moved[p][0];
							int next_j = tmp.j + moved[p][1];
							if(next_i<0 || next_j<0 || next_i >=map.length || next_j >=map[0].length)
								continue;
							if(map[next_i][next_j] == 0 || map[next_i][next_j] == 2) {
								map[next_i][next_j] = 3;
								que.offer(new Pair(next_i,next_j));
							}
						}
					}
				}
			}
		}
		for(int i=0; i<map.length; i++) {
			for(int j = 0; j<map[0].length; j++) {
				if(map[i][j] == 0)
					sum++;
			}
		}
		return sum;
	}
	
	public static void dfs(Pair[] result, int idx, int cnt) {
		if(cnt == result.length) {
			// 새로운 객체를 만들어 map을 복사한다 -> 원본 데이터 유지를 위해
			int[][] tmpmap = new int[map.length][map[0].length];
			for(int i=0; i<map.length; i++) {
				for(int j = 0; j<map[0].length; j++) 
					tmpmap[i][j] = map[i][j];
			}
			for(int i=0; i<result.length; i++) 
				tmpmap[result[i].i][result[i].j] = 1;
			
			int tmp = solve(tmpmap);
			if(tmp > max)
				max = tmp;
		}
		else {
			for(int i=idx+1; i<arrlist.size(); i++) {
				result[cnt] = arrlist.get(i);
				dfs(result,i,cnt+1);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		arrlist = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 0)
					arrlist.add(new Pair(i,j));
			}
		}

		Pair[] result = new Pair[3];
		for(int i=0; i<arrlist.size()-2; i++) {
			result[0] = arrlist.get(i);
			dfs(result,i,1);
		}
		System.out.println(max);
	}
}
