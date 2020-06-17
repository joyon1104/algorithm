package baekjoon;
import java.util.*;

public class p3190_1 {
	static class Pair{
		int i;
		int j;
		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] board = new int[N+1][N+1];
		for(int k=0; k<K; k++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			board[a][b] = 1;
		}
		int L = sc.nextInt();
		HashMap<Integer, String> hm = new HashMap<>();
		for(int l=0; l<L; l++) {
			int key = sc.nextInt();
			String val = sc.next();
			hm.put(key,val);
		}
		ArrayList<Pair> snake = new ArrayList<>();
		int direct = 0;
		int time = 0;
		int[][] moved = {{0,1},{0,-1},{1,0},{-1,0}};
		snake.add(new Pair(1,1));
		board[1][1] = -1;
		
		while(true) {
			time++;
			Pair head = snake.get(0);
			int next_i = head.i+moved[direct][0];
			int next_j = head.j+moved[direct][1];
			if(next_i <=0 || next_j <=0 || next_i >N || next_j>N)
				break;
			if(board[next_i][next_j]==-1)
				break;
			else if(board[next_i][next_j]==0) {
				board[next_i][next_j] = -1;
				snake.add(0,new Pair(next_i,next_j));
				board[snake.get(snake.size()-1).i][snake.get(snake.size()-1).j] = 0;
				snake.remove(snake.size()-1);
			}
			else if(board[next_i][next_j]==1) {
				board[next_i][next_j] = -1;
				snake.add(0,new Pair(next_i,next_j));
			}
			if(hm.containsKey(time)) {
				if(hm.get(time).equals("L")) {
					if(direct==0)
						direct=3;
					else if(direct==1)
						direct=2;
					else if(direct==2)
						direct=0;
					else
						direct=1;
				}
				else {
					if(direct==0)
						direct=2;
					else if(direct==1)
						direct=3;
					else if(direct==2)
						direct=1;
					else
						direct=0;
				}
			}
			
		}
		System.out.println(time);
	}
}
