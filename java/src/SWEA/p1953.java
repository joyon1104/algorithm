package SWEA;
import java.util.*;
/*
 * [Ż�ֹ� �˰�]
 * - �ִܰŸ��� bfs�� �� ��. -> dfs�� �ϸ� �ð��ʰ��� ���� ��Ȯ�� ���� ������ �����. ������θ� ���� ������ �̹� �湮�ع����� �ִܰŸ��� �ȵ� �� ����!
 */

public class p1953 {
	static int result;
	static int[][] moved = {{0,1},{1,0},{0,-1},{-1,0}};
	
	static class Pair{
		int i;
		int j;
		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	static boolean check(int start, int next,int d) {
		if(next == 0 )
			return false;
		else {
			if(d==0) {
				if((start==1||start==3||start==4||start==5) && (next==1||next==3||next==6||next==7))
					return true;
				else return false;
			}
			else if(d==1) {
				if((start==1||start==2||start==5||start==6) && (next==1||next==2||next==4||next==7))
					return true;
				else return false;
			}
			else if(d==2) {
				if((start==1||start==3||start==6||start==7) && (next==1||next==3||next==4||next==5))
					return true;
				else return false;
			}
			else {
				if((start==1||start==2||start==4||start==7) && (next==1||next==2||next==5||next==6))
					return true;
				else return false;
			}
		}
	}
	
	static void bfs(int[][] map, int[][] visited, Queue<Pair> que) {
		
		while(!que.isEmpty()) {
			Pair p = que.poll();
			if(visited[p.i][p.j] == 1)
				continue;
			for(int i=0; i<4; i++) {
				int next_i = p.i + moved[i][0];
				int next_j = p.j + moved[i][1];
				if(next_i>=0 && next_j>=0 && next_i<map.length && next_j<map[0].length) {
					if(visited[next_i][next_j] == 0 && check(map[p.i][p.j],map[next_i][next_j],i)) {
						visited[next_i][next_j] = visited[p.i][p.j]-1;
						que.offer(new Pair(next_i,next_j));
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int R = sc.nextInt();
			int C = sc.nextInt();
			int L = sc.nextInt();
			int[][] map = new int[N][M];
			int[][] visited = new int[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			result = 0;
			visited[R][C] = L;
			Queue<Pair> que = new LinkedList<Pair>();
			que.offer(new Pair(R,C));
			bfs(map,visited,que);
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(visited[i][j] >0)
						result++;
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}
	
}

