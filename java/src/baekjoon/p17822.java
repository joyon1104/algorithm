package baekjoon;
import java.util.*;

/*
 * [원판 돌리기]
 * - 작년 하반기 기출
 * - 맞은줄 알았는데 배수 원판 돌린다는 점에서 잘못 한 것 같다
 */

public class p17822 {
	
	static class Pair{
		int i;
		int j;
		
		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static void printmap(int[][] board) {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++)
				System.out.print(board[i][j]+" ");
			System.out.println();
		}
		System.out.println("-------------------");
	}
	
	static int N,M;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int T = sc.nextInt();
		map = new int[N+1][M+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++)
				map[i][j] = sc.nextInt();
		}
		for(int t=1; t<=T; t++) {
			int x = sc.nextInt();
			int d = sc.nextInt();
			int k = sc.nextInt();
			map = solve(x,d,k);
		}
		
		int result=0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++){
				if(map[i][j] != 0)
					result += map[i][j];
			}
		}
		System.out.println(result);
	}
	
	static int[][] solve(int x, int d, int k){
		int[][] tmp = turn(x,d,k);
		
		int[][] move = {{0,1},{1,0},{0,-1},{-1,0}};
		int[][] visited = new int[N+1][M+1];
		boolean check = false;
		int total = 0;
		int cnt = 0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(tmp[i][j] == 0)
					continue;
				total += tmp[i][j];
				cnt += 1;
				Queue<Pair> que = new LinkedList<Pair>();
				que.add(new Pair(i,j));
				visited[i][j] = 1;
				for(int t=0; t<4; t++) {
					int next_i = i+move[t][0];
					int next_j = j+move[t][1];
					if(next_i<=0 || next_i>N)
						continue;
					if(next_j<=0)
						next_j = M;
					else if(next_j>M)
						next_j = 1;
					
					if(visited[next_i][next_j]==0 && tmp[i][j]==tmp[next_i][next_j]) {
						que.add(new Pair(next_i,next_j));
						visited[next_i][next_j] = 1;
					}
				}
				
				if(que.size()<=1)
					continue;
				
				check = true;
				tmp[que.peek().i][que.peek().j] = 0;
				que.poll(); //가장 첫번째 원소 날리기
				while(!que.isEmpty()) {
					Pair p = que.poll();
					for(int t=0; t<4; t++) {
						int next_i = p.i+move[t][0];
						int next_j = p.j+move[t][1];
						if(next_i<=0 || next_i>N)
							continue;
						if(next_j<=0)
							next_j = M;
						else if(next_j>M)
							next_j = 1;
						
						if(visited[next_i][next_j]==0 && tmp[p.i][p.j]==tmp[next_i][next_j]) {
							que.add(new Pair(next_i,next_j));
							visited[next_i][next_j] = 1;
						}
					}
					tmp[p.i][p.j] = 0;
				}
			}
		} //for문
		
		if(check==false) {
			float avg = (float)total/cnt;
			tmp = rebuild(tmp,avg);
		}
		return tmp;
	}
	
	static int[][] turn(int x, int d, int k){
		int[][] tmp = new int[N+1][M+1];
		for(int i=1; i<=N; i++) {
			if(i%x==0) {
				if(d==0) {
					for(int j=1; j<=M; j++) {
						if(j+k<=M)
							tmp[i][j+k]=map[i][j];
						else {
							if((j+k)%M==0)
								tmp[i][M] = map[i][j];
							else
								tmp[i][(j+k)%M] = map[i][j];
						}
					}
				}
				else {
					for(int j=1; j<=M; j++) {
						if(j-k>0)
							tmp[i][j-k]=map[i][j];
						else
							tmp[i][j-k+M] = map[i][j];
					}
				}
			}
			else {
				for(int j=1; j<=M; j++)
					tmp[i][j] = map[i][j];
			}
		}
		return tmp;
	}
	
	static int[][] rebuild(int[][] board, float avg){
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(board[i][j]==0)
					continue;
				if(avg < board[i][j])
					board[i][j]--;
				else if(avg > board[i][j])
					board[i][j]++;
			}
		}
		return board;
	}
}
