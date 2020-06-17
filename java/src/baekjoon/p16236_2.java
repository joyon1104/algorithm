package baekjoon;
import java.util.*;

public class p16236_2 {

	static class Pair implements Comparable<Pair>{
		int i;
		int j;
		int d;
		public Pair(int i, int j, int d) {
			this.i = i;
			this.j = j;
			this.d = d;
		}
		
		public int compareTo(Pair target) {
			if(this.d < target.d)
				return -1;
			else if(this.d > target.d)
				return 1;
			else {
				if(this.i < target.i)
					return -1;
				else if(this.i > target.i)
					return 1;
				else {
					if(this.j < target.j)
						return -1;
					else if(this.j > target.j)
						return 1;
					else return 0;
				}
			}
		}
	}
	
	static int N;
	static int[] shark;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[][] map = new int[N][N];
		shark = new int[4];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==9) {
					shark[0] = i; shark[1] = j;
					shark[2] = 2; shark[3] = 0;
				}
			}
		}
		
		int time = 0;
		int[][] move = {{-1,0},{0,-1},{0,1},{1,0}};
		PriorityQueue<Pair> que = new PriorityQueue<>();
		que.offer(new Pair(shark[0],shark[1],0));
		int[][] visited = new int[N][N];
		visited[shark[0]][shark[1]] = 1;
		while(!que.isEmpty()) {
			Pair p = que.poll();
			if(map[p.i][p.j]>0 && map[p.i][p.j]<9 && map[p.i][p.j] < shark[2]) { //que에서 뺄 때 판단하는 것이 중요하다! -> 넣을 때 판단하면 최적의 거리의 물고기가 아닐 수 있음
				map[shark[0]][shark[1]] = 0;
				map[p.i][p.j] = 9;
				shark[0] = p.i;
				shark[1] = p.j;
				shark[3] += 1;
				if(shark[3] == shark[2]) {
					shark[2] += 1;
					shark[3] = 0;
				}
				time += p.d;
				que.clear();
				que.offer(new Pair(shark[0],shark[1],0));
				visited = new int[N][N];
				visited[shark[0]][shark[1]] = 1;
				continue;
			}
			for(int k=0; k<4; k++) {
				int next_i = p.i + move[k][0];
				int next_j = p.j + move[k][1];
				if(next_i<0 || next_j<0 || next_i>=N || next_j>=N || visited[next_i][next_j]>0)
					continue;
				if(map[next_i][next_j] > shark[2])
					continue;
				else {
					que.offer(new Pair(next_i,next_j,p.d+1));
					visited[next_i][next_j] = 1;
				}
			}
		}
		
		System.out.println(time);
		
	}
}
