package SWEA;

import java.util.*;

public class p4014 {
	
	static Scanner sc = new Scanner(System.in);
	static int T = 0;
	
	public static void main(String[] args) {
		T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int X = sc.nextInt();
			int result = 0;
			
			int[][] map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N-X; j++) {
					int start = j;
					int end = start + 1;
					if(map[i][start]-1 == map[i][end]) {
						int k=0;
						for(k=end+1; k<=end+X-1; k++) {
							if(map[i][end] != map[i][k]) {
								j = k-2;
								break;
							}
						}
						if(k>end+X-1) {
							j = k-2;
							result++;
						}
					}
				}
				for(int j=N-1; j>=X; j--) {
					int start = j;
					int end = start - 1;
					if(map[i][start]-1 == map[i][end]) {
						int k=0;
						for(k=end-1; k>=end-X+1; k--) {
							if(map[i][end] != map[i][k]) {
								j = k+2;
								break;
							}
						}
						if(k<end-X+1) {
							j = k+2;
							result++;
						}
					}
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N-X; j++) {
					int start = j;
					int end = start + 1;
					if(map[start][i]-1 == map[end][i]) {
						int k=0;
						for(k=end+1; k<=end+X-1; k++) {
							if(map[end][i] != map[k][i]) {
								j = k-2;
								break;
							}
						}
						if(k>end+X-1) {
							j = k-2;
							result++;
						}
					}
				}
				for(int j=N-1; j>=X; j--) {
					int start = j;
					int end = start - 1;
					if(map[start][i]-1 == map[end][i]) {
						int k=0;
						for(k=end-1; k>=end-X+1; k--) {
							if(map[end][i] != map[k][i]) {
								j = k+2;
								break;
							}
						}
						if(k<end-X+1) {
							j = k+2;
							result++;
						}
					}
				}
			}
			System.out.println("#"+t+" "+ result);
			
		}
	}

}
