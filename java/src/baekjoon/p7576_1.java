package baekjoon;
import java.util.*;

public class p7576_1 {
	static int N;
	static int M;
	static int[][] map;
	static int[][] visited;
	static int[][] moved = {{1,0},{0,1},{-1,0},{0,-1}};
	static int res;
	static int day;
	static int total;
	
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
		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[N+1][M+1];
		res = 0;
		total = 0;
		day = 0;
		
		Queue<Pair> que = new LinkedList<Pair>();		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1 || map[i][j] == 0)
					total++;
				if(map[i][j] == 1) {
					Pair p = new Pair(i,j);
					que.offer(p);
				}
			}
		}

		Queue<Pair> tmp = new LinkedList<Pair>();
		while(!(que.isEmpty())) {
			Pair temp = que.poll();
			res++;
			for(int k=0; k<4; k++) {
				int next_x = temp.x + moved[k][0];
				int next_y = temp.y + moved[k][1];
				
				if(next_x >=1 && next_y>=1 && next_x<=N && next_y<=M) {
					if(map[next_x][next_y] == 0) {
						map[next_x][next_y] = 1;
						tmp.offer(new Pair(next_x,next_y));
					}
				}
			}
			if(que.isEmpty()) {
				if(tmp.isEmpty())
					break;
				day++;
				while(!(tmp.isEmpty()))
					que.offer(tmp.poll());
			}
		}	

		if(res == total) 
			System.out.println(day);
		else
			System.out.println(-1);
	}	
}

