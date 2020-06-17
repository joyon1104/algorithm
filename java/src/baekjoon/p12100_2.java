package baekjoon;
import java.util.*;

/*
 * [2048 Easy]
 * - ¼º°ø!!
 */

public class p12100_2 {

	static int N;
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		max = 0;
		int[][] board = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++)
				board[i][j] = sc.nextInt();
		}
		
		int[] turn = new int[5];
		for(int i=0; i<4; i++) {
			turn[0]=i;
			dfs(board, turn, 0, 1);
		}
		System.out.println(max);
	}
	
	static int[][] copy(int[][]board){
		int[][] tmp = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++)
				tmp[i][j] = board[i][j];
		}
		return tmp;
	}
	
	static void dfs(int[][]board, int[] turn, int idx, int cnt) {
		if(cnt==5) {
			solve(board, turn);
		}
		else {
			for(int i=0; i<4; i++) {
				turn[idx+1] = i;
				dfs(board, turn, idx+1, cnt+1);
			}
		}
	}
	
	static void solve(int[][]board, int[] turn) {
		int[][] base = copy(board);
		for(int k=0; k<5; k++) {
			int[][] tmp = new int[N][N];
			int d = turn[k];
			Deque<Integer> deque;
			if(d==0) {
				for(int j=0; j<N; j++) {
					 deque = new LinkedList<>();
					 for(int i=0; i<N; i++) {
						 if(base[i][j]==0)
							 continue;
						 if(deque.isEmpty()) {
							 deque.addLast(base[i][j]);
							 continue;
						 }
						 if(deque.peekLast()==base[i][j]) {
							 deque.addLast(deque.pollLast()*2);
							 deque.addLast(-1);
						 }
						 else deque.addLast(base[i][j]);
					 }
					 int idx = 0;
					 while(!deque.isEmpty()) {
						 if(deque.peekFirst()==-1) {
							 deque.poll();
							 continue;
						 }
						 if(deque.peekFirst() > max)
							 max = deque.peekFirst();
						 tmp[idx++][j] = deque.pollFirst();
					 }
				}
			}
			else if(d==1) {
				for(int j=0; j<N; j++) {
					 deque = new LinkedList<>();
					 for(int i=N-1; i>=0; i--) {
						 if(base[i][j]==0)
							 continue;
						 if(deque.isEmpty()) {
							 deque.addLast(base[i][j]);
							 continue;
						 }
						 if(deque.peekLast()==base[i][j]) {
							 deque.addLast(deque.pollLast()*2);
							 deque.addLast(-1);
						 }
						 else deque.addLast(base[i][j]);
					 }
					 int idx = N-1;
					 while(!deque.isEmpty()) {
						 if(deque.peekFirst()==-1) {
							 deque.poll();
							 continue;
						 }
						 if(deque.peekFirst() > max)
							 max = deque.peekFirst();
						 tmp[idx--][j] = deque.pollFirst();
					 }
				}
			}
			else if(d==2) {
				for(int i=0; i<N; i++) {
					 deque = new LinkedList<>();
					 for(int j=0; j<N; j++) {
						 if(base[i][j]==0)
							 continue;
						 if(deque.isEmpty()) {
							 deque.addLast(base[i][j]);
							 continue;
						 }
						 if(deque.peekLast()==base[i][j]) {
							 deque.addLast(deque.pollLast()*2);
							 deque.addLast(-1);
						 }
						 else deque.addLast(base[i][j]);
					 }
					 int idx = 0;
					 while(!deque.isEmpty()) {
						 if(deque.peekFirst()==-1) {
							 deque.poll();
							 continue;
						 }
						 if(deque.peekFirst() > max)
							 max = deque.peekFirst();
						 tmp[i][idx++] = deque.pollFirst();
					 }
				}
			}
			else if(d==3) {
				for(int i=0; i<N; i++) {
					 deque = new LinkedList<>();
					 for(int j=N-1; j>=0; j--) {
						 if(base[i][j]==0)
							 continue;
						 if(deque.isEmpty()) {
							 deque.addLast(base[i][j]);
							 continue;
						 }
						 if(deque.peekLast()==base[i][j]) {
							 deque.addLast(deque.pollLast()*2);
							 deque.addLast(-1);
						 }
						 else deque.addLast(base[i][j]);
					 }
					 int idx = N-1;
					 while(!deque.isEmpty()) {
						 if(deque.peekFirst()==-1) {
							 deque.poll();
							 continue;
						 }
						 if(deque.peekFirst() > max)
							 max = deque.peekFirst();
						 tmp[i][idx--] = deque.pollFirst();
					 }
				}
			}
			base = tmp;
		}

	}
}
