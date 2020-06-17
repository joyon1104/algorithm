package baekjoon;
import java.util.*;

public class p13460_2 {

	static class Pair{
		int i;
		int j;
		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	static void printboard(char[][] board){
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++)
				System.out.print(board[i][j]);
			System.out.println();
		}
		System.out.println("============");
	}
	
	static char[][] copy(char[][] board){
		char[][] tmp = new char[board.length][board[0].length];
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++)
				tmp[i][j] = board[i][j];
		}
		return tmp;
	}
	
	static int N,M,min;
	static Pair hole;
	static int[][] move = {{-1,0},{1,0},{0,-1},{0,1}}; // 위,아래,왼쪽,오른쪽
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ss = sc.nextLine();
		N = Integer.parseInt(ss.split(" ")[0]);
		M = Integer.parseInt(ss.split(" ")[1]);
		min = Integer.MAX_VALUE;
		Pair red = new Pair(0,0);
		Pair blue = new Pair(0,0);
		
		char[][] board = new char[N][M];
		for(int i=0; i<N; i++) {
			String s = sc.nextLine();
			for(int j=0; j<M; j++) {
				board[i][j] = s.charAt(j);
				if(board[i][j]=='R') 
					red = new Pair(i,j);
				else if(board[i][j]=='B')
					blue = new Pair(i,j);
				else if(board[i][j]=='O')
					hole = new Pair(i,j);
			}
		}
		
		int[] turn = new int[11];
		for(int i=0; i<4; i++) {
			if(board[red.i+move[i][0]][red.j+move[i][1]] == '#' && board[blue.i+move[i][0]][blue.j+move[i][1]] == '#')
				continue;
			turn[1] = i;
			dfs(board,turn,red,blue,1,1);
		}
		
		if(min == Integer.MAX_VALUE)
			min = -1;
		System.out.println(min);
	}
	
	static void dfs(char[][] board, int[] turn, Pair red, Pair blue, int idx, int cnt) {
		if(cnt==10) {
			solve(board, turn, red, blue);
		}
		else {
			for(int i=0; i<4; i++) {
				turn[idx+1] = i;
				dfs(board,turn,red,blue,idx+1,cnt+1);
			}
		}
	}
	
	static void solve(char[][] map, int[] turn, Pair red, Pair blue) {
		Pair R = new Pair(red.i,red.j);
		Pair B = new Pair(blue.i,blue.j);
		char[][] board = copy(map);
		
		for(int t=1; t<=10; t++) {
			if(t > min)
				return;
			int d = turn[t];
			if((d==0 && R.i<B.i) || (d==1 && R.i>B.i) || (d==2 && R.j<B.j) || (d==3 && R.j>B.j)) {
				board[R.i][R.j] = '.';
				R = relocate(R,board,d,'r');
				if(R.i!=hole.i || R.j!=hole.j)
					board[R.i][R.j] = 'R';
				board[B.i][B.j] = '.';
				B = relocate(B,board,d,'b');
				if(B.i!=hole.i || B.j!=hole.j) {
					board[B.i][B.j] = 'B';
					if(R.i==hole.i && R.j==hole.j) {
						if(min > t)
							min = t;
						return;
					}
				}
				else if(B.i==hole.i && B.j==hole.j)
					return;
				board[R.i][R.j] = 'R';
			}
			else {
				board[B.i][B.j] = '.';
				B = relocate(B,board,d,'b');
				if(B.i==hole.i && B.j==hole.j)
					return;
				board[B.i][B.j] = 'B';
				board[R.i][R.j] = '.';
				R = relocate(R,board,d,'r');
				if(R.i==hole.i && R.j==hole.j) {
					if(min > t)
						min = t;
					return;
				}
				board[R.i][R.j] = 'R';
			}
		}
	}
	
	static Pair relocate(Pair p, char[][]board, int d, char c) {
		Stack<Pair> stack = new Stack<>();
		stack.push(p);
		while(true) {
			Pair pa  = stack.peek();
			int next_i = pa.i+ move[d][0];
			int next_j = pa.j+ move[d][1];
			if(next_i<0 || next_j<0 || next_i>=N || next_j>=M)
				break;
			if(board[next_i][next_j]=='.') {
				stack.push(new Pair(next_i,next_j));
			}
			else if(board[next_i][next_j]=='O') {
				stack.push(new Pair(next_i,next_j));
				break;
			}
			else
				break;
		}
		return stack.peek();
	}
}
