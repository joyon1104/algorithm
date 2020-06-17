package SWEA;
import java.util.*;

public class p5653_1 {
	static int result;
	
	static class Germ{
		int i;
		int j;
		int status;
		int life;
		int now;
		
		public Germ(int i, int j, int now, int life, int status) {
			this.i = i;
			this.j = j;
			this.now = now;
			this.life = life;
			this.status = status;
		}
	}
	
	static void printmap(Germ[][] map) {
		for(int i=180; i<220; i++) {
			for(int j=180; j<220; j++) {
				if(map[i][j]== null)
					System.out.print(0+" ");
				else
					System.out.print(map[i][j].status +" ");
			}
			System.out.println();
		}
	}
	
	public static int[][] copyArr(int[][] map){
		int[][] arr = new int[map.length][map[0].length];
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++)
				arr[i][j] = map[i][j];
		}
		return arr;
	}
	
	public static void solve(int[][] map, Queue<Germ> que, int K) {
		int time = 0;
		int[][] moved = {{0,1},{1,0},{0,-1},{-1,0}};
		int[][] tmpmap;
		while(time<K) {
			Queue<Germ> tque = new LinkedList<>();
			tmpmap = copyArr(map);
			while(!que.isEmpty()) {
				Germ g = que.poll();
				g.now--;
				if(g.status==0) {
					if(g.now > 0)
						tque.offer(new Germ(g.i,g.j,g.now,g.life,g.status));
					else {
						g.now = tmpmap[g.i][g.j];
						g.status = 1;
						tque.offer(new Germ(g.i,g.j,g.now,g.life,g.status));
					}
				}
				else if(g.status==1) {
					if(g.now == tmpmap[g.i][g.j]-1) {
						for(int p=0; p<4; p++) {
							int next_i = g.i+moved[p][0];
							int next_j = g.j+moved[p][1];
							if(map[next_i][next_j] == 0 && tmpmap[next_i][next_j]==0) {
								map[next_i][next_j] = tmpmap[g.i][g.j];
								tque.offer(new Germ(next_i,next_j,tmpmap[g.i][g.j],tmpmap[g.i][g.j],0));
							}
							else if(map[next_i][next_j] != 0 && tmpmap[next_i][next_j]==0) {
								if(map[next_i][next_j] < tmpmap[g.i][g.j]) {
									map[next_i][next_j] = tmpmap[g.i][g.j];
									tque.offer(new Germ(next_i,next_j,tmpmap[g.i][g.j],tmpmap[g.i][g.j],0));
								}
							}
						}
					}
					if(g.now>0)
						tque.offer(new Germ(g.i,g.j,g.now,g.life,g.status));
				}
			}//while
			
			for(Germ g : tque) {
				if(map[g.i][g.j] != g.life) continue;
				que.offer(g);
			}
			time++;
		}//√÷¡æwhile
		
		result = que.size();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			result = 0;
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			int[][] map = new int[500][500];
			Queue<Germ> que = new LinkedList<>();
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					int life = sc.nextInt();
					if(life > 0) {
						map[i+200][j+200] = life;
						que.offer(new Germ(i+200,j+200,life,life,0));
					}
				}
			}
			solve(map,que,K);
			System.out.println("#"+t+" "+result);
		}
	}
}
