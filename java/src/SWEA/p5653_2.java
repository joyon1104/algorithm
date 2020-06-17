package SWEA;
import java.util.*;

/*
 * [�ٱ⼼�����]
 * - ����
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
						visited[i+500][j+500] = map[i+500][j+500]; // �湮���� �迭���� �ش� ������ ������� ǥ��
					}
				}
			}
			int time = 0;
			int[][] move = {{0,1},{1,0},{-1,0},{0,-1}};
			while(time<K) {
				Queue<Cell> tmp = new LinkedList<>();
				while(!que.isEmpty()) {
					Cell c = que.poll();
					if(c.state == 0 && visited[c.i][c.j] != c.x) { // ť�� �ִ� ������ visited�迭�� ������� �ٸ� ��� -> ť�� ������ ����
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
						if(c.state==0) { // ��Ȱ�� -> Ȱ��
							tmp.offer(new Cell(c.i, c.j, c.x, 1, c.x));
						}
						/*
						else if(c.state==1) {  //Ȱ�� -> ����
							tmp.offer(new Cell(c.i, c.j, c.x, 2, c.x));
						}
						*/
					}
					else {
						tmp.offer(c);
					}
				}
				
				// visited�� ó���� �ٷ� �����ϸ� ������ �־��� ������ ��� ������ ���� ������ ��Ʊ� ������ �ӽ�ť���� ����ť�� �ű� �� �������־���!
				while(!tmp.isEmpty()) {
					Cell c = tmp.poll();
					if(c.state==0 && c.x == c.life) {
						if(visited[c.i][c.j] == 0) {
							que.offer(c);
							visited[c.i][c.j] = c.x;
						}
						else {
							if(visited[c.i][c.j] < c.x) {  // �̹� ť�� �ش� ��ġ�� ������ �����Ƿ� visited�� ���� -> ���߿� ť���� �� �� visited ������ �������� �������ش�!
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
