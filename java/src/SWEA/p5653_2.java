package SWEA;
import java.util.*;

/*
 * [줄기세포배양]
 * - 성공
 */

public class p5653_2 {

	static class Cell{
		int i;
		int j;
		int x;
		int state;
		int life;
		
		public Cell(int i, int j, int x, int state, int life) {
			this.i = i;
			this.j = j;
			this.x = x;
			this.state = state;
			this.life = life;
		}
	}
	
	static int N,M,K;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int result = 0;
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			int[][] map = new int[1000][1000];
			int[][] visited = new int[1000][1000];
			Queue<Cell> que = new LinkedList<>();
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					map[i+500][j+500] = sc.nextInt();
					if(map[i+500][j+500] != 0) {
						que.offer(new Cell(i+500, j+500, map[i+500][j+500],0, map[i+500][j+500]));
						visited[i+500][j+500] = map[i+500][j+500]; // 방문여부 배열에는 해당 세포의 생명력을 표시
					}
				}
			}
			int time = 0;
			int[][] move = {{0,1},{1,0},{-1,0},{0,-1}};
			while(time<K) {
				Queue<Cell> tmp = new LinkedList<>();
				while(!que.isEmpty()) {
					Cell c = que.poll();
					if(c.state == 0 && visited[c.i][c.j] != c.x) { // 큐에 있는 세포와 visited배열의 생명력이 다른 경우 -> 큐의 세포를 갱신
						c.x = visited[c.i][c.j];
						c.life = visited[c.i][c.j];
					}
					if(c.state == 1 && c.life == c.x) {
						for(int k=0; k<4; k++) {
							int next_i = c.i + move[k][0];
							int next_j = c.j + move[k][1];
							if(visited[next_i][next_j]==0) {
								tmp.offer(new Cell(next_i, next_j, c.x, 0, c.x));
							}
						}
					}
					
					c.life--;
					if(c.life == 0) {
						if(c.state==0) { // 비활성 -> 활성
							tmp.offer(new Cell(c.i, c.j, c.x, 1, c.x));
						}
						/*
						else if(c.state==1) {  //활성 -> 죽음
							tmp.offer(new Cell(c.i, c.j, c.x, 2, c.x));
						}
						*/
					}
					else {
						tmp.offer(c);
					}
				}
				
				// visited를 처음에 바로 갱신하면 이전에 있었던 세포와 방금 번식한 세포 구분이 어렵기 때문에 임시큐에서 메인큐로 옮길 때 갱신해주었다!
				while(!tmp.isEmpty()) {
					Cell c = tmp.poll();
					if(c.state==0 && c.x == c.life) {
						if(visited[c.i][c.j] == 0) {
							que.offer(c);
							visited[c.i][c.j] = c.x;
						}
						else {
							if(visited[c.i][c.j] < c.x) {  // 이미 큐에 해당 위치의 세포가 들어갔으므로 visited만 갱신 -> 나중에 큐에서 뺄 때 visited 정보를 바탕으로 갱신해준다!
								visited[c.i][c.j] = c.x;
							}
						}
					}
					else {
						que.offer(c);
					}
				}
				
				time++;
			}
			
			result = que.size();
			System.out.println("#"+t+" "+result);
		}
	}
}
