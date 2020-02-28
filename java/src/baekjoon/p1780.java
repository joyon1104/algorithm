package baekjoon;
import java.util.*;

public class p1780 {
	
	static int N;
	static int[] cnt = new int[3];
	static int[][] paper;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		paper = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				paper[i][j] = sc.nextInt();
			}
		}
		
		divideAndConquer(0,0,N);
		System.out.println(cnt[0]+ " "+cnt[1]+" "+cnt[2]);
	}
	
	static void divideAndConquer(int r, int c, int len) {
		if(isAble(r,c,len))
			cnt[paper[r][c]+1] +=1;
		else {
			int newlen = len/3;
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					divideAndConquer(r+newlen*i, c+newlen*j, newlen);
				}
			}
		}
	}
	
	static boolean isAble(int r, int c, int len) {
		int tmp = paper[r][c];
		for(int i=r; i<len+r; i++) { // ** i=r
			for(int j=c; j<len+c; j++) {  // j=c
				if(tmp!=paper[i][j])
					return false;
			}
		}
		return true;
	}
	
}