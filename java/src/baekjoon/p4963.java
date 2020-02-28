package baekjoon;
import java.util.*;

public class p4963 {
	static int N;
	static int M;
	static int res;
	
	static int[][] map;
	static int[][] visited;
	static int[][] moved = {{0,1},{1,0},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
	
	static class Pair{
		int x;
		int y;
		
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			M = sc.nextInt();
			N = sc.nextInt();
			res = 0;
			
			if(N==0 && N==0)
				break;
			
			map = new int[N+1][M+1];
			visited= new int[N+1][M+1];
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					if(visited[i][j] == 0 && map[i][j] == 1) {
						res++;
						Queue<Pair> que = new LinkedList<Pair>();
						Pair p = new Pair(i,j);
						que.offer(p);
						visited[i][j] = 1;
						
						while(!(que.isEmpty())) {
							Pair temp = que.poll();
							for(int k=0; k<8; k++) {
								int next_x = temp.x + moved[k][0];
								int next_y = temp.y + moved[k][1];
								
								if(next_x>=1 && next_y>=1 && next_x<=N && next_y<=M) {
									if(visited[next_x][next_y] == 0 && map[next_x][next_y] == 1) {
										visited[next_x][next_y] = 1;
										Pair nextp = new Pair(next_x,next_y);
										que.offer(nextp);
									}
								}
							}
						}
					}
				}
			}
//			//visited 결과출력
//			for(int i=1; i<=N; i++) {
//				for(int j=1; j<=M; j++) {
//					System.out.print(visited[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("==========");
			
			System.out.println(res);
		}
	}
}
