package baekjoon;
import java.util.*;

/*
 * [원판 돌리기]
 * -인덱스 실수하지말자!
 * -0부터 시작하든 1부터 시작하든 하나만 할것 -> 아님 헷갈려ㅠㅠ
 */

public class p17822_1 {

	static class Pair{
		int i;
		int j;
		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	static int[][] copymap(int[][] map){
		int[][] tmp = new int[N+1][M];
		for(int i=0; i<=N; i++) {
			for(int j=0; j<M; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		return tmp;
	}
	
	static void printmap(int[][] map){
		for(int i=0; i<=N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static int N, M, T;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		T = sc.nextInt();
		int[][] board = new int[N+1][M];
		for(int i=1; i<=N; i++) {
			for(int j=0; j<M; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		for(int t=0; t<T; t++) {
			int x = sc.nextInt();
			int d = sc.nextInt();
			int k = sc.nextInt();
			board = solve(board, x, d, k);
		}
		
		int result = 0;
		for(int i=1; i<=N; i++) {
			for(int j=0; j<M; j++) {
				result += board[i][j];
			}
		}
		System.out.println(result);
	}
	
	static int[][] solve(int[][] board, int x, int d, int k) {
		int[][] tmp = copymap(board);
		for(int i=1; i<=N; i++) {
			if(i%x==0) {
				if(d==0) {
					for(int j=0; j<M; j++) {
						int idx = (j+k)%M;
						tmp[i][idx] = board[i][j];
					}
				}
				else {
					for(int j=0; j<M; j++) {
						int idx = ((j-k)+M)%M;
						tmp[i][idx] = board[i][j];
					}
				}
			}
		}
		boolean check = false;
		int sum = 0;
		int cnt = 0;
		int[][] visited = new int[N+1][M];
		for(int i=1; i<=N; i++) {
			for(int j=0; j<M; j++) {
				if(tmp[i][j] != 0 && visited[i][j] == 0) {
					sum += tmp[i][j];
					cnt += 1;
					Queue<Pair> que1 = new LinkedList<>();
					Queue<Pair> que2 = new LinkedList<>();
					que1.offer(new Pair(i,j));
					while(!que1.isEmpty()) {
						Pair p = que1.poll();
						que2.offer(p);
						ArrayList<Pair> arrlist = new ArrayList<>();
						if(p.j==0) {
							arrlist.add(new Pair(p.i, p.j+1));
							arrlist.add(new Pair(p.i, M-1));
						}
						else if(p.j==M-1) {
							arrlist.add(new Pair(p.i, p.j-1));
							arrlist.add(new Pair(p.i, 0));
						}
						else {
							arrlist.add(new Pair(p.i, p.j-1));
							arrlist.add(new Pair(p.i, p.j+1));
						}
						
						if(p.i==1) {
							arrlist.add(new Pair(p.i+1, p.j));
						}
						else if(p.i==N) {
							arrlist.add(new Pair(p.i-1, p.j));
						}
						else {
							arrlist.add(new Pair(p.i-1, p.j));
							arrlist.add(new Pair(p.i+1, p.j));
						}
						
						for(Pair pp : arrlist) {
							if(visited[pp.i][pp.j]==0 && tmp[pp.i][pp.j]==tmp[p.i][p.j]) {
								visited[pp.i][pp.j] = 1;
								que1.offer(new Pair(pp.i,pp.j));
							}
						}
					}//while que1
					
					if(que2.size()>=2) {
						check = true;
						while(!que2.isEmpty()) {
							Pair p = que2.poll();
							sum -= tmp[p.i][p.j];
							tmp[p.i][p.j] = 0;
						}
					}
				}
			}
		}//for

		if(check == false) {
			float avg = ((float)sum)/cnt;
			for(int i=1; i<=N; i++) {
				for(int j=0; j<M; j++) {
					if(tmp[i][j]==0)
						continue;
					if(tmp[i][j]>avg)
						tmp[i][j] -= 1;
					else if(tmp[i][j]<avg)
						tmp[i][j] += 1;
				}
			}
		}
		return tmp;
	}
}
