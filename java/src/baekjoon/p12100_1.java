package baekjoon;
import java.util.*;

public class p12100_1 {
	static int N;
	static int max;

	public static int[][] makeBoard(int[][] board, int dict){
		int[][] result = new int[N][N];
		for(int j=0; j<N; j++) {
			ArrayList<Integer> arrlist = new ArrayList<>();
			Queue<Integer> que = new LinkedList<Integer>();
			if(dict==0) {
				for(int i=0; i<N; i++) {
					if(board[i][j] != 0)
						arrlist.add(board[i][j]);
				}
				for(int k=0; k<arrlist.size(); k++) {
					if(k+1 < arrlist.size() && arrlist.get(k)==arrlist.get(k+1)) {
						que.offer(arrlist.get(k)+arrlist.get(k+1));
						k++;
					}
					else {
						que.offer(arrlist.get(k));
					}
				}
				int idx=0;
				while(!que.isEmpty()) {
					if(max < que.peek())
						max = que.peek();
					result[idx++][j] = que.poll();
				}
			}
			else if(dict==1) {
				for(int i=0; i<N; i++) {
					if(board[i][j] != 0)
						arrlist.add(board[i][j]);
				}
				for(int k=arrlist.size()-1; k>=0; k--) {
					if(k-1>=0 && arrlist.get(k)==arrlist.get(k-1)) {
						que.offer(arrlist.get(k)+arrlist.get(k-1));
						k--;
					}
					else {
						que.offer(arrlist.get(k));
					}
				}
				int idx=N-1;
				while(!que.isEmpty()) {
					if(max < que.peek())
						max = que.peek();
					result[idx--][j] = que.poll();
				}
			}
			else if(dict==2) {
				for(int i=0; i<N; i++) {
					if(board[j][i] != 0)
						arrlist.add(board[j][i]);
				}
				for(int k=0; k<arrlist.size(); k++) {
					if(k+1 < arrlist.size() && arrlist.get(k)==arrlist.get(k+1)) {
						que.offer(arrlist.get(k)+arrlist.get(k+1));
						k++;
					}
					else {
						que.offer(arrlist.get(k));
					}
				}
				int idx=0;
				while(!que.isEmpty()) {
					if(max < que.peek())
						max = que.peek();
					result[j][idx++] = que.poll();
				}
			}
			else if(dict==3) {
				for(int i=0; i<N; i++) {
					if(board[j][i] != 0)
						arrlist.add(board[j][i]);
				}
				for(int k=arrlist.size()-1; k>=0; k--) {
					if(k-1>=0 && arrlist.get(k)==arrlist.get(k-1)) {
						que.offer(arrlist.get(k)+arrlist.get(k-1));
						k--;
					}
					else {
						que.offer(arrlist.get(k));
					}
				}
				int idx=N-1;
				while(!que.isEmpty()) {
					if(max < que.peek())
						max = que.peek();
					result[j][idx--] = que.poll();
				}
			}
		}
		return result;
	}
	
	public static void solve(int[][] board, int cnt, String s) {
		if (cnt>4) {
			if(s.contains("0302")) {
			for(int p=0; p<N; p++) {
				for(int q=0; q<N; q++)
					System.out.print(board[p][q]+" ");
				System.out.println();
			}
			System.out.println(s+"----------"+cnt);
			}
			return;
		}
		else {
			for(int i=0; i<4; i++) {
				int[][] tmpboard = makeBoard(board,i);
				solve(tmpboard,cnt+1,s+i);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		max = 0;
		int[][] board = new int[N][N];
		for(int i=0; i<N; i++) {
			String s = sc.nextLine();
			for(int j=0; j<N; j++) {
				board[i][j] = Integer.parseInt(s.split(" ")[j]);
			}
		}
		solve(board,0,"");
		System.out.println(max);
	}
}
