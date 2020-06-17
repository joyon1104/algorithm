package baekjoon;
import java.util.*;

public class p16234 {

	static class Pair{
		int i;
		int j;
		int cnt;
		public Pair(int i, int j, int cnt) {
			this.i = i;
			this.j = j; 
			this.cnt = cnt;
		}
	}
//	public static void print(int[][] cube) {
//		for(int i=0; i<cube.length; i++) {
//			for(int j=0; j<cube[0].length; j++)
//				System.out.print(cube[i][j]+" ");
//			System.out.println();
//		}
//	}
	
	public static int[][] copy(int[][] map){
		int[][] tmp = new int[map.length][map[0].length];
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++)
				tmp[i][j] = map[i][j];
		}
		return tmp;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		int R = sc.nextInt();
		int[][] map = new int[N][N];
		int[][] visited = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
				visited[i][j] = map[i][j];
			}
		}
		int[][] moved = {{0,1},{1,0},{-1,0},{0,-1}};
		int result = 0;
		while(true) {
			map = copy(visited);
			visited = new int[N][N];
			boolean check = true;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visited[i][j]==0) {
						int sum = 0;
						Queue<Pair> que = new LinkedList<>();
						que.offer(new Pair(i,j,map[i][j]));
						visited[i][j] = map[i][j];
						Queue<Pair> tmpque = new LinkedList<>();
						while(!que.isEmpty()) {
							Pair p = que.poll();
							tmpque.offer(p);
							sum += p.cnt;
							for(int k=0; k<4; k++) {
								int next_i = p.i+moved[k][0];
								int next_j = p.j+moved[k][1];
								if(next_i>=0 && next_j>=0 && next_i<N && next_j<N) {
									if(visited[next_i][next_j]==0 && Math.abs(map[p.i][p.j]-map[next_i][next_j])>=L && Math.abs(map[p.i][p.j]-map[next_i][next_j])<=R) {
										visited[next_i][next_j] = map[next_i][next_j];
										que.offer(new Pair(next_i,next_j,map[next_i][next_j]));
									}
								}
							}
						}
						if(tmpque.size()==1)
							continue;
						check = false;
						int aftercnt = sum/tmpque.size();
						while(!tmpque.isEmpty()) {
							Pair p = tmpque.poll();
							visited[p.i][p.j] = aftercnt;
						}
					}
				}
			}
			if(check == true)
				break;
			result++;
		}//while
		
		System.out.println(result);
	}
}
