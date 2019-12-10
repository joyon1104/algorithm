package baekjoon;
import java.util.*;

public class p2583 {
	static int num = 0;
	static int[] result = new int[101];
	
	static class Pair{
		int i;
		int j;
		
		public Pair(int i, int j) {
			this.i = i; 
			this.j = j;
		}
	}
	
	static int[][] BFS(int[][] board, int[][] visited, Queue<Pair> que){
		int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
		int size = 0;
		
		while(!(que.isEmpty())) {
			Pair p = que.poll();
			size++;
			for(int i=0; i<4; i++) {
				int next_i = p.i + move[i][0];
				int next_j = p.j + move[i][1];
				
				if(next_i >=0 && next_j >=0 && next_i < board.length && next_j < board[0].length) {
					if(board[next_i][next_j] == 0 && visited[next_i][next_j] == 0) {
						visited[next_i][next_j] = 1;
						Pair tmp = new Pair(next_i, next_j);
						que.add(tmp);
					}
				}
			}
		}
		
		result[num] = size;
		num++;
		return visited;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] board = new int[M][N];
		
		for(int k=1; k<=K; k++) {
			int start_j = sc.nextInt();
			int start_i = sc.nextInt();
			int end_j = sc.nextInt();
			int end_i = sc.nextInt();
			
			for(int i=start_i; i<end_i; i++) {
				for(int j=start_j; j<end_j ; j++) {
					board[i][j] = -1;
				}
			}
		}
		
		Queue<Pair> que = new LinkedList<Pair>();
		int[][] visited  = new int[M][N];
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(board[i][j] == 0 && visited[i][j] == 0) {
					Pair p = new Pair(i,j);
					que.add(p);
					visited[i][j] = 1;
					visited = BFS(board, visited, que);
				}
			}
		}
		
		System.out.println(num);
		int[] res = new int[num];
		
		for(int i=0; i<num; i++) {
			res[i] = result[i];
		}
		Arrays.sort(res);
		for(int i=0; i<num; i++) {
			System.out.print(res[i] + " ");
		}
			
	}

}
