package SWEA;
import java.util.*;

public class p4012 {
	static int min;
	
	public static void dfs(int[][] board, ArrayList<Integer> A, int idx, int cnt) {
		if(cnt==board.length/2) {
			solve(board,A);
			return;
		}
		else {
			for(int i=idx+1; i<board.length; i++) {
				A.add(i);
				dfs(board,A,i,cnt+1);
				A.remove(cnt);
			}
		}
	}

	public static void solve(int[][] board,ArrayList<Integer> A) {
		ArrayList<Integer> B = new ArrayList<>();
		int idx=0;
		for(int i=0; i<board.length; i++) {
			if(idx<A.size() && A.get(idx) == i)
				idx++;
			else
				B.add(i);
		}
		int sum1 = 0;
		int sum2 = 0;
		for(int i=0; i<A.size(); i++) {
			for(int j=0; j<A.size(); j++) {
				sum1 += board[A.get(i)][A.get(j)];
				sum2 += board[B.get(i)][B.get(j)];
			}
		}
		int result = (sum1>sum2?sum1-sum2:sum2-sum1);
		if(result < min)
			min = result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int[][] board = new int[N][N];
			min = 90000000;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<=N/2; i++) {
				ArrayList<Integer> tmp = new ArrayList<>();
				tmp.add(i);
				dfs(board,tmp, i, 1);
			}
			System.out.println("#"+t+" "+min);
		}
	}
}
