package baekjoon;
import java.util.*;

public class p1992 {
	static int N;
	static int[][] qtree;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		qtree = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String[]s = sc.nextLine().split("");
			for(int j=0; j<N; j++) {
				qtree[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		divideAndConquer(0,0,N);
	}
	
	static boolean isAble(int r, int c, int len) {
		int tmp = qtree[r][c];
		for(int i=r; i<r+len; i++) {
			for(int j=c; j<c+len; j++) {
				if(tmp!=qtree[i][j])
					return false;
			}
		}
		return true;
	}
	
	static void divideAndConquer(int r, int c, int len) {
		if(isAble(r,c,len))
			System.out.print(qtree[r][c]);
		else {
			int newlen = len/2;
			System.out.print("(");
			for(int i=0; i<2; i++) {
				for(int j=0; j<2; j++) {
					divideAndConquer(r+i*newlen, c+j*newlen, newlen);
				}
			}
			System.out.print(")");
		}
	}
}
